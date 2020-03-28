package kg.attaractor.exam7.service;


import kg.attaractor.exam7.dto.FoodDTO;

import kg.attaractor.exam7.model.Food;
import kg.attaractor.exam7.model.institutions;
import kg.attaractor.exam7.repository.FoodRepository;
import kg.attaractor.exam7.repository.institutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class FoodService {
    @Autowired
    FoodRepository dr;

    @Autowired
    institutionsRepository rr;

    public Iterable<FoodDTO> findDishes(@ApiIgnore Pageable pageable, String name){
        institutions restaurant = rr.findRestaurantByName(name);
        return dr.findAll(pageable).map(FoodDTO::from).filter(dishDTO -> restaurant.getId().equals(dishDTO.getinstitutionstId()));
    }
}
