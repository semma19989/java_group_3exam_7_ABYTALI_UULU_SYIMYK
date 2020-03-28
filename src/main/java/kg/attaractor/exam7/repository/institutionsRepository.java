package kg.attaractor.exam7.repository;


import kg.attaractor.exam7.model.institutions;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface institutionsRepository extends PagingAndSortingRepository<institutions,String> {
    institutions findRestaurantByName(String name);
}
