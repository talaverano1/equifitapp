package com.equifitapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="linea_orden")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private Double precioUnitario;

    @ManyToOne
    @Column(name = "orden_id", nullable = false)
    private Orden orden;

    @OneToOne(mappedBy = "lineaOrden")
    private Feedback feedback;

    @ManyToOne
    @Column(name ="producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false, length = 20)
    private String talleElegido;
}
