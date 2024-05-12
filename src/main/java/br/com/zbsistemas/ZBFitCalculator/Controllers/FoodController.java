package br.com.zbsistemas.ZBFitCalculator.Controllers;

import br.com.zbsistemas.ZBFitCalculator.dtos.FoodRecordDto;
import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import br.com.zbsistemas.ZBFitCalculator.repositories.FoodRepository;
import br.com.zbsistemas.ZBFitCalculator.services.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/foods")
    public ResponseEntity<List<FoodModel>> getAllFoods() {
        return ResponseEntity.status(HttpStatus.OK).body(foodService.findAll());
    }

    @GetMapping("/foods/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(foodService.findById(id));
    }

    @PostMapping("/foods")
    public ResponseEntity<FoodModel> saveFood(@RequestBody @Valid FoodRecordDto foodRecordDto) {
        FoodModel foodModel = new FoodModel();
        BeanUtils.copyProperties(foodRecordDto, foodModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.save(foodModel));
    }

    @PutMapping("/foods/{id}")
    public Object updateFoodById(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid FoodRecordDto foodRecordDto) {
        FoodModel foodModel = new FoodModel();
        BeanUtils.copyProperties(foodRecordDto, foodModel);
        return foodService.update(id, foodModel);
    }

    @DeleteMapping("/foods/{id}")
    public String deleteFoodById(@PathVariable(value = "id") Long id) {
        return foodService.delete(id);
    }
}
