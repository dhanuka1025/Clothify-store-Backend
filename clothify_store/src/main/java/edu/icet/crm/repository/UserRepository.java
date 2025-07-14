package edu.icet.crm.repository;

import edu.icet.crm.model.User;
import edu.icet.crm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    User findByEmail(String email);
}
