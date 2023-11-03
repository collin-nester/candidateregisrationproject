package wow.cool.candidateregistrationproject.controller.Helpers;

import wow.cool.candidateregistrationproject.controller.HomeController;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.entity.Notification;
import wow.cool.candidateregistrationproject.service.CandidateService;
import wow.cool.candidateregistrationproject.service.NotificationService;

public class SendNotification {

    public void sendNotification(int notifId, Candidate user, NotificationService service, CandidateService candidateService) {
        Notification notification = service.getNotificationById(notifId).get();
        user.addNotification(notification);
        candidateService.saveCandidate(user);
        HomeController.setCurrentUser(user);
    }

    public void sendNotification(String header, String body, Candidate user, NotificationService service, CandidateService candidateService) {
        Notification notification = new Notification(header, body);
        service.saveNotification(notification);
        user.addNotification(notification);
        candidateService.saveCandidate(user);
        HomeController.setCurrentUser(user);
    }

}