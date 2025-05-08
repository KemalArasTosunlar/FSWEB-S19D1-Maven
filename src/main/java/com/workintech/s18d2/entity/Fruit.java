package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="fruit", schema="fsweb")
public class Fruit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotNull(message = "name cannot be null")
    @Size(min=2, max=45, message="Fruit name size must be between 2 and 45 characters")
    private String name;

    @DecimalMin("10")
    @Column(name="price")
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive value")
    private Double price;

    @Column(name="fruit_type")
    @NotNull(message = "Fruit type cannot be null")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}