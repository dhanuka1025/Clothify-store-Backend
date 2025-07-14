package edu.icet.crm.model;

import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {
    private Long id;
    private String name;
}