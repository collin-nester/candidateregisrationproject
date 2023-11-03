package wow.cool.candidateregistrationproject.entity;

import wow.cool.candidateregistrationproject.entity.Helpers.DubiousId;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity
@Table(name="position_candidate_join")
public class Dubious {

    @EmbeddedId
    DubiousId id;

    @ManyToOne
    @MapsId("posId")
    @JoinColumn(name="position_id")
    private ActivePosition position;

    @ManyToOne
    @MapsId("candidateId")
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name="education")
    private String education;

    @Column(name="experience")
    private String experience;

    @Column(name="resume")
    private String resumeExtension;

    public Dubious() {}
    public Dubious(Candidate applyingCandidate, ActivePosition positionBeingAppliedFor) {
        candidate = applyingCandidate;
        position = positionBeingAppliedFor;
        id = new DubiousId(position.getId(), candidate.getId());
    }

    public DubiousId getId() {
        return id;
    }

    public void setId(DubiousId id) {
        this.id = id;
    }

    public ActivePosition getPosition() {
        return position;
    }

    public void setPosition(ActivePosition position) {
        this.position = position;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public Path getResume() {

        if (resumeExtension != null && resumeExtension.trim() != "")
            return Paths.get(System.getProperty("java.io.tmpdir") + "Resumes\\",
                    candidate.getId() + "+" + position.getId() + resumeExtension);
        else
            return null;

    }

    public String getResumeExtension() {
        return resumeExtension;
    }

    public void setResumeExtension(String resumeExtension) {
        this.resumeExtension = resumeExtension;
    }

    @Override
    public String toString() {
        return "Dubious{" +
                "position=" + position +
                ", candidate=" + candidate +
                ", education='" + education + '\'' +
                ", experience='" + experience + '\'' +
                ", resumeExtension='" + resumeExtension + '\'' +
                '}';
    }

}
