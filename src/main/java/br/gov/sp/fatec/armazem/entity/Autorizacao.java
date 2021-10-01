package br.gov.sp.fatec.armazem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="aut_autorizacao")
public class Autorizacao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="aut_id")
    private Long id;

    @Column(name="aut_nome")
    private String nome;

    
}
