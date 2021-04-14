package ru.netology.spring_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Contact implements Serializable {
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
}
