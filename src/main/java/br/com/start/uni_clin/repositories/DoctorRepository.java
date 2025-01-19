package br.com.start.uni_clin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.start.uni_clin.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
    @Query("SELECT d FROM doctor d\n" + //
                "WHERE d.name LIKE '%:name%'\n" + //
                    "OR d.crm LIKE '%:crm%';")
    Optional<Doctor> findByNameOrCrm(String name, String crm);
}