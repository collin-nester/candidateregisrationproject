package wow.cool.candidateregistrationproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wow.cool.candidateregistrationproject.entity.Dubious;
import wow.cool.candidateregistrationproject.entity.DubiousId;
import wow.cool.candidateregistrationproject.repo.DubiousRepo;

import java.util.List;

@Service
public class DubiousService {

    @Autowired
    DubiousRepo repo;

    public Dubious saveDubious(Dubious dubious) {
        return repo.save(dubious);
    }

    public Dubious findByDubiousId(DubiousId dubiousId) {return repo.findById(dubiousId);}

}
