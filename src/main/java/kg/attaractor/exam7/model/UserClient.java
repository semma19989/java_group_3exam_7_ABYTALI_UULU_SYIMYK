package kg.attaractor.exam7.model;


import kg.attaractor.exam7.util.GenerateData;
import kg.attaractor.exam7.util.Generator;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "Users")
@Data
@Builder
public class UserClient implements UserDetails {
    @Id
    private String id;
    private String name;
    private String mail;
    private String pass;

    public static UserClient addClient(){
        return UserClient.builder()
                .mail(GenerateData.randomEmail())
                .name(GenerateData.randomPersonName())
                .pass(Generator.makePassword())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return getMail();
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
