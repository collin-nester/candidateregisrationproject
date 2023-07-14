package wow.cool.candidateregistrationproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.DubiousId;

public interface DubiousRepo extends JpaRepository<Dubious, Long> {}