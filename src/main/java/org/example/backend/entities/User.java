package org.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User{
    @Id
    @Column
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String email;

}
