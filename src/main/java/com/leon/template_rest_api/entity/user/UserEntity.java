package com.leon.template_rest_api.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name="users")
@DynamicInsert
@DynamicUpdate
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",columnDefinition = "varchar(255)",nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255)", unique = true)
    private String userEmail;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;
}
