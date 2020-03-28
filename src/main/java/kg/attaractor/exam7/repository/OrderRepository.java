package kg.attaractor.exam7.repository;


import kg.attaractor.exam7.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order,String> {
}
