package kg.attaractor.exam7.service;


import kg.attaractor.exam7.model.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientAuthService implements UserDetailsService {

    @Autowired
    private UserService cs;

    @Override
    public UserClient loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserClient> user  = Optional.ofNullable(cs.getClientByName(s));
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return user.get();
    }
}
