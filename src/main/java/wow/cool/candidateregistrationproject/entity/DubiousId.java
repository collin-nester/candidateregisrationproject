package wow.cool.candidateregistrationproject.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DubiousId implements Serializable {

    public DubiousId() { }

    private long posId;
    private long candidateId;

    public long getPosId() {
        return posId;
    }

    public void setPosId(long posId) {
        this.posId = posId;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

}
