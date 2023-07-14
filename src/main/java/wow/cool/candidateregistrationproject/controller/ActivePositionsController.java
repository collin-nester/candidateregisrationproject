package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wow.cool.candidateregistrationproject.controller.Helpers.FormInfoCarrier;
import wow.cool.candidateregistrationproject.entity.ActivePosition;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.DubiousId;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;
import wow.cool.candidateregistrationproject.service.ActivePositionService;
import wow.cool.candidateregistrationproject.service.CandidateService;
import wow.cool.candidateregistrationproject.service.DubiousService;

import java.security.Principal;
import java.util.List;

@Controller
public class ActivePositionsController {

    @Autowired
    private ActivePositionService service;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateRepo candidateRepo;

    @Autowired
    private DubiousService dubiousService;

    @GetMapping("create_position")
    public String createPosition(Model model) {

        model.addAttribute("new_position", new ActivePosition());

        return "create_position";
    }

    @PostMapping("create_position")
    public String createPositionConfirmation(Model model, @ModelAttribute("new_position") ActivePosition newPosition){

        if (newPosition.getPositionName() != null & newPosition.getPositionDescription() != null){
            service.saveActivePosition(newPosition);
        }

        return "create_position_confirmation";
    }


    @GetMapping("position_application")
    public String positionApplication(Model model){

        List<ActivePosition> allActivePositions = service.getAllActivePositions();
        model.addAttribute("allActivePositions", allActivePositions);
        model.addAttribute("application_info", new FormInfoCarrier());

        return "position_application";
    }

    @PostMapping("position_application")
    public String positionApplicationConfirmation(Model model, @ModelAttribute("application_info") FormInfoCarrier formInfoCarrier,
                                                  Principal principal) {
        try {

            Candidate applyingCandidate = candidateRepo.findByUsername(principal.getName()).get();
            ActivePosition positionBeingAppliedFor = service.findActivePositionById(formInfoCarrier.getPositionId());

//            positionBeingAppliedFor.addCandidateToList(applyingCandidate);
//            service.saveActivePosition(positionBeingAppliedFor);

            DubiousId jointId = new DubiousId();
            jointId.setCandidateId(applyingCandidate.getId());
            jointId.setPosId(formInfoCarrier.getPositionId());

            Dubious joined = new Dubious();
            joined.setId(jointId);
            joined.setPosition(positionBeingAppliedFor);
            joined.setCandidate(applyingCandidate);
            joined.setEducation(formInfoCarrier.getEducation());
            joined.setExperience(formInfoCarrier.getExperience());
            dubiousService.saveDubious(joined);

            model.addAttribute("application_info", joined);

            return "position_application_confirmation";
        }
        catch (Exception e) {
            return "page_error";
        }
    }

    @GetMapping("list_applicants")
    public String listApplicants(Model model) {

        List<ActivePosition> allActivePositions = service.getAllActivePositions();

        model.addAttribute("activePositions", allActivePositions);
        model.addAttribute("posinfo", new Dubious());
        model.addAttribute("max_pos_id", service.findHighestID());

       return "list_applicants";
    }

    @PostMapping("list_applicants")
    public String applicantList(Model model, @ModelAttribute("posid") Integer position_id){

        try {
        List<Candidate> applicants = service.findActivePositionById(position_id).getCandidateList();

        model.addAttribute("position", service.findActivePositionById(position_id));
        model.addAttribute("candidates", applicants);
        model.addAttribute("total_applied", applicants.size());

        return "applicant_list";
        }
        catch (Exception e) {

            return "page_error";
        }
    }


}
