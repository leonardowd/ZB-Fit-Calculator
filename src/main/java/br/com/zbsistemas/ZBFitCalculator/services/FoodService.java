package br.com.zbsistemas.ZBFitCalculator.services;

import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import br.com.zbsistemas.ZBFitCalculator.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public FoodModel save(FoodModel request) {
        return foodRepository.save(request);
    }

    public Object update(Long id, FoodModel request) {
            Optional<FoodModel> foodModel = foodRepository.findById(id);
            if (foodModel.isEmpty()) {
                return "Item not found";
            }
            foodModel.get().setName(request.getName());
            foodModel.get().setQtCalories(request.getQtCalories());
            return foodRepository.save(foodModel.get());
        }

    public String delete(Long id) {
        Optional<FoodModel> obj = foodRepository.findById(id);
        if (obj.isEmpty()) {
            return "Item not found";
        }

        try {
            foodRepository.deleteById(id);
            return "Item: " + obj.get().getName() + " deleted successfully";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
