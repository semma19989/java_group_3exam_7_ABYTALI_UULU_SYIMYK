package kg.attaractor.exam7.model;

import kg.attaractor.exam7.util.GenerateData;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "institutions")
@Data
@Builder
public class institutions {
    @Id
    private String id;
    private String name;
    private String description;

    public static institutions addRestaurant(){
        GenerateData.PlaceName gp = GenerateData.randomPlace();
        return institutions.builder()
                .name(gp.getName())
                .description(gp.getDescription())
                .build();
    }

    public static Object getId() {
    }

    public static Object getName() {

}

