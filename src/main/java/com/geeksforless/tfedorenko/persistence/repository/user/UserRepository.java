package com.geeksforless.tfedorenko.persistence.repository.user;

import com.geeksforless.tfedorenko.persistence.entity.user.User;
import com.geeksforless.tfedorenko.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository <U extends User> extends BaseRepository<U> {
    Optional<U> findByEmail(String email);
}
