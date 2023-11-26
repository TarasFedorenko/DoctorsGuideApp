package com.geeksforless.tfedorenko;

import com.geeksforless.tfedorenko.persistence.entity.user.Admin;
import com.geeksforless.tfedorenko.persistence.repository.user.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class DoctorsGuideApplication {

    private final BCryptPasswordEncoder passwordEncoder;

    private final AdminRepository adminRepository;
    public static void main(String[] args) {
        SpringApplication.run(DoctorsGuideApplication.class,args);}

//        @EventListener(ApplicationReadyEvent.class)
//        public void testListener() {
//        String pass = "12345";
//        String hash = passwordEncoder.encode(pass);
//        Admin admin = new Admin();
//        admin.setEmail("admin@mail.com");
//
//        admin.setPassword(hash);
//        adminRepository.save(admin);
//    }

}