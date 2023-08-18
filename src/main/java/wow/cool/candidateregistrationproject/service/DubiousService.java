package wow.cool.candidateregistrationproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.DubiousId;
import wow.cool.candidateregistrationproject.repo.DubiousRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class DubiousService {

    @Autowired
    DubiousRepo repo;

    public Dubious saveDubious(Dubious dubious) {
        return repo.save(dubious);
    }

    public Dubious findByDubiousId(DubiousId dubiousId) {return repo.findById(dubiousId);}

    @Transactional
    public void deleteByDubiousId(DubiousId dubiousId) {
        repo.deleteById(dubiousId);
    }

    public ArrayList<Dubious> findAllByPositionId(long id) { return repo.findAllByPositionId(id); }

}
