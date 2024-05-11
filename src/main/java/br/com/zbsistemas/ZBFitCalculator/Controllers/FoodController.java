package br.com.zbsistemas.ZBFitCalculator.Controllers;

import br.com.zbsistemas.ZBFitCalculator.dtos.FoodRecordDto;
import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import br.com.zbsistemas.ZBFitCalculator.repositories.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @PostMapping("foods")
    public ResponseEntity<FoodModel> saveFood(@RequestBody @Valid FoodRecordDto foodRecordDto) {
        var foodModel = new FoodModel();
        BeanUtils.copyProperties(foodRecordDto, foodModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodModel.save(foodModel));
    }

}
