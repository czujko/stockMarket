package com.ndynmate.stockmarket.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cartera {
    @Id
    @GeneratedValue
    private Long id_cartera;
}
