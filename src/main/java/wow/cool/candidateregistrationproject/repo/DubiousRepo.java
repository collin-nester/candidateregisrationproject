package wow.cool.candidateregistrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.Helpers.DubiousId;

import java.util.ArrayList;

public interface DubiousRepo extends JpaRepository<Dubious, Long> {

    Dubious findById(DubiousId dubiousId);

    void deleteById(DubiousId dubiousId);

    ArrayList<Dubious> findAllByPositionId(long id);
}