package br.com.zbsistemas.ZBFitCalculator.Controllers;

import br.com.zbsistemas.ZBFitCalculator.dtos.FoodRecordDto;
import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import br.com.zbsistemas.ZBFitCalculator.repositories.FoodRepository;
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
    FoodRepository foodRepository;

    @PostMapping("/foods")
    public ResponseEntity<FoodModel> saveFood(@RequestBody @Valid FoodRecordDto foodRecordDto) {
        var foodModel = new FoodModel();
        BeanUtils.copyProperties(foodRecordDto, foodModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodRepository.save(foodModel));
    }

    @GetMapping("/foods")
    public ResponseEntity<List<FoodModel>> getAllFoods() {
        return ResponseEntity.status(HttpStatus.OK).body(foodRepository.findAll());
    }

    @GetMapping("/foods/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<FoodModel> obj = foodRepository.findById(id);
        if (obj.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(obj.get());
    }

    @PutMapping("/foods/{id}")
    public ResponseEntity<Object> updateFoodById(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid FoodRecordDto foodRecordDto) {
        Optional<FoodModel> obj = foodRepository.findById(id);
        if (obj.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }

        var foodModel = obj.get();
        BeanUtils.copyProperties(foodRecordDto, foodModel);
        return ResponseEntity.status(HttpStatus.OK).body(foodRepository.save(foodModel));
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Object> deleteFoodById(@PathVariable(value = "id") Long id) {
        Optional<FoodModel> obj = foodRepository.findById(id);
        if (obj.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }

        foodRepository.delete(obj.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item " + obj.get().getName() + " deleted successfully");
    }
}
