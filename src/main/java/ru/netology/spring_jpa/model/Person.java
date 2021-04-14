package ru.netology.spring_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person implements Serializable {
//
//    @Id
//    @Column(nullable = false)
//    private String name;
////    @Id
//    @Column(nullable = false)
//    private String surname;
////    @Id
//    @Column(nullable = false)
//    private int age;

    @EmbeddedId
    private ComposeId composeId;

    @Embedded
    private Contact contact;

    @Column(nullable = false)
    private String city;
}
