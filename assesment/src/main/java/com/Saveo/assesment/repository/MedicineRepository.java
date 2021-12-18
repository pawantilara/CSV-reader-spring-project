package com.Saveo.assesment.repository;

import com.Saveo.assesment.model.Medicine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
  List<Medicine> findByNameStartingWith(String prefix);
  Medicine findByUniqueCode(Integer value);
}
