package br.com.start.uni_clin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.start.uni_clin.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
    @NativeQuery("SELECT d.id, d.crm, d.email, d.name, d.phone " +
                    "FROM doctor d " +
                        "WHERE d.name LIKE :name% " +
                            "OR d.name LIKE %:name% " +
                                "AND d.crm LIKE %:crm%")
    List<Doctor> findByNameOrCrm(@Param("name") String name, @Param("crm") String crm);
}