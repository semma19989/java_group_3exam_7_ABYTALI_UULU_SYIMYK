package kg.attaractor.exam7.util;


import kg.attaractor.exam7.model.Food;
import kg.attaractor.exam7.model.Order;
import kg.attaractor.exam7.model.UserClient;
import kg.attaractor.exam7.model.institutions;
import kg.attaractor.exam7.repository.FoodRepository;
import kg.attaractor.exam7.repository.OrderRepository;
import kg.attaractor.exam7.repository.UserRepository;
import kg.attaractor.exam7.repository.institutionsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Preload {
    Random r = new Random();
    @Bean
    CommandLineRunner initDatabase(UserRepository cr, FoodRepository dr,
                                   OrderRepository or, institutionsRepository rr) {
        return (args) -> {
            cr.deleteAll();
            dr.deleteAll();
            or.deleteAll();
            rr.deleteAll();

            List<UserClient>clients = Stream.generate(UserClient::addClient)
                    .limit(20)
                    .collect(Collectors.toList());
            cr.saveAll(clients);

            List<institutions>institutions = Stream.generate(institutions::addRestaurant)
                    .limit(10)
                    .collect(Collectors.toList());
            rr.saveAll(institutions);

            List<Food>dishes = Stream.generate(Food::addDish)
                    .limit(30)
                    .collect(Collectors.toList());

            for (Food Food:Foodes)
                Food.setinstitutions(institutions.get(r.nextInt(10)));

            dr.saveAll(dishes);

            List<Order>orders = Stream.generate(Order::addOrder)
                    .limit(50)
                    .collect(Collectors.toList());
            for (Order order:orders) {
                order.setUsers(clients.get(r.nextInt(20)));
                order.setFoodes(dishes.get(r.nextInt(30)));
            }

            System.out.println("done");
        };
    }

}