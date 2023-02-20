package com.example.test.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Embeddable
public class Contacts {

    private String name;
    private String surname;
    private String phone;
    private String email;

    public Contacts() {
    }
}
