package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.DubiousId;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;
import wow.cool.candidateregistrationproject.service.CandidateService;

import java.security.Principal;


@Controller
public class CandidateController {

    @Autowired
    private CandidateService service;

    @Autowired
    private CandidateRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("candidate", new Candidate());
        return "candidate_registration";
    }

    @PostMapping("register")
    public String registrationConfirmation(Model model, @ModelAttribute("candidate") Candidate newCandidate){
        try {
            newCandidate.setPassword(passwordEncoder.encode(newCandidate.getPassword()));
            service.saveCandidate(newCandidate);
            model.addAttribute("candidate", newCandidate);
            return "registration_confirmation";
        }
        catch(Exception e){
            return "registration_error";
        }
    }

    @GetMapping("applied_positions")
    public String listAppliedPositions(Model model, Principal principal) {

        Candidate applicant = repo.findByUsername(principal.getName()).get();

        model.addAttribute("applicant", applicant);
        model.addAttribute("applied_positions", applicant.getPositionsAppliedFor());
        model.addAttribute("total_applied", applicant.getPositionsAppliedFor().size());

        return "applied_positions";
    }

    @GetMapping("applied_positions_lookup")
    public String appliedPositionsLookup(Model model) {

        model.addAttribute("application_info", new DubiousId());

        return "applied_positions_lookup";
    }

    @PostMapping("applied_positions_lookup")
    public String appliedPositions(Model model, @ModelAttribute("application_info") DubiousId applicationInfo) {

        try {
            Dubious applicantInfo = new Dubious();
            applicantInfo.setId(applicationInfo);
            Candidate applicant = applicantInfo.getCandidate();

            model.addAttribute("applicant", applicant);
            model.addAttribute("applied_positions", applicant.getPositionsAppliedFor());
            model.addAttribute("total_applied", applicant.getPositionsAppliedFor().size());

            return "applied_positions_list";
        }
        catch (Exception e) {

            return "page_error";
        }
    }

}