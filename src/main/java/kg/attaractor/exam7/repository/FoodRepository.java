package kg.attaractor.exam7.repository;


import kg.attaractor.exam7.model.Food;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodRepository extends PagingAndSortingRepository<Food,String> {
    Food findDishById(String id);
}
