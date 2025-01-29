package br.com.start.uni_clin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.start.uni_clin.entities.Doctor;
import br.com.start.uni_clin.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    
    @NativeQuery("SELECT p.id, p.email, p.name, p.phone " +
                    "FROM patient p " +
                        "WHERE LOWER(p.name) LIKE LOWER(%:name%)")
    List<Patient> findByName(@Param("name") String name);
}
