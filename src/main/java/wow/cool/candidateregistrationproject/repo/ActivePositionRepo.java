package wow.cool.candidateregistrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wow.cool.candidateregistrationproject.entity.ActivePosition;

@Repository
public interface ActivePositionRepo extends JpaRepository<ActivePosition, Long> {
}
