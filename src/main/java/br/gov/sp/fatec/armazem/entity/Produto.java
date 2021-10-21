package br.gov.sp.fatec.armazem.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Produto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pro_id")
    private Long id;

    @Column(name="pro_nome")
    private String nome;

    @Column(name="pro_peso")
    private Long peso;

    @Column(name="pro_volume")
    private Long volume;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getPeso() {
        return peso;
    }
    public void setPeso(Long peso) {
        this.peso = peso;
    }
    public Long getVolume() {
        return volume;
    }
    public void setVolume(Long volume) {
        this.volume = volume;
    }  
    
}
