package com.ndynmate.stockmarket.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activo {
    @Id
    @GeneratedValue
    private Long idActivo;
}
