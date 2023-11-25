package com.geeksforless.tfedorenko.persistence.repository.user;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends UserRepository<Doctor>{
    boolean existsByEmail(String email);

}
