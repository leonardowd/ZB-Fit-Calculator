package br.com.zbsistemas.ZBFitCalculator.repositories;

import br.com.zbsistemas.ZBFitCalculator.models.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<FoodModel, Long> {
}
