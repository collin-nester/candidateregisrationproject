package wow.cool.candidateregistrationproject.controller.Helpers;

import org.springframework.web.multipart.MultipartFile;
import wow.cool.candidateregistrationproject.entity.ActivePosition;
import wow.cool.candidateregistrationproject.entity.Candidate;

public class FormInfoCarrier {

    private ActivePosition position;
    private Candidate candidate;
    private int positionId;
    private int candidateId;
    private String experience;
    private String education;
    private boolean admin;
    private MultipartFile file;
    private boolean emailable;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEmailable() {
        return emailable;
    }

    public void setEmailable(boolean emailable) {
        this.emailable = emailable;
    }
}
