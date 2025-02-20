package br.com.start.medicare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.start.medicare.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
    @Query("SELECT d FROM Doctor d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Doctor> findByName(@Param("name") String name);

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.crm) LIKE LOWER(CONCAT('%', :crm, '%'))")
    List<Doctor> findByCRM(@Param("crm") String crm);
}