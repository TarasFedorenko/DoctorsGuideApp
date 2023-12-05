package com.geeksforless.tfedorenko.persistence.repository.user;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends UserRepository<Doctor>{
    boolean existsByEmail(String email);

    Optional<Doctor> findByEmail(String email);

}
