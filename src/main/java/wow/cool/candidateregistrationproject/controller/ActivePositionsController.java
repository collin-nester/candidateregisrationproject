package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wow.cool.candidateregistrationproject.controller.Helpers.RegistrationInfo;
import wow.cool.candidateregistrationproject.entity.ActivePosition;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.service.ActivePositionService;
import wow.cool.candidateregistrationproject.service.CandidateService;

import java.util.List;

@Controller
public class ActivePositionsController {

    @Autowired
    private ActivePositionService service;

    @Autowired
    private CandidateService candidateService;

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


    @GetMapping("position_registration")
    public String positionRegistration(Model model){

        List<ActivePosition> allActivePositions = service.getAllActivePositions();
        model.addAttribute("allActivePositions", allActivePositions);
        model.addAttribute("registration_info", new RegistrationInfo());

        return "position_registration";
    }

    @PostMapping("position_registration")
    public String positionRegistrationConfirmation(Model model, @ModelAttribute("registration_info") RegistrationInfo registrationInfo) {
        try {

                    Candidate registeringCandidate = candidateService.getCandidateById(registrationInfo.applicantid);
                    ActivePosition positionBeingRegistered = service.findActivePositionById(registrationInfo.posid);

                    positionBeingRegistered.addCandidateToList(registeringCandidate);
                    service.saveActivePosition(positionBeingRegistered);

                    model.addAttribute("candidate", registeringCandidate.getName());
                    model.addAttribute("position", positionBeingRegistered.getPositionName());

                return "position_registration_confirmation";
        }
        catch (Exception e) {

            return "page_error";
        }
    }

    @GetMapping("list_registrees")
    public String listRegistrees(Model model) {

        List<ActivePosition> allActivePositions = service.getAllActivePositions();

        model.addAttribute("activePositions", allActivePositions);
        model.addAttribute("posinfo", new RegistrationInfo());
        model.addAttribute("max_pos_id", service.findHighestID());

       return "list_registrees";
    }

    @PostMapping("list_registrees")
    public String registreeList(Model model, @ModelAttribute("posid") Integer position_id){

        try {
        List<Candidate> registrees = service.findActivePositionById(position_id).getCandidateList();

        List<Candidate> candidates = service.findActivePositionById(position_id).getCandidateList();
        model.addAttribute("candidates", candidates);
        model.addAttribute("total_registered", registrees.size());

        return "registree_list";
        }
        catch (Exception e) {

            return "page_error";
        }
    }


}
