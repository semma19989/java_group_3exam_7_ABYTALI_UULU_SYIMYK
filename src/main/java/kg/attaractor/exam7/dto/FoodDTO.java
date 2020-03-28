package kg.attaractor.exam7.dto;


import jdk.jshell.Snippet;
import kg.attaractor.exam7.model.Food;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FoodDTO {
    private String id;
    private String name;
    private String type;
    private int price;
    private String restaurantId;

    public static FoodDTO from(Food Foodes){
        return builder()
                .id(Food.getId())
                .name(Food.getName())
                .type(Food.getType())
                .price(Food.getPrice())
                .restaurantId(Foodes.getinstitutions().getId())
                .build();
    }

}
