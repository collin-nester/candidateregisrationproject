package wow.cool.candidateregistrationproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="active_positions")
public class ActivePosition {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="position_name")
    private String positionName;

    @Column(name="position_description")
    private String positionDescription;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "position_candidate_join",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<Candidate> candidateList;

    public ActivePosition() {
    }

    public ActivePosition(String positionName, String positionDescription) {
        this.positionName = positionName;
        this.positionDescription = positionDescription;
    }

    @Override
    public String toString() {
        return "ActivePosition{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", positionDescription='" + positionDescription + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public void addCandidateToList(Candidate candidate) {

        if (candidateList == null) {
            candidateList = new ArrayList<>();
        }

        candidateList.add(candidate);
    }

}
