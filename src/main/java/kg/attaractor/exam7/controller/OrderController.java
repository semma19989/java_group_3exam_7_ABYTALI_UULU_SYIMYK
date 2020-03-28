package kg.attaractor.exam7.controller;


import kg.attaractor.exam7.annotations.ApiPageable;
import kg.attaractor.exam7.dto.OrderDTO;
import kg.attaractor.exam7.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiPageable
@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService os;

    public OrderController(OrderService os) {
        this.os = os;
    }

    @PostMapping()
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return os.createOrder(orderDTO);
    }
}
