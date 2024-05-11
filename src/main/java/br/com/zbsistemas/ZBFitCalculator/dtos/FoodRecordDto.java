package br.com.zbsistemas.ZBFitCalculator.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodRecordDto(@NotBlank String name, @NotNull Double qtCalories) {
}
