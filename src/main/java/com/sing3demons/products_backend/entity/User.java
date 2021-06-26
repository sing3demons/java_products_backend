package com.sing3demons.products_backend.entity;

import com.sing3demons.products_backend.model.MRegisterResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "m_user")
public class User  {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id;
    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

    private String civilId;

    @OneToOne(mappedBy = "user", orphanRemoval = true)
    private Social social;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Address> addresses;
}
