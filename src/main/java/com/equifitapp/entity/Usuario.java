package com.equifitapp.entity;

import com.equifitapp.enums.TipoDisciplina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, length = 40)
    private String nombre;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    private LocalDateTime fechaBaja;

    @ManyToMany
    @JoinTable(
            name = "usuario_producto",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productosPropios;

    @ElementCollection
    @CollectionTable(
            name = "usuario_disciplina",
            joinColumns = @JoinColumn(name = "usuario_id")
    )
    @Column(name = "disciplina")
    @Enumerated(EnumType.STRING)
    private Set<TipoDisciplina> disciplinas; //Cada usuario puede practicar varias disciplinas

    @OneToMany(mappedBy = "usuario")
    private Set<Caballo> caballos;
}
