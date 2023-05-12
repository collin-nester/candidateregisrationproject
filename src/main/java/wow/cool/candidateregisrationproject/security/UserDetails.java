package wow.cool.candidateregisrationproject.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import wow.cool.candidateregisrationproject.entity.Candidate;

import java.util.Arrays;
import java.util.Collection;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String username;

    private String password;

    public UserDetails(Candidate user) {

        this.username = user.getUsername();
        this.password = user.getPassword();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("BASIC_ROLE"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
