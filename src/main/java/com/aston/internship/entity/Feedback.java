package com.aston.internship.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "FEEDBACK")
@Data
@AllArgsConstructor

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double stars;

    @Column(length = 10000)
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producer producer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne
    private Notation notation;

    public Feedback() {
    }
}
