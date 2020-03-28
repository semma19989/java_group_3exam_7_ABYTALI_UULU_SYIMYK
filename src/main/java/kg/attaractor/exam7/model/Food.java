package kg.attaractor.exam7.model;
import kg.attaractor.exam7.util.GenerateData;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document(collection = "Foodes")
@Data
@Builder
public class Food {
    @Id
    private String id;
    private String name;
    private String type;
    private int price;
    @DBRef
    private institutions restaurant;

    public static Food addFood(){
        Random r = new Random();
        GenerateData.DishName gd = GenerateData.randomFood();

        return Food.builder()
                .name(gd.getName())
                .type(gd.getType())
                .price(20+r.nextInt(100))
                .build();
    }
}
