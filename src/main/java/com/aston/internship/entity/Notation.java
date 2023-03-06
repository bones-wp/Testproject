package com.aston.internship.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;

@Entity
@Table(name = "NOTATION")
@AllArgsConstructor
@Data

public class Notation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ServiceType serviceType;

    @Column(name = "Time")
    private Calendar calendar;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producer producer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne
    private Feedback feedback;

    public Notation() {

    }
}
