package br.com.zbsistemas.ZBFitCalculator.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@Entity
@Table(name = "tb_food")
public class FoodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private UUID id;
    private String name;
    private Double qtCalories;

    public FoodModel() {
    }

    public FoodModel(String name, Double qtCalories) {
        this.name = name;
        this.qtCalories = qtCalories;
    }
}
