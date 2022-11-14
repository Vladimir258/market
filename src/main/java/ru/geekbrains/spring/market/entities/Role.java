package ru.geekbrains.spring.market.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @CreationTimestamp
//    @Column(name = "created_at")
//    private LocalDateTime createAd;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private LocalDateTime updateAt;
}
