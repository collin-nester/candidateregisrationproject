package wow.cool.candidateregistrationproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Notification {

    @Id
    @Column(name="notification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="notification_head")
    private String head;

    @Column(name="notification_body")
    private String body;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "candidate_notification_join", joinColumns = @JoinColumn(name = "notification_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private List<Candidate> candidates;

    public Notification(){}

    public Notification(long id, String head, String body) {
        this.id = id;
        this.head = head;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addCandidate(Candidate candidate) {
        if (candidates == null)
            candidates = new ArrayList<>();
        candidates.add(candidate);
    }

    public void addAllCandidates(List<Candidate> allCandidates) {
        candidates = allCandidates;
    }

}
