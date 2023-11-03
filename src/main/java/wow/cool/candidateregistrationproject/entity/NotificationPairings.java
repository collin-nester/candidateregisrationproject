package wow.cool.candidateregistrationproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "candidate_notifications_join")
public class NotificationPairings {

    @ManyToOne
    @JoinColumn(name = "cand_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creation_order")
    private long orderingIndex;

    public NotificationPairings() {}

    public NotificationPairings(Candidate candidate, Notification notification, long orderingIndex) {
        this.candidate = candidate;
        this.notification = notification;
        this.orderingIndex = orderingIndex;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public long getorderingIndex() {
        return orderingIndex;
    }

    public void setorderingIndex(long orderingIndex) {
        this.orderingIndex = orderingIndex;
    }
}
