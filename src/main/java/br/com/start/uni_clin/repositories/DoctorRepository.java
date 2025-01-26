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
                        "WHERE LOWER(d.name) LIKE LOWER(:name%)")
    List<Doctor> findByName(@Param("name") String name);

    @NativeQuery("SELECT d.id, d.crm, d.email, d.name, d.phone " +
                    "FROM doctor d " +
                        "WHERE LOWER(d.crm) LIKE LOWER(%:crm%)")
    List<Doctor> findByCRM(@Param("crm") String crm);
}