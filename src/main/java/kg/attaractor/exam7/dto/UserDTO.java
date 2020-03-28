package kg.attaractor.exam7.dto;


import kg.attaractor.exam7.model.UserClient;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private String id;
    private String name;
    private String mail;
    private String pass;

    public static UserDTO from(UserClient client){
        return builder()
                .id(UserClient.getId())
                .name(UserClient.getName())
                .mail(UserClient.getMail())
                .pass(UserClient.getPass())
                .build();
    }
}
