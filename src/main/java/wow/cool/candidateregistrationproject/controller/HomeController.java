package wow.cool.candidateregistrationproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private CandidateRepo candidateRepo;

    public static Candidate currentUser;

    @GetMapping({"/", "home"})
    public String home(Principal principal, Model model){
        if (principal != null)
            currentUser = candidateRepo.findByUsername(principal.getName()).get();
        else
            HomeController.currentUser = new Candidate();
        model.addAttribute("notifications", currentUser.getNotifications());
        return "home";
    }

}