package wow.cool.candidateregistrationproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wow.cool.candidateregistrationproject.entity.Candidate;
import wow.cool.candidateregistrationproject.repo.CandidateRepo;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    CandidateRepo repo;

    public Candidate changeUsername(long id, String newUsername){
        Candidate candidate = repo.findById(id).orElse(null);
        candidate.setUsername(newUsername);
        repo.save(candidate);
        return candidate;
    }

    public Candidate changePassword(long id, String newPassword){
        Candidate candidate = repo.findById(id).orElse(null);
        candidate.setPassword(newPassword);
        repo.save(candidate);
        return candidate;
    }

    public Candidate changeEmail(long id, String newEmail){
        Candidate candidate = repo.findById(id).orElse(null);
        candidate.setEmail(newEmail);
        repo.save(candidate);
        return candidate;
    }

    public List<Candidate> getAllCandidates(){
        return repo.findAll();
    }

    public Candidate getCandidateById(long id){
        return repo.findById(id).orElse(null);
    }

    public Candidate saveCandidate(Candidate candidate){
        return repo.save(candidate);
    }

    public void deleteCandidateById(Long id){
        repo.deleteById(id);
    }

    public Candidate findByUsername(String username) {
        return repo.findByUsername(username).get();
    }

}
