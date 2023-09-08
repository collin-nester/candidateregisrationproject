package wow.cool.candidateregistrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wow.cool.candidateregistrationproject.entity.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
}