/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Cliente;
import Classes.Endereco;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Date;
import java.util.StringTokenizer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author FábioJunior
 */
@Entity
@Table(name = "contacorrentelimitada")
@SequenceGenerator(name = "seqccl", sequenceName = "seq_ccl") 
public class ContaCorrenteLimitada extends Conta implements Serializable{
    private static final long serialVersionUID = -2L;
    
    @Column(name = "limite", nullable = false)
    private double limite;
    
    public ContaCorrenteLimitada(double limite,String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cliente) {
        super(numero, agencia, saldo, tipo, senha, email, rendaMensal, ativo, cliente);
        this.limite = limite;
    }
    
    public ContaCorrenteLimitada() {
        
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public double getLimite() {
        return this.limite;
    }    
    
    @Override
    public String toString() {
        return super.toString() + "\n" + "Limite = " + this.limite;
    }
    
    public static ContaCorrenteLimitada Leitura(String conta) {
        String linha = null;

        String cs = "C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta + "/conta.txt";

        try {

            FileReader reader = new FileReader(cs);

            BufferedReader leitor = new BufferedReader(reader);
            StringTokenizer st = null;

            String agencia = "";
            String numero = "";
            String tipo = "";
            String saldo = "";
            String senha = "";  
            String email = "";
            String nome = "";
            String rg = "";
            String cpf = "";
            String telefone = "";
            String rua = "";
            String bairro = "";
            String complemento = "";
            String numero2 = "";
            String cidade = "";
            String estado = "";
            String pais = "";
            String cep = "";
            String dataNasc = "";
            String idade = "";
            String a, b = "";
            String rendaMensal = "";
            String limite = "";
            String ativo = "";

            //loop para pular linha
            while ((linha = leitor.readLine()) != null) {

                st = new StringTokenizer(linha, "=");

                String dados;

                while (st.hasMoreTokens()) {

                    dados = st.nextToken();
                    a = dados;

                    dados = st.nextToken();
                    b = dados;

                    if (a.equals("agencia ")) {
                        agencia = b.trim();
                    } else if (a.equals("numero da conta ")) {
                        numero = b.trim();
                    } else if (a.equals("tipo ")) {
                        tipo = b.trim();
                    } else if (a.equals("saldo ")) {
                        saldo = b.trim();
                    } else if (a.equals("senha ")) {
                        senha = b.trim();
                    } else if (a.equals("email ")) {
                        email = b.trim();
                    } else if (a.equals("nome ")) {
                        nome = b.trim();
                    } else if (a.equals("rg ")) {
                        rg = b.trim();
                    } else if (a.equals("cpf ")) {
                        cpf = b.trim();
                    } else if (a.equals("telefone ")) {
                        telefone = b.trim();
                    } else if (a.equals("rua ")) {
                        rua = b.trim();
                    } else if (a.equals("bairro ")) {
                        bairro = b.trim();
                    } else if (a.equals("complemento ")) {
                        complemento = b.trim();
                    } else if (a.equals("numero ")) {
                        numero2 = b.trim();
                    } else if (a.equals("cidade ")) {
                        cidade = b.trim();
                    } else if (a.equals("estado ")) {
                        estado = b.trim();
                    } else if (a.equals("pais ")) {
                        pais = b.trim();
                    } else if (a.equals("cep ")) {
                        cep = b.trim();
                    } else if (a.equals("Data de Nascimento ")) {
                        dataNasc = b.trim();
                    } else if (a.equals("Idade ")) {
                        idade = b.trim();
                    } else if (a.equals("Renda Mensal ")) {
                        rendaMensal = b.trim();
                    }else if(a.equals("Limite ")) {
                        limite = b.trim();
                    }else if(a.equals("Ativo ")) {
                        ativo = b.trim();
                    }

                }
            }

            leitor.close();
            reader.close();
            Extrato ex = new Extrato();
            Date d = ex.converteData(dataNasc);
            
            
            Endereco end = new Endereco(rua, numero2, complemento, bairro, cidade, estado, pais, cep);
            
            Cliente cli = new Cliente( nome, rg, cpf, telefone, d, converteInt(idade), end);
            
            ContaCorrenteLimitada c = new ContaCorrenteLimitada(converteDouble(limite),numero, agencia, converteDouble(saldo), tipo, senha, 
                    email, converteDouble(rendaMensal), ContaCorrenteComum.verificaAtivo(ativo), cli);
            
            

            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public static double converteDouble(String valor) {
        try {
            double v = Double.valueOf(valor);
            return v;
        }catch(NumberFormatException e) {
            return 0;
        }
    }
    
    public static int converteInt(String valor) {
        try {
            int v = Integer.valueOf(valor);
            return v;
        }catch(NumberFormatException e) {
            return 0;
        }
    }
}
