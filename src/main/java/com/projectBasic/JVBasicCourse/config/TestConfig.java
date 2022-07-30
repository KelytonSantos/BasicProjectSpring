package com.projectBasic.JVBasicCourse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;

import com.projectBasic.JVBasicCourse.entities.User;
import com.projectBasic.JVBasicCourse.repositories.UserRepository;

@Configuration
// @Profile("test")//falando que minha classe só rodara em perfil de teste
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria","m@gmail.com","9888888","158538");
        User u2 = new User(null, "joao","t@gmail.com","4863524","65732,4");
        User u3 = new User(null, "lucas","s@gmail.com","542186354","683574");
        User u4 = new User(null, "santos","w@gmail.com","65678524","968374");

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4)); //aqui eu salvo o meu u1 e u2 como lista
    }
}