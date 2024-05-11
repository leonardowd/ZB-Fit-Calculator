package br.com.zbsistemas.ZBFitCalculator.services;

import br.com.zbsistemas.ZBFitCalculator.dtos.FoodRecordDto;
import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import br.com.zbsistemas.ZBFitCalculator.repositories.FoodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public List<FoodModel> findAll() {
        return foodRepository.findAll();
    }

    public Object findById(Long id) {
        Optional<FoodModel> obj = foodRepository.findById(id);
        if (obj.isEmpty()) {
            return "Item not found";
        }
        return obj.get();
    }

    public FoodModel save(FoodModel foodModel) {
        return foodRepository.save(foodModel);
    }

    public FoodModel update(Long id, FoodRecordDto foodRecordDto) {
            Optional<FoodModel> obj = foodRepository.findById(id);
            var foodModel = obj.get();
            BeanUtils.copyProperties(foodRecordDto, foodModel);
            return foodRepository.save(foodModel);
        }

    public void delete(Long id) {
            foodRepository.deleteById(id);
    }
}
