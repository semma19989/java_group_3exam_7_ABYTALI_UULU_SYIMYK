package kg.attaractor.exam7.service;


import ch.qos.logback.core.net.server.Client;
import kg.attaractor.exam7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository cr;

    public Client getClientByName(String name){
        return cr.findClientByName(name);
    }
}
