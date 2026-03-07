package com.equifitapp.entity;

import com.equifitapp.enums.TipoEquipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table (name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEquipo tipoEquipo;

    @Column(nullable = false, length = 20)
    private String talleComercial;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int stock;

    @ManyToMany
    @JoinTable(
            name = "producto_disciplina",
            joinColumns = @JoinColumns(name = "producto_id"),
            inverseJoinColumns = @JoinColumns(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas;

    @OneToMany(mappedBy = "producto")
    private Set<OrdenCompraProducto> ordenCompraProducto;
}
