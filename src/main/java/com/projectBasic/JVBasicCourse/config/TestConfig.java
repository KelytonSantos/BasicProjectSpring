package com.projectBasic.JVBasicCourse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;

import com.projectBasic.JVBasicCourse.entities.Category;
import com.projectBasic.JVBasicCourse.entities.Order;
import com.projectBasic.JVBasicCourse.entities.Product;
import com.projectBasic.JVBasicCourse.entities.User;
import com.projectBasic.JVBasicCourse.entities.enums.OrderStatus;
import com.projectBasic.JVBasicCourse.repositories.CategoryRepository;
import com.projectBasic.JVBasicCourse.repositories.OrderRepository;
import com.projectBasic.JVBasicCourse.repositories.ProductRepository;
import com.projectBasic.JVBasicCourse.repositories.UserRepository;

@Configuration
// @Profile("test")//falando que minha classe só rodara em perfil de teste
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null,"Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null,"Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null,"PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria","m@gmail.com","9888888","158538");
        User u2 = new User(null, "joao","t@gmail.com","4863524","657324");
        User u3 = new User(null, "lucas","s@gmail.com","542186354","683574");
        User u4 = new User(null, "santos","w@gmail.com","65678524","968374");

        Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:02Z"),OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2022-06-05T19:53:05Z"),OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2022-06-06T19:53:09Z"),OrderStatus.WAITING_PAYMENT,u3);//É possivel ver a associação entre pedido e usuario
        Order o4 = new Order(null, Instant.parse("2022-06-08T19:53:06Z"),OrderStatus.DELIVERED,u4);
        Order o5 = new Order(null, Instant.parse("2022-06-19T19:53:08Z"),OrderStatus.CANCELED,u1);


        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4)); //aqui eu salvo o meu u1 e u2 como lista
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));

    }
}