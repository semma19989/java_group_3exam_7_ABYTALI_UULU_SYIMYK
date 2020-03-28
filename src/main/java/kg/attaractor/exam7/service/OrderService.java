package kg.attaractor.exam7.service;


import kg.attaractor.exam7.dto.OrderDTO;
import kg.attaractor.exam7.model.Food;
import kg.attaractor.exam7.model.Order;
import kg.attaractor.exam7.repository.FoodRepository;
import kg.attaractor.exam7.repository.OrderRepository;
import kg.attaractor.exam7.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class OrderService {

    @Autowired
    UserRepository cr;

    @Autowired
    FoodRepository dr;

    @Autowired
    OrderRepository or;

    public OrderDTO createOrder(OrderDTO orderDTO){
        User user = cr.findClientById(orderDTO.getUserId());
        Food food = dr.findDishById(orderDTO.getFoodId());
        Order order =Order.builder()
                .id(orderDTO.getId())
                .user(user)
                .food(food)
                .date(orderDTO.getDate())
                .build();
        or.save(order);
        return OrderDTO.from(order);
    }

    public Iterable<OrderDTO> findOrderByClientId(@ApiIgnore Pageable pageable, String id){
        return or.findAll(pageable).map(OrderDTO::from).filter(orderDTO -> id.equals(orderDTO.getUsertId()));
    }
}
