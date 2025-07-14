package edu.icet.crm.repository;

import edu.icet.crm.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity , Long> {
    RoleEntity findByName(String name);
}
