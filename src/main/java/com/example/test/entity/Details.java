package com.example.test.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@Embeddable
public class Details {

    private String name;
    private String surname;

    @Size(min=5, message = "Не меньше 5 знаков")
    private String password;
    @Transient
    private String passwordConfirm;

    private String phone;
    private String email;

    public Details() {
    }
}
