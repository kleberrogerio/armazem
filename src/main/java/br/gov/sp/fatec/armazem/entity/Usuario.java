package br.gov.sp.fatec.armazem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usr_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usr_id")
    private Long id;

    @Column(name="usr_nome")
    private String nome;

    @Column(name="usr_email")
    private String email;

    @Column(name="usr_senha")
    private String senha;

   
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="uau_usuario_autorizacao",
        joinColumns = {@JoinColumn(name="usr_id")},
        inverseJoinColumns = {@JoinColumn(name="aut_id")})
    private Set<Autorizacao> Autorizacoes;
    
    public Set<Autorizacao> getAutorizacoes() {
        return Autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        Autorizacoes = autorizacoes;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
