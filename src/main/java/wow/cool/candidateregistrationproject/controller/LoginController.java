package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private CandidateRepo candidateRepo;

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        if (principal != null)
            HomeController.currentUser = candidateRepo.findByUsername(principal.getName()).get();
        else
            HomeController.currentUser = new Candidate();
        model.addAttribute("notifications", HomeController.currentUser.getNotifications());
        return "login";
    }

}
