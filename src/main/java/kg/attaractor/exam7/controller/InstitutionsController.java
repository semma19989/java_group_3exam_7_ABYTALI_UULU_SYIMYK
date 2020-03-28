package kg.attaractor.exam7.controller;


import kg.attaractor.exam7.annotations.ApiPageable;
import kg.attaractor.exam7.dto.FoodDTO;
import kg.attaractor.exam7.dto.institutionsDTO;
import kg.attaractor.exam7.service.FoodService;
import kg.attaractor.exam7.service.InstitutionsService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiPageable
@RestController
@RequestMapping("/institutions")
public class InstitutionsController {

    InstitutionsService rs;
    FoodService ds;

    public InstitutionsController(InstitutionsService rs, FoodService ds) {
        this.rs = rs;
        this.ds = ds;
    }

    @GetMapping("/all")
    public Iterable<institutionsDTO> findAll(@ApiIgnore Pageable pageable){
        return rs.findAllRestaurant(pageable);
    }

    @GetMapping("/name/{name}/dishes")
    public Iterable<FoodDTO> findDishesByRestaurantName(@ApiIgnore Pageable pageable, @PathVariable("name") String name){
        return ds.findFoodes(pageable,name);
    }
}
