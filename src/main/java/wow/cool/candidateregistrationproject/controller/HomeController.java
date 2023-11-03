package wow.cool.candidateregistrationproject.controller;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Notification;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CandidateRepo candidateRepo;

    private static Candidate currentUser = new Candidate();
    private static List<Notification> currentUserNotifications = new ArrayList<>();

    @GetMapping({"/", "home"})
    public String home(Principal principal, Model model){
        if (principal != null) {
            currentUser = candidateRepo.findByUsername(principal.getName()).get();
            HomeController.setCurrentUserNotifications(currentUser.getNotifications());
        }
        else
            HomeController.currentUser = new Candidate();
        model.addAttribute("notifications", currentUserNotifications);
        return "home";
    }

    public static Candidate getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Candidate currentUser) {
        HomeController.currentUser = currentUser;
        setCurrentUserNotifications(currentUser.getNotifications());
    }

    public static List<Notification> getCurrentUserNotifications() {
        return currentUserNotifications;
    }

    public static void setCurrentUserNotifications(List<Notification> currentUserNotifications) {
        List<Notification> reversedNotifications = new ArrayList<>();
        for (Notification i : currentUserNotifications)
            reversedNotifications.add(0, i);
        HomeController.currentUserNotifications = reversedNotifications;
    }
}