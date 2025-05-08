package com.workintech.s18d2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vegetable", schema="fsweb")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotNull(message = "Vegetable name cannot be null")
    @Size(min=2, max=45, message="Vegetable name size must be between 2 and 45 characters")
    private String name;

    @Column(name="price")
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive value")
    private Double price;


    @Column(name="is_grown_on_tree")
    @NotNull(message = "isGrownOnTree flag cannot be null")
    private Boolean isGrownOnTree ;

    public void setGrownOnTree(boolean isGrownOnTree)
    {
        this.isGrownOnTree = isGrownOnTree;
    }

    public Boolean isGrownOnTree()
    {
        return isGrownOnTree;
    }
}