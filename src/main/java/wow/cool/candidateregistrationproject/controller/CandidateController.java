package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wow.cool.candidateregistrationproject.controller.Helpers.FormInfoCarrier;
import wow.cool.candidateregistrationproject.controller.Helpers.SendEmail;
import wow.cool.candidateregistrationproject.entity.ActivePosition;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.Helpers.DubiousId;
import wow.cool.candidateregistrationproject.repo.ActivePositionRepo;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;
import wow.cool.candidateregistrationproject.service.ActivePositionService;
import wow.cool.candidateregistrationproject.service.CandidateService;
import wow.cool.candidateregistrationproject.service.DubiousService;

import java.io.OutputStream;
import java.nio.file.Files;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CandidateController {

    @Autowired
    private CandidateService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DubiousService dubiousService;
    @Autowired
    private ActivePositionRepo activePositionRepo;
    @Autowired
    private ActivePositionService activePositionService;
    @Autowired
    private CandidateRepo candidateRepo;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("candidate", new Candidate());
        model.addAttribute("forminfocarrier", new FormInfoCarrier());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());
        return "candidate_registration";
    }

    @PostMapping("register")
    public String registrationConfirmation(Model model, @ModelAttribute("forminfocarrier") FormInfoCarrier formInfoCarrier){
        try {
            Candidate newCandidate = formInfoCarrier.getCandidate();
            newCandidate.setPassword(passwordEncoder.encode(newCandidate.getPassword()));
            if (formInfoCarrier.isAdmin()){
                newCandidate.setRole("ROLE_ADMIN");
            }
            newCandidate.setEmailable(formInfoCarrier.isEmailable());
            service.saveCandidate(newCandidate);
            if (newCandidate.isEmailable()) {
                String message = "Welcome to the GeekSI application platform, " + newCandidate.getName() +
                        ". Feel free to submit your applications under the Position Application tab.";
                SendEmail.sendEmail("Welcome to GeekSI", message, newCandidate.getEmail());
            }
            model.addAttribute("candidate", newCandidate);
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());

            return "registration_confirmation";
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());
            return "registration_error";
        }
    }

    @GetMapping("applied_positions")
    public String listAppliedPositions(Model model, Principal principal) {

        Candidate applicant = service.findByUsername(principal.getName());
        long candidateId = applicant.getId();

        List<ActivePosition> positionsAppliedFor = applicant.getPositionsAppliedFor();
        List<Dubious> applicationList = new ArrayList<>();

        for (ActivePosition position:positionsAppliedFor) {

            long positionId = position.getId();
            DubiousId id = new DubiousId(positionId, candidateId);
            applicationList.add(dubiousService.findByDubiousId(id));

        }

        model.addAttribute("notifications", applicant.getNotifications());
        model.addAttribute("applicant", applicant);
        model.addAttribute("applications", applicationList);
        model.addAttribute("total_applied", applicant.getPositionsAppliedFor().size());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return "applied_positions";
    }

    @GetMapping("position_application")
    public String positionApplication(Model model){

        List<ActivePosition> allActivePositions = activePositionService.getAllActivePositions();
        model.addAttribute("allActivePositions", allActivePositions);
        model.addAttribute("application_info", new FormInfoCarrier());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return "position_application";
    }

    @PostMapping("position_application")
    public String positionApplicationConfirmation(Model model, @ModelAttribute("application_info") FormInfoCarrier formInfoCarrier) {
        try {
            //create and set values of object values
            Candidate applyingCandidate = HomeController.currentUser;
            ActivePosition positionBeingAppliedFor = activePositionService.findActivePositionById(formInfoCarrier.getPositionId());

            if (!applyingCandidate.getPositionsAppliedFor().contains(positionBeingAppliedFor)){
                positionBeingAppliedFor.addCandidateToList(applyingCandidate);
                activePositionService.saveActivePosition(positionBeingAppliedFor);
            }
            DubiousId jointId = new DubiousId(formInfoCarrier.getPositionId(), applyingCandidate.getId());
            Dubious joined = dubiousService.findByDubiousId(jointId);

            if (formInfoCarrier.getEducation() != null && !formInfoCarrier.getEducation().trim().equals(""))
                joined.setEducation(formInfoCarrier.getEducation());
            if (formInfoCarrier.getExperience() != null && !formInfoCarrier.getExperience().trim().equals(""))
                joined.setExperience(formInfoCarrier.getExperience());

            boolean hasNewResume = formInfoCarrier.getFile() != null;
            if (hasNewResume) {
                //check for matching file extensions: if matches, overwrite, if not, delete and write to new file
                String originalFileName = formInfoCarrier.getFile().getOriginalFilename();
                String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                if (joined.getResumeExtension() != null && !joined.getResumeExtension().equals(extension)) {
                    Files.delete(joined.getResume());
                }
                joined.setResumeExtension(extension);
                OutputStream outputStream = Files.newOutputStream(joined.getResume());
                outputStream.write(formInfoCarrier.getFile().getBytes());
                outputStream.close();
                joined.setResumeExtension(extension);
                model.addAttribute("original_filename", originalFileName);
            }
            dubiousService.saveDubious(joined);

            model.addAttribute("application_info", joined);
            if (formInfoCarrier.getExperience() != null || formInfoCarrier.getEducation() != null) {

                String message = "Your application for "
                        + positionBeingAppliedFor.getPositionName()
                        + " has been recieved! We look forward to getting to know you " +
                        "better through this application process.\n\n" +
                        "Best Regards, GeekSI";
                if (applyingCandidate.isEmailable())
                    SendEmail.sendEmail("Thanks for applying!", message, applyingCandidate.getEmail());

                if (positionBeingAppliedFor.getPositionCreator().isEmailable())
                    SendEmail.sendEmail("New Application",
                            applyingCandidate.getName() + " has applied for "
                                    + positionBeingAppliedFor.getPositionName()
                                    + ". Check it out on the My Postings page in the Admin Tools tab.",
                            positionBeingAppliedFor.getPositionCreator().getEmail());

                model.addAttribute("notifications", HomeController.currentUser.getNotifications());

                return "position_application_confirmation";
            }
            else if(hasNewResume) {
                model.addAttribute("notifications", HomeController.currentUser.getNotifications());
                return "resume_upload_confirmation";
            }
            else {
                model.addAttribute("notifications", HomeController.currentUser.getNotifications());
                return "page_error";
                }
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());
            return "page_error";
        }
    }

    @GetMapping("delete_application")
    public String deleteApplication(Model model, @RequestParam String positionId) {

        try {
            DubiousId idToBeDeleted = new DubiousId(Long.parseLong(positionId), HomeController.currentUser.getId());
            Dubious applicationToBeDeleted = dubiousService.findByDubiousId(idToBeDeleted);
            if (applicationToBeDeleted.getResumeExtension() != null)
                Files.delete(applicationToBeDeleted.getResume());
            dubiousService.deleteByDubiousId(idToBeDeleted);
            Candidate candidate = applicationToBeDeleted.getCandidate();
            if (candidate.isEmailable()) {
                String message = "You've succesfully withdrawn your application for "
                        + applicationToBeDeleted.getPosition() + ". But be sure to check" +
                        " out the other openings waiting for you. \n\n Best Regards, GeekSI";
                SendEmail.sendEmail("We're sad to see you go", message, candidate.getEmail());
            }
            model.addAttribute("position", activePositionService.findActivePositionById(Long.parseLong(positionId)));
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());
            return "delete_application_confirmation";
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());
            return "page_error";
        }
    }

    @GetMapping("upload_resume")
    public String uploadResume(Model model, @RequestParam String positionId) {

        model.addAttribute("position_id", positionId);
        model.addAttribute("form_info_carrier", new FormInfoCarrier());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return "upload_resume";
    }

    @PostMapping("upload_resume")
    public String processResumeUpload(Model model, Principal principal,
                                      @ModelAttribute("form_info_carrier") FormInfoCarrier formInfoCarrier,
                                      @RequestParam("positionId") String positionId) {

        formInfoCarrier.setCandidate(HomeController.currentUser);
        formInfoCarrier.setPosition(activePositionService.findActivePositionById(Long.parseLong(positionId)));

        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return positionApplicationConfirmation(model, formInfoCarrier);
    }

    @GetMapping("applied_positions_lookup")
    public String appliedPositionsLookup(Model model) {

        model.addAttribute("application_info", new DubiousId());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return "applied_positions_lookup";
    }

    @PostMapping("applied_positions_lookup")
    public String appliedPositions(Model model, @ModelAttribute("application_info") DubiousId applicationInfo) {

        try {
            Candidate applicant = service.getCandidateById(applicationInfo.getCandidateId());
            long candidateId = applicant.getId();

            List<ActivePosition> positionsAppliedFor = applicant.getPositionsAppliedFor();
            List<Dubious> applicationList = new ArrayList<>();

            for (ActivePosition position:positionsAppliedFor) {

                long positionId = position.getId();
                DubiousId id = new DubiousId(positionId, candidateId);
                applicationList.add(dubiousService.findByDubiousId(id));

            }

            model.addAttribute("applicant", applicant);
            model.addAttribute("applications", applicationList);
            model.addAttribute("total_applied", positionsAppliedFor.size());
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());

            return "applied_positions_list";
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());
            return "page_error";
        }
    }

    @GetMapping("admin_tools")
    public String adminTools(Model model) {
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());
        if (HomeController.currentUser.getRole().equalsIgnoreCase("ROLE_ADMIN"))
            return "admin_tools";
        else
            return "access_denied";
    }

    @GetMapping("notifications")
    public String notifications(Model model) {
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());
        return "notifications";
    }

}