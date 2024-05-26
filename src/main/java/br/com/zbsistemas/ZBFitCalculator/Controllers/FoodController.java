package br.com.zbsistemas.ZBFitCalculator.Controllers;

import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import br.com.zbsistemas.ZBFitCalculator.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/alimentos")
    public String listFoods(Model model) {
        List<FoodModel> list = foodService.findAll();

        model.addAttribute("title", "Food list");
        model.addAttribute("foods", list);
        return "/views/foods/listFoods";
    }

    @GetMapping("/cadastrar")
    public String createFood(Model model) {
        FoodModel food = new FoodModel();

        model.addAttribute("title", "Formulário Cadastrar alimento");
        model.addAttribute("food", food);

       return "/views/foods/createFood";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute FoodModel food, BindingResult result, Model model) {
        foodService.save(food);
        return "redirect:/alimentos";
    }

    @PutMapping("/editar-alimento/{id}")
    public String updateFood(Model model, @PathVariable("id") Long id) {
        FoodModel food = (FoodModel) foodService.findById(id);

        model.addAttribute("title", "Formulário editar alimento");
        model.addAttribute("food", food);

        return "/save";
    }

    @DeleteMapping("/deletar-alimento/{id}")
    public String deleteFood(@PathVariable("id") Long id) {
        foodService.delete(id);
        System.out.println("Deleted sucessfully");

        return "redirect:/alimentos";
    }
}