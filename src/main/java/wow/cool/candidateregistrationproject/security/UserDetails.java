package wow.cool.candidateregistrationproject.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import wow.cool.candidateregistrationproject.entity.Candidate;

import java.util.Arrays;
import java.util.Collection;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String username;

    private String password;

    private long id;

    public UserDetails(Candidate user) {

        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public long getId() {
        return id;
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
