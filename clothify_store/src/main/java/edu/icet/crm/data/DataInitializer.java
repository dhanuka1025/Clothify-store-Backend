package edu.icet.crm.data;

import edu.icet.crm.repository.ProductRepository;
import edu.icet.crm.repository.RoleRepository;
import edu.icet.crm.repository.UserRepository;
import edu.icet.crm.model.Product;
import edu.icet.crm.model.Role;
import edu.icet.crm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles (if they don't exist)
        if (roleRepository.findByName("ADMIN").isEmpty()) {
            roleRepository.save(new Role("ADMIN"));
        }
        if (roleRepository.findByName("USER").isEmpty()) {
            roleRepository.save(new Role("USER"));
        }

        // Initialize admin user (if not exists)
        if (userRepository.findByEmail("admin@example.com").isEmpty()) {
            Role adminRole = roleRepository.findByName("ADMIN")
                    .orElseThrow(() -> new IllegalStateException("ADMIN role not found!"));
            User admin = new User();
            admin.setName("Admin User");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(adminRole);
            userRepository.save(admin);
        }

        // Initialize products (if empty)
        if (productRepository.count() == 0) {
            Product jacket = new Product();
            jacket.setName("Men's Jacket");
            jacket.setPrice(99.99);
            jacket.setCategory("Men");
            jacket.setPhoto("https://via.placeholder.com/150");
            productRepository.save(jacket);

        }
    }


//        // Initialize sample products
//        productRepository.save(new Product() {{
//            setName("Men's Jacket");
//            setPrice(99.99);
//            setCategory("Men");
//            setPhoto("https://via.placeholder.com/150"); // Placeholder for demo
//        }});
//        productRepository.save(new Product() {{
//            setName("Women's Dress");
//            setPrice(49.99);
//            setCategory("Women");
//            setPhoto("https://via.placeholder.com/150");
//        }});
//        productRepository.save(new Product() {{
//            setName("Kids' Shoes");
//            setPrice(29.99);
//            setCategory("Kids");
//            setPhoto("https://via.placeholder.com/150");
//        }});
}
}
