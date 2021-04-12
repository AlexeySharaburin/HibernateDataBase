package ru.netology.hibernate_two_tables.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String date;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int amount;
}
