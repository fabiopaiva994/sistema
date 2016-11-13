/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author fabio
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable{
    @Id
    private long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "rg", nullable = false)
    private String rg;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "endereco_fk")
    private Endereco endereco;
    @Column(name = "dataNasc", nullable = false)
    private Date dataNasc;
    @Column(name = "idade")
    private int idade;

    
    public Pessoa() {
        
    }
    
    public Pessoa(String nome, String rg, String cpf, String telefone,Date dataNasc,
            int idade, Endereco endereco) {
        this.idade = idade;
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.endereco = Endereco;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
