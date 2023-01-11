package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Tour {

    @GeneratedValue
    @Id
    private Long id;

    private String tourCode;

    @OneToMany
    private List<Order> orders;


    @Entity
    public static class Order {
        @GeneratedValue
        @Id
        private Long id;

        private String orderCode;
        private int positionOnTour;

    }
}
