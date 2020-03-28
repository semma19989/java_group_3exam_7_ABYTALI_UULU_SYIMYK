package kg.attaractor.exam7.dto;


import jdk.jshell.Snippet;
import kg.attaractor.exam7.model.institutions;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class institutionsDTO {
    private String id;
    private String name;
    private String description;

    public static institutionsDTO from( institutions){
        return builder()
                .id(institutions.getId())
                .name(institutions.getName())
                .description(institutions.getDescription())
                .build();
    }

    private static Snippet builder() {
        return null;
    }
}
