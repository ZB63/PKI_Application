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

    public User(String name, String joined, String lastvisit, Long counter) {
        this.name = name;
        this.joined = joined;
        this.lastvisit = lastvisit;
        this.counter = counter;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public String getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(String lastvisit) {
        this.lastvisit = lastvisit;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joined='" + joined + '\'' +
                ", lastvisit='" + lastvisit + '\'' +
                ", counter=" + counter +
                '}';
    }
}
