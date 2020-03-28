package kg.attaractor.exam7.repository;


import kg.attaractor.exam7.model.UserClient;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserClient,String> {
    UserClient findClientById(String id);
    UserClient findClientByName(String name);
}
