package br.com.start.uni_clin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.start.uni_clin.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}