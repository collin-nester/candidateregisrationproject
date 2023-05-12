package wow.cool.candidateregisrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wow.cool.candidateregisrationproject.controller.Helpers.RegistrationInfo;
import wow.cool.candidateregisrationproject.entity.Candidate;
import wow.cool.candidateregisrationproject.service.CandidateService;


@Controller
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("candidate", new Candidate());
        return "candidate_registration";
    }

    @PostMapping("register")
    public String registrationConfirmation(Model model, @ModelAttribute("candidate") Candidate newCandidate){
        try {
        service.saveCandidate(newCandidate);
        model.addAttribute("candidate", newCandidate.toString());
        return "registration_confirmation";
        }
        catch(Exception e){
            return "registration_error";
        }
    }

    @GetMapping("list_registered_positions")
    public String listRegisteredPositions(Model model) {

        RegistrationInfo registrationInfo = new RegistrationInfo();
        model.addAttribute("registration_info", registrationInfo);

        return "list_registered_positions";
    }

    @PostMapping("list_registered_positions")
    public String registeredPositionsList(Model model, @ModelAttribute("registration_info") RegistrationInfo registrationInfo) {

        try {
            Candidate registree = service.getCandidateById(registrationInfo.applicantid);

            model.addAttribute("registered_positions", registree.getPositionsAppliedFor());
            model.addAttribute("total_registered", registree.getPositionsAppliedFor().size());

            return "registered_positions_list";
        }
        catch (Exception e) {

            return "page_error";
        }
    }

}