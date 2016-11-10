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
import java.util.StringTokenizer;

/**
 *
 * @author FábioJunior
 */
public class ContaCorrenteComum extends Conta {
    
    public ContaCorrenteComum(String numero, String agencia, double saldo, String tipo,
            String senha, String email, double rendaMensal, boolean ativo, Cliente cli) {
        super(numero, agencia, saldo, tipo, senha, email, rendaMensal, ativo, cli);
        
    }
    
    public ContaCorrenteComum() {
        
    }   
    
    
    @Override
    public String toString() {
        return  super.toString();
    }
    
    public static ContaCorrenteComum Leitura(String conta) {//método statico para Não precisar instanciar
        String linha = null; // para receber os dados das buscas abaixo

        String cs = "C:\\Users\\FábioJunior\\Documents\\Contas\\" + conta + "/conta.txt"; // caminho absoluto da pasta do banco

        try {

            FileReader reader = new FileReader(cs);//metodo para leitura

            BufferedReader leitor = new BufferedReader(reader);//metodo complementar da leitura
            StringTokenizer st = null; // metodo usado para separa a string para a busca
            
            //variaveis da classe estatica
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
            String ativo = "";

            //loop para pular linha
            while ((linha = leitor.readLine()) != null) {

                st = new StringTokenizer(linha, "="); //verifica e divide a string em antes e depois do "="

                String dados;

                while (st.hasMoreTokens()) {//verifica se ainda há tokens 

                    dados = st.nextToken();//agrega valor a variavel
                    a = dados;

                    dados = st.nextToken();//agrega valor a variavel
                    b = dados;
                    
                    //cadeia de if's para montar os objetos
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
                    } else if(a.equals("Ativo ")) {
                        ativo = b.trim();
                    }

                }
            }
            //fechando o leitor
            leitor.close();
            reader.close();
            
            Endereco end = new Endereco(rua, numero2, complemento, bairro, cidade, estado, pais, cep);
            Cliente cli = new Cliente( nome, rg, cpf, telefone, dataNasc, ContaCorrenteLimitada.converteInt(idade), end);
            ContaCorrenteComum c = new ContaCorrenteComum(numero, agencia, ContaCorrenteLimitada.converteDouble(saldo), tipo, 
                    senha, email, ContaCorrenteLimitada.converteDouble(rendaMensal), verificaAtivo(ativo), cli);
            
            

            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    //metodo para alterar de ativo para inativo
    public static boolean verificaAtivo(String texto) {
        if(texto.trim().equalsIgnoreCase("true")) {
            return true;
        } else {
            return false;
        }
    }
}
