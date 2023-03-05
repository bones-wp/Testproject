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
