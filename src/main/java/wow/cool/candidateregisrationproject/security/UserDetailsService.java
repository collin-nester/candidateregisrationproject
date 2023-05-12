package wow.cool.candidateregisrationproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wow.cool.candidateregisrationproject.entity.Candidate;
import wow.cool.candidateregisrationproject.repo.CandidateRepo;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    CandidateRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Candidate> user = repo.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        return user.map(UserDetails::new).get();
    }
}
