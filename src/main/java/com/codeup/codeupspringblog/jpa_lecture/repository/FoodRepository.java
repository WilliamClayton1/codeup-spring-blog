package com.codeup.codeupspringblog.jpa_lecture.repository;

import com.codeup.codeupspringblog.jpa_lecture.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
