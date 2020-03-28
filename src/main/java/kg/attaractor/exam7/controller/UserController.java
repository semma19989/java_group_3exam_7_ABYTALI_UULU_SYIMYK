package kg.attaractor.exam7.controller;


import kg.attaractor.exam7.annotations.ApiPageable;
import kg.attaractor.exam7.dto.OrderDTO;
import kg.attaractor.exam7.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiPageable
@RestController
@RequestMapping("/client")
public class UserController {
    OrderService os;

    public UserController(OrderService os) {
        this.os = os;
    }

    @GetMapping("/orders/{id}")
    public Iterable<OrderDTO> findOrder(@ApiIgnore Pageable pageable, @PathVariable("id") String id){
        return os.findOrderByClientId(pageable,id);
    }
}
