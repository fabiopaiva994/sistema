/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.sound.midi.Patch;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author fabio
 */
public class Conta {

    private String numero;
    private String agencia;
    private double saldo;
    private String tipo;
    private String senha;
    private String email;
    private double rendaMensal;
    private boolean ativo;
    Cliente cli;

    public Conta() {

    }

    public Conta(String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cli) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.tipo = tipo;
        this.senha = senha;
        this.email = email;
        this.rendaMensal = rendaMensal;
        this.ativo = ativo;
        this.cli = cli;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        String aux = this.cli.toString() + "agencia = " + this.agencia + "\nnumero da conta = " + this.numero
                + "\ntipo = " + this.tipo + "\nsaldo = " + this.saldo + "\nsenha = " + this.senha
                + "\nemail = " + this.email + "\nRenda Mensal = " + this.rendaMensal + "\nAtivo = " + this.ativo;
        return aux;
    }

    public boolean criaPasta(String local, Object c) {

        try {
            String path = "C:\\Users\\FábioJunior\\Documents\\Contas\\" + local;
            boolean sucess = new java.io.File(path).mkdirs();
            if (!sucess) {
                JOptionPane.showMessageDialog(null, "Não Foi possivel criar a Conta", "", ERROR_MESSAGE);
                return false;
            }
            sucess = new java.io.File(path + "\\Extrato").mkdirs();
            if (!sucess) {
                JOptionPane.showMessageDialog(null, "Não foi possivel criar a Conta!");
                return false;
            }
            path = path += "/conta.txt";
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));

            buffWrite.append(c.toString());
            buffWrite.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel Criar a Conta no momento", "", ERROR_MESSAGE);
        } catch (Exception e) {

        }
        return false;
    }

    public static void visualizarArquivos(String conta) {
        try {
            String diretorio = "C:\\Users\\FábioJunior\\Documents\\Contas\\";
            boolean encontrou = false;
            File file = new File(diretorio);
            for (File f : file.listFiles()) {
                if (f.getName().equals(conta)) {

                    JOptionPane.showMessageDialog(null, "Encontrado");
                    encontrou = true;
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    while (br.ready()) {
                        JOptionPane.showMessageDialog(null, br.readLine());
                    }

                }

            }
            if (!encontrou) {
                JOptionPane.showMessageDialog(null, "Conta não Encontrada!!", "", ERROR_MESSAGE);
            }
        } catch (IOException e) {
            //JOptionPane.showMessageDialog(null, "Houve um problema, contate o suporte ou tente novamente!");
        }
    }
}
