package com.student.repository;
import com.student.model.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundRepository extends JpaRepository<Ground,Integer> {
}
