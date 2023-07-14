package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wow.cool.candidateregistrationproject.entity.ActivePosition;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.DubiousId;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;
import wow.cool.candidateregistrationproject.repo.DubiousRepo;
import wow.cool.candidateregistrationproject.service.CandidateService;
import wow.cool.candidateregistrationproject.service.DubiousService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CandidateController {

    @Autowired
    private CandidateService service;
    @Autowired
    private CandidateRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DubiousService dubiousService;

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
            Candidate applicant = service.getCandidateById(applicationInfo.getCandidateId());

            List<ActivePosition> positionsAppliedFor = applicant.getPositionsAppliedFor();
            List<Dubious> applicationList = new ArrayList<>();

            for (ActivePosition position:positionsAppliedFor) {

                long positionId = position.getId();
                long candidateId = applicant.getId();
                DubiousId id = new DubiousId(positionId, candidateId);
                applicationList.add(dubiousService.findByDubiousId(id));

            }

            model.addAttribute("applicant", applicant);
            model.addAttribute("applied_positions", positionsAppliedFor);
            model.addAttribute("applications", applicationList);
            model.addAttribute("total_applied", positionsAppliedFor.size());

            return "applied_positions_list";
        }
        catch (Exception e) {

            return "page_error";
        }
    }

}