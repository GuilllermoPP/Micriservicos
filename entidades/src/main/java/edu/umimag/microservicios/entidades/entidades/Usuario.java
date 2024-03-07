package edu.umimag.microservicios.entidades.entidades;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique =true, nullable = false)
    private String username;
    private String password;

    @OneToMany(mappedBy = "usuarios")
    private ArrayList <Sugerencia> sugerencias;


    @ManyToMany
    @JoinTable(name="usuario_partidas",
        joinColumns =@JoinColumn(name="id_usuario",
            referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="id_partida",
            referencedColumnName = "id") )
    private ArrayList <Partida> partidas;
    @OneToMany(mappedBy = "usuarios")
    private ArrayList <Mensajes> Mensajes;

}
