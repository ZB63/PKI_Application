package com.pki.PKI.domain;

import javax.persistence.*;

@Entity
@Table(name="test")
public class Test {

    public Test() {
    }

    public Test(String text) {
        this.text = text;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="text")
    private String text;

    public String getValue() {
        return text;
    }

    public void setValue(String text) {
        this.text = text;
    }
}
