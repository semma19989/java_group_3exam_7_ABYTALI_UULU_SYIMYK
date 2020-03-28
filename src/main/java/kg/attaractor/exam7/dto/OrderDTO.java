package kg.attaractor.exam7.dto;


import kg.attaractor.exam7.model.Order;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {
    private String id;
    private String clientId;
    private String dishId;
    private LocalDateTime date;

    public static OrderDTO from (Order order){
        return builder()
                .id(order.getId())
                .clientId(order.getClient().getId())
                .dishId(order.getDish().getId())
                .date(order.getDate())
                .build();
    }
}
