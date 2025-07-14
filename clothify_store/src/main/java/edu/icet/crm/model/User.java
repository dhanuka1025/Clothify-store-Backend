package edu.icet.crm.model;

import edu.icet.crm.entity.RoleEntity;
import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;

    public void setRole(RoleEntity user) {

    }
}