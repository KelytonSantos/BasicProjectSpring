package com.projectBasic.JVBasicCourse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;

import com.projectBasic.JVBasicCourse.entities.Order;
import com.projectBasic.JVBasicCourse.entities.User;
import com.projectBasic.JVBasicCourse.repositories.OrderRepository;
import com.projectBasic.JVBasicCourse.repositories.UserRepository;

@Configuration
// @Profile("test")//falando que minha classe só rodara em perfil de teste
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria","m@gmail.com","9888888","158538");
        User u2 = new User(null, "joao","t@gmail.com","4863524","657324");
        User u3 = new User(null, "lucas","s@gmail.com","542186354","683574");
        User u4 = new User(null, "santos","w@gmail.com","65678524","968374");

        Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:02Z"),u1);
        Order o2 = new Order(null, Instant.parse("2022-06-05T19:53:05Z"),u2);
        Order o3 = new Order(null, Instant.parse("2022-06-06T19:53:09Z"),u3);//É possivel ver a associação entre pedido e usuario
        Order o4 = new Order(null, Instant.parse("2022-06-08T19:53:06Z"),u4);
        Order o5 = new Order(null, Instant.parse("2022-06-19T19:53:08Z"),u1);


        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4)); //aqui eu salvo o meu u1 e u2 como lista
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
    }
}