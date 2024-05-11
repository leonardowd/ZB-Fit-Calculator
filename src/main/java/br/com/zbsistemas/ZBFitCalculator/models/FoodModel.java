package br.com.zbsistemas.ZBFitCalculator.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter @Setter
@Entity
@Table(name = "tb_food")
public class FoodModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double qtCalories;

    public FoodModel() {
    }

    public FoodModel(String name, Double qtCalories) {
        this.name = name;
        this.qtCalories = qtCalories;
    }
}
