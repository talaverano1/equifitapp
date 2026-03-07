package com.equifitapp.entity;

import com.equifitapp.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "perfil_talle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfilTalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private TipoEquipo tipoEquipo;

    // ===== CAMPOS PARA BOTA =====
    @Enumerated(EnumType.STRING)
    private AlturaCania alturaCania;

    @Enumerated(EnumType.STRING)
    private Pantorrilla pantorrilla;

    private double nroTalle; //ver como trabajar talles mas adelante

    @Enumerated(EnumType.STRING)
    private Empeine empeine;

    // ===== CAMPOS PARA MONTURA =====
    private Double pesoUsuario;

    private Double alturaUsuario;

    @Enumerated(EnumType.STRING)
    private LargoFemur largoFemur;

    private Boolean rodillaFueraFlap;

    // ===== CAMPOS PARA CASCO =====
    private Double circunferenciaCabeza;

    @Enumerated(EnumType.STRING)
    private FormaCabeza formaCabeza;

    @Enumerated(EnumType.STRING)
    private ProfundidadCasco profundidadCasco;

}
