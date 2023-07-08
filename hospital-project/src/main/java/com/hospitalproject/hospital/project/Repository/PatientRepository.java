package com.hospitalproject.hospital.project.Repository;

import com.hospitalproject.hospital.project.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
