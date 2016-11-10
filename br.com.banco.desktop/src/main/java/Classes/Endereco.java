/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author fabio
 */
public class Endereco {
    private String rua;
    private String bairro;
    private String complemento;
    private String numero;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    
    public Endereco() {
        
    }
    
    public Endereco(String rua, String numero,String complemento, 
            String bairro, String cidade,String estado, String pais, 
            String cep){
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
        this.numero = numero;
        this.pais = pais;
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "\nrua = " + this.rua + "\nbairro = " + this.bairro 
                + "\ncomplemento = " + this.complemento + "\nnumero = " + this.numero 
                + "\ncidade = " + this.cidade + "\nestado = " + this.estado 
                + "\npais = " + this.pais + "\ncep = " + this.cep + "\n";
    }
    
    
    
}
