package wow.cool.candidateregistrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wow.cool.candidateregistrationproject.entity.Candidate;

import java.util.Optional;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Long> {

Optional<Candidate> findByUsername(String username);

}
