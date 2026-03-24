package com.equifitapp.entity;

import com.equifitapp.enums.ResultadoFeedback;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "linea_orden_id", nullable = false)
    private LineaOrden lineaOrden;

    @Column(length = 500)
    private String descripcion;

    @ManyToOne
    @Column(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResultadoFeedback resultadoFeedback;

    @Column(nullable = false)
    private LocalDateTime fecha;
}
