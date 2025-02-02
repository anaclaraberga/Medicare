package br.com.start.uni_clin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.start.uni_clin.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    
    @Query("SELECT p FROM Patient p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Patient> findByName(@Param("name") String name);
}
