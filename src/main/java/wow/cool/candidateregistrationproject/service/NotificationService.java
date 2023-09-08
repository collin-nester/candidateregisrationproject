package wow.cool.candidateregistrationproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wow.cool.candidateregistrationproject.entity.Notification;
import wow.cool.candidateregistrationproject.repo.NotificationRepo;

@Service
public class NotificationService {

    @Autowired
    NotificationRepo repo;

    public void saveNotification(Notification notification) {
        repo.save(notification);
    }

    public Notification getNotificationById(long id) {
        return repo.findById(id).get();
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

}
