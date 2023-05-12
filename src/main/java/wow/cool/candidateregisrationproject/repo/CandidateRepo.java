package wow.cool.candidateregisrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wow.cool.candidateregisrationproject.entity.Candidate;

import java.util.Optional;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByUsername(String username);

}
