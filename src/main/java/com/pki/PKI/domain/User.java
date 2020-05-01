package com.pki.PKI.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="joined")
    private String joined;

    @Column(name="lastvisit")
    private String lastvisit;

    @Column(name="counter")
    private Long counter;
}
