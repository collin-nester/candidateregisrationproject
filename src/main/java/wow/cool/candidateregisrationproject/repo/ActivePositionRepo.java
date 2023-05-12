package wow.cool.candidateregisrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wow.cool.candidateregisrationproject.entity.ActivePosition;

@Repository
public interface ActivePositionRepo extends JpaRepository<ActivePosition, Long> {
}
