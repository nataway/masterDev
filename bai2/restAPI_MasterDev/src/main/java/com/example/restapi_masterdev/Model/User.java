package com.example.restapi_masterdev.Model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    unique=true
    @Column(name = "email")
    private String email;
    @Column(name = "password", length = 255)
    private String password;
}
