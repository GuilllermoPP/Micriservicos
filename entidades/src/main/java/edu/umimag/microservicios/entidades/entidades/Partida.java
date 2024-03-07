package edu.umimag.microservicios.entidades.entidades;


import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="partidas")
@Data

public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provicia;
    @Temporal(TemporalType.DATE)
    private LocalDateTime fecha;
    @Temporal(TemporalType.TIME)
    private LocalDateTime hora_comienzo;
    @Temporal(TemporalType.TIME)
    private LocalDateTime hora_final;
    private Integer participantes;
    private Integer suplentes;
    private String comentarios;
    @ManyToMany(mappedBy="partidas")
    private ArrayList <Usuario> usuarios;

}
