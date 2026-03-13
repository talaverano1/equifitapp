package com.equifitapp.entity;

import com.equifitapp.enums.Cruz;
import com.equifitapp.enums.Cuerpo;
import com.equifitapp.enums.FormaLomo;
import com.equifitapp.enums.LongitudDorso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caballos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caballo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cruz cruz;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cuerpo cuerpo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormaLomo formaLomo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LongitudDorso longitudDorso;
}
