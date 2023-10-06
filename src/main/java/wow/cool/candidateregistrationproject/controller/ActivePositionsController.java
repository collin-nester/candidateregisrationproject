package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wow.cool.candidateregistrationproject.controller.Helpers.FormInfoCarrier;
import wow.cool.candidateregistrationproject.controller.Helpers.SendEmail;
import wow.cool.candidateregistrationproject.entity.ActivePosition;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.Helpers.DubiousId;
import wow.cool.candidateregistrationproject.service.ActivePositionService;
import wow.cool.candidateregistrationproject.service.CandidateService;
import wow.cool.candidateregistrationproject.service.DubiousService;

import javax.servlet.ServletContext;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivePositionsController {

    @Autowired
    private ActivePositionService service;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private DubiousService dubiousService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("create_position")
    public String createPosition(Model model) {

        model.addAttribute("new_position", new ActivePosition());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return "create_position";
    }

    @PostMapping("create_position")
    public String createPositionConfirmation(Model model, @ModelAttribute("new_position") ActivePosition newPosition, Principal principal){

        if (newPosition.getPositionName() != null & newPosition.getPositionDescription() != null){
            Candidate creator = candidateService.findByUsername(principal.getName());
            newPosition.setPositionCreator(creator);
            service.saveActivePosition(newPosition);

            if (creator.isEmailable())
                SendEmail.sendEmail("You've created a position",
                        "You've successfully created the position " + newPosition.getPositionName() +
                                ". You can find your applicants in the My Postings section of the Admin Tools page.",
                        creator.getEmail());

            for (Candidate candidate : candidateService.getAllCandidates())
                if (candidate.isEmailable())
                    SendEmail.sendEmail("New Posting",
                            "An application for " + newPosition.getPositionName() + " has just opened up at GeekSI.",
                            candidate.getEmail());

            model.addAttribute("notifications", HomeController.currentUser.getNotifications());

            return "create_position_confirmation";
        } else {
            model.addAttribute("notifications", HomeController.currentUser.getNotifications());
            return "page_error";
        }

    }

    @GetMapping("list_applicants")
    public String listApplicants(Model model) {

        List<ActivePosition> allActivePositions = service.getAllActivePositions();

        model.addAttribute("activePositions", allActivePositions);
        model.addAttribute("posinfo", new FormInfoCarrier());
        model.addAttribute("max_pos_id", service.findHighestID());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

       return "list_applicants";
    }

    @PostMapping("list_applicants")
    public String applicantList(Model model, @ModelAttribute("positionId") Integer position_id){

        try {
        List<Candidate> applicants = service.findActivePositionById(position_id).getCandidateList();
        List<Dubious> applicationList = new ArrayList<>();

        for (Candidate applicant:applicants) {

            long candidateId = applicant.getId();
            DubiousId id = new DubiousId(position_id, candidateId);
            applicationList.add(dubiousService.findByDubiousId(id));
        }

        model.addAttribute("applications", applicationList);
        model.addAttribute("position", service.findActivePositionById(position_id));
        model.addAttribute("total_applied", applicants.size());
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());

        return "applicant_list";
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "page_error";
        }
    }

    @GetMapping(value = "resumes/{file_name}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("file_name") String fileName) {

        Candidate candidate = HomeController.currentUser;
        long candidateId = candidate.getId();
        long claimedCandidateId = Long.parseLong(fileName.substring(0, fileName.indexOf("+")));
        long positionId = Long.parseLong(fileName.substring(fileName.indexOf("+") + 1));

        if ( candidateId == claimedCandidateId || candidate.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
            Dubious application = dubiousService.findByDubiousId(new DubiousId(positionId, claimedCandidateId));
            String extension = application.getResumeExtension();
            return new FileSystemResource(Paths.get(System.getProperty("java.io.tmpdir"), "Resumes\\", fileName + extension));
        }
        else
            return null;
    }

    @GetMapping("my_postings")
    public String myPostings(Model model) {

        List<ActivePosition> positions = HomeController.currentUser.getPositionsCreated();

        long max = 0;
        for (ActivePosition i : service.getAllActivePositions())
            if (i.getId() > max)
                max = i.getId();

        model.addAttribute("created_positions", positions);
        model.addAttribute("posinfo", new FormInfoCarrier());
        model.addAttribute("max_pos_id", max);

        return "my_postings";
    }

    @PostMapping("delete_position")
    public String deletePosition(Model model, Principal principal, @ModelAttribute("posinfo") FormInfoCarrier formInfoCarrier) {

        ActivePosition positionToBeDeleted = service.findActivePositionById(formInfoCarrier.getPositionId());
        ArrayList<Dubious> deletedApplications = dubiousService.findAllByPositionId(positionToBeDeleted.getId());
        if (positionToBeDeleted.getPositionCreator().getUsername().equals(principal.getName())) {
            for (Dubious i : deletedApplications) {
                dubiousService.deleteByDubiousId(i.getId());
            }
            service.deleteById(positionToBeDeleted.getId());
            for (Dubious application : deletedApplications)
                if (application.getCandidate().isEmailable())
                    SendEmail.sendEmail("Position Filled", application.getPosition().getPositionName()
                            + " has been filled.",
                            application.getCandidate().getEmail());
        }
        else
            return "page_error";

        model.addAttribute("deleted_applications", deletedApplications);
        model.addAttribute("position", positionToBeDeleted);
        return "delete_position";
    }

}