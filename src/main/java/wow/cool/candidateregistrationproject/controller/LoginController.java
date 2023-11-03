package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Notification;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class LoginController {

    @Autowired
    private CandidateRepo candidateRepo;

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        if (principal != null) {
            HomeController.setCurrentUser(candidateRepo.findByUsername(principal.getName()).get());
        }
        else {
            HomeController.setCurrentUser(new Candidate());
            HomeController.setCurrentUserNotifications(new ArrayList<>());
        }
        model.addAttribute("notifications", HomeController.getCurrentUserNotifications());
        return "login";
    }

}
