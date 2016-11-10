/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classes.Cliente;
import Classes.Conta;
import Classes.ContaCorrenteComum;
import Classes.ContaCorrenteLimitada;
import Classes.ContaPoupanca;
import Classes.Endereco;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author fabio
 */
public class TelaNovoCliente extends javax.swing.JFrame {

    ContaPoupanca c1 = new ContaPoupanca();
    ContaCorrenteComum c2 = new ContaCorrenteComum();
    ContaCorrenteLimitada c3 = new ContaCorrenteLimitada();

    Conta c = new Conta();

    public int converteInt(String txt) {
        int num = Integer.valueOf(txt);
        return num;
    }
    
    public boolean verificaAtivo(String ativo) {
        try{
            if(varAtivo.getSelectedItem().toString().equals("Ativo"))
                return true;
            else
                return false;
        }catch(AbstractMethodError e) {
            return false;
        }
    }

    public double converteDouble(String txt) {
        return Double.valueOf(txt);
    }

    public String removeEspaco(String data) {
        data = data.replace(" ", "");
        return data;

    }

    public boolean verifica() {
        if (varAgencia.getText().isEmpty() || varBairro.getText().isEmpty() || varCep.getText().isEmpty()
                || varCidade.getText().isEmpty() || varComplemento.getText().isEmpty() || varCpf.getText().isEmpty()
                || varDataNascimento.getText().isEmpty() || varEmail.getText().isEmpty() || varEstado.getText().isEmpty()
                || varNome.getText().isEmpty() || varNumero.getText().isEmpty() || varNumeroConta.getText().isEmpty()
                || varPais.getText().isEmpty() || varRendaMensal.getText().isEmpty() || varRg.getText().isEmpty()
                || varRua.getText().isEmpty() || varSaldo.getText().isEmpty() || varSenha.getText().isEmpty()
                || varTelefone.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void preenche(Object c) {

        if (c instanceof ContaCorrenteComum) {
           ContaCorrenteComum cli = new ContaCorrenteComum();
           cli = (ContaCorrenteComum)c;
            varAgencia.setText(cli.getAgencia());
            if (cli.getTipo().equalsIgnoreCase("Poupança")) {
                varTipo.setSelectedItem("Poupanca");
            } else if(cli.getTipo().equalsIgnoreCase("Corrente Comum")){
                varTipo.setSelectedItem("Corrente Comum");
            } else {
                varTipo.setSelectedItem("Corrente Limitada");
            }
            varBairro.setText(cli.getCli().getEndereco().getBairro());
            varCep.setText(removeEspaco(cli.getCli().getEndereco().getCep()));
            varCidade.setText(cli.getCli().getEndereco().getCidade());
            varComplemento.setText(cli.getCli().getEndereco().getComplemento());
            varCpf.setText(cli.getCli().getCpf());
            varDataNascimento.setText(removeEspaco(cli.getCli().getDataNasc()));
            varEmail.setText(cli.getEmail());
            varEstado.setText(cli.getCli().getEndereco().getEstado());
            varIdade.setValue(cli.getCli().getIdade());
            varNome.setText(cli.getCli().getNome());
            varNumero.setText(cli.getCli().getEndereco().getNumero());
            varPais.setText(cli.getCli().getEndereco().getPais());
            varRendaMensal.setText("" + cli.getRendaMensal());
            varRg.setText(cli.getCli().getRg());
            varRua.setText(cli.getCli().getEndereco().getRua());
            varSaldo.setText("" + cli.getSaldo());
            varSenha.setText(cli.getSenha());
            varTelefone.setText(cli.getCli().getTelefone());
            varNumeroConta.setText(cli.getNumero());

        }else if(c instanceof ContaPoupanca) {
            ContaPoupanca cli = new ContaPoupanca();
            cli = (ContaPoupanca) c;
            varAgencia.setText(cli.getAgencia());
            if (cli.getTipo().equalsIgnoreCase("Poupança")) {
                varTipo.setSelectedItem("Poupanca");
            } else if(cli.getTipo().equalsIgnoreCase("Corrente Comum")){
                varTipo.setSelectedItem("Corrente Comum");
            } else {
                varTipo.setSelectedItem("Corrente Limitada");
            }
            varBairro.setText(cli.getCli().getEndereco().getBairro());
            varCep.setText(removeEspaco(cli.getCli().getEndereco().getCep()));
            varCidade.setText(cli.getCli().getEndereco().getCidade());
            varComplemento.setText(cli.getCli().getEndereco().getComplemento());
            varCpf.setText(cli.getCli().getCpf());
            varDataNascimento.setText(removeEspaco(cli.getCli().getDataNasc()));
            varEmail.setText(cli.getEmail());
            varEstado.setText(cli.getCli().getEndereco().getEstado());
            varIdade.setValue(cli.getCli().getIdade());
            varNome.setText(cli.getCli().getNome());
            varNumero.setText(cli.getCli().getEndereco().getNumero());
            varPais.setText(cli.getCli().getEndereco().getPais());
            varRendaMensal.setText("" + cli.getRendaMensal());
            varRg.setText(cli.getCli().getRg());
            varRua.setText(cli.getCli().getEndereco().getRua());
            varSaldo.setText("" + cli.getSaldo());
            varSenha.setText(cli.getSenha());
            varTelefone.setText(cli.getCli().getTelefone());
            varNumeroConta.setText(cli.getNumero());
            vardtaCriacao.setText(removeEspaco(cli.getDtaCriacao()));
        } else if(c instanceof ContaCorrenteLimitada) {
            ContaCorrenteLimitada cli = new ContaCorrenteLimitada();
            cli = (ContaCorrenteLimitada)c;
            varAgencia.setText(cli.getAgencia());
            if (cli.getTipo().equalsIgnoreCase("Poupança")) {
                varTipo.setSelectedItem("Poupanca");
            } else if(cli.getTipo().equalsIgnoreCase("Corrente Comum")){
                varTipo.setSelectedItem("Corrente Comum");
            } else {
                varTipo.setSelectedItem("Corrente Limitada");
            }
            varBairro.setText(cli.getCli().getEndereco().getBairro());
            varCep.setText(removeEspaco(cli.getCli().getEndereco().getCep()));
            varCidade.setText(cli.getCli().getEndereco().getCidade());
            varComplemento.setText(cli.getCli().getEndereco().getComplemento());
            varCpf.setText(cli.getCli().getCpf());
            varDataNascimento.setText(removeEspaco(cli.getCli().getDataNasc()));
            varEmail.setText(cli.getEmail());
            varEstado.setText(cli.getCli().getEndereco().getEstado());
            varIdade.setValue(cli.getCli().getIdade());
            varNome.setText(cli.getCli().getNome());
            varNumero.setText(cli.getCli().getEndereco().getNumero());
            varPais.setText(cli.getCli().getEndereco().getPais());
            varRendaMensal.setText("" + cli.getRendaMensal());
            varRg.setText(cli.getCli().getRg());
            varRua.setText(cli.getCli().getEndereco().getRua());
            varSaldo.setText("" + cli.getSaldo());
            varSenha.setText(cli.getSenha());
            varTelefone.setText(cli.getCli().getTelefone());
            varNumeroConta.setText(cli.getNumero());
            varLimite.setText("" + cli.getLimite());
        }
    }

    public void limpar() {
        varAgencia.setText("");
        varBairro.setText("");
        varBuscar.setText("");
        varCep.setText("");
        varCidade.setText("");
        varComplemento.setText("");
        varCpf.setText("");
        varDataNascimento.setText("");
        varEmail.setText("");
        varEstado.setText("");
        varIdade.setValue(0);
        varNome.setText("");
        varNumero.setText("");
        varPais.setText("");
        varRendaMensal.setText("");
        varRg.setText("");
        varRua.setText("");
        varSaldo.setText("");
        varSenha.setText("");
        varTelefone.setText("");
    }

    /**
     * Creates new form TelaNovoCliente
     */
    public TelaNovoCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        varNome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        varRg = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        varIdade = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        varRendaMensal = new javax.swing.JFormattedTextField();
        varDataNascimento = new javax.swing.JFormattedTextField();
        varTelefone = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        varCpf = new javax.swing.JFormattedTextField();
        jLabel25 = new javax.swing.JLabel();
        vardtaCriacao = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        varRua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        varNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        varComplemento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        varBairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        varCidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        varEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        varPais = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        varCep = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        varAgencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        varNumeroConta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        varSenha = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        varSaldo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        varTipo = new javax.swing.JComboBox<>();
        varAtivo = new javax.swing.JComboBox<>();
        varLimite = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        varBuscar = new javax.swing.JTextField();
        btnOkBuscar = new javax.swing.JButton();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnCriarNovoCliente = new javax.swing.JButton();
        Limpar = new javax.swing.JButton();
        btnPoupanca = new javax.swing.JRadioButton();
        btnCorrenteComum = new javax.swing.JRadioButton();
        btnCorrenteLimitada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));

        jTabbedPane1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        varNome.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNomeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel11.setText("Nome");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel12.setText("C.P.F");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel13.setText("R.G");

        varRg.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel14.setText("Data de Nascimento");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel15.setText("Idade");

        varIdade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel16.setText("Renda Mensal");

        varRendaMensal.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        try {
            varDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varDataNascimento.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varDataNascimentoFocusLost(evt);
            }
        });

        varTelefone.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel23.setText("Telefone");

        try {
            varCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varCpf.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varCpfFocusLost(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel25.setText("Data da Criação");

        try {
            vardtaCriacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        vardtaCriacao.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(243, 243, 243))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(178, 178, 178))
                                    .addComponent(varTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(vardtaCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(varIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(varRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(varRg, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(varDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(varCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varRg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varRendaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vardtaCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Pessoais", jPanel2);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Rua");

        varRua.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Número");

        varNumero.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("Complemento");

        varComplemento.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("Bairro");

        varBairro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel17.setText("Cidade");

        varCidade.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Estado");

        varEstado.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Pais");

        varPais.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("CEP");

        try {
            varCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varCep.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(varPais, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(varCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(varRua, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(varComplemento, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel17)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varNumero)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(varBairro)
                    .addComponent(jLabel1)
                    .addComponent(varEstado)
                    .addComponent(jLabel3)
                    .addComponent(varCep, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varCidade)
                    .addComponent(varEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varPais)
                    .addComponent(varCep))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel3);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Agência");

        varAgencia.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Numero da Conta");

        varNumeroConta.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("Senha");

        varSenha.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel18.setText("E-mail");

        varEmail.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        varSaldo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varSaldoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel19.setText("Saldo ");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel21.setText("Ativo");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel22.setText("Tipo");

        varTipo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poupança", "Corrente Comum", "Corrente Limitada" }));

        varAtivo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        varLimite.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varLimiteActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel24.setText("Limite");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(varAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(varNumeroConta, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(varSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jLabel18)
                                    .addComponent(varEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(varAtivo, 0, 305, Short.MAX_VALUE)
                                        .addGap(54, 54, 54)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(varSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(varLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(76, 76, 76))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(varTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(varAtivo)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Dados da Conta", jPanel4);

        jLabel20.setBackground(new java.awt.Color(254, 254, 254));
        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(254, 254, 254));
        jLabel20.setText("Buscar Cliente");

        varBuscar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        varBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varBuscarActionPerformed(evt);
            }
        });

        btnOkBuscar.setBackground(new java.awt.Color(0, 51, 153));
        btnOkBuscar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnOkBuscar.setForeground(new java.awt.Color(254, 254, 254));
        btnOkBuscar.setText("OK");
        btnOkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBuscarActionPerformed(evt);
            }
        });

        btnSalvarAlteracoes.setBackground(new java.awt.Color(0, 51, 153));
        btnSalvarAlteracoes.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSalvarAlteracoes.setForeground(new java.awt.Color(254, 254, 254));
        btnSalvarAlteracoes.setText("Salvar Alterações");

        btnSair.setBackground(new java.awt.Color(0, 51, 153));
        btnSair.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(254, 254, 254));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCriarNovoCliente.setBackground(new java.awt.Color(0, 51, 153));
        btnCriarNovoCliente.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnCriarNovoCliente.setForeground(new java.awt.Color(254, 254, 254));
        btnCriarNovoCliente.setText("Criar Novo Cliente");
        btnCriarNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarNovoClienteActionPerformed(evt);
            }
        });

        Limpar.setBackground(new java.awt.Color(0, 51, 153));
        Limpar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        Limpar.setForeground(new java.awt.Color(254, 254, 254));
        Limpar.setText("Limpar");
        Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparActionPerformed(evt);
            }
        });

        btnPoupanca.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup1.add(btnPoupanca);
        btnPoupanca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPoupanca.setForeground(new java.awt.Color(255, 255, 255));
        btnPoupanca.setText("Poupança");

        btnCorrenteComum.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup1.add(btnCorrenteComum);
        btnCorrenteComum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCorrenteComum.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrenteComum.setText("Corrente Comum");

        btnCorrenteLimitada.setBackground(new java.awt.Color(204, 204, 0));
        buttonGroup1.add(btnCorrenteLimitada);
        btnCorrenteLimitada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCorrenteLimitada.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrenteLimitada.setText("Corrente Limitada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(28, 28, 28)
                        .addComponent(btnPoupanca)
                        .addGap(18, 18, 18)
                        .addComponent(btnCorrenteComum)
                        .addGap(18, 18, 18)
                        .addComponent(btnCorrenteLimitada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCriarNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOkBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoupanca)
                    .addComponent(btnCorrenteComum)
                    .addComponent(btnCorrenteLimitada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOkBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void varSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varSaldoActionPerformed

    private void btnCriarNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarNovoClienteActionPerformed
        /*String numero, String agencia, double saldo, String tipo, 
            String senha, String email*/
        if (verifica() == false) {
            if (varTipo.getSelectedItem().toString().equals("Poupança")) {
                Calendar ca = Calendar.getInstance();
                String data;
                int dia, mes, ano;
                dia = ca.get(Calendar.DAY_OF_MONTH);
                mes = ca.get(Calendar.MONTH) + 1;
                ano = ca.get(Calendar.YEAR);
                data = "" + dia + "/" + mes + "/" + ano;

                Endereco end = new Endereco(varRua.getText(), varNumero.getText(), varComplemento.getText(),
                        varBairro.getText(), varCidade.getText(), varEstado.getText(), varPais.getText(),
                        varCep.getText());

                /*Conta conta, String senha, String nome, String rg, String cpf, String telefone, 
            Endereco endereco, int id*/
                Cliente cli = new Cliente(varNome.getText(), varRg.getText(), varCpf.getText(),
                        varTelefone.getText(), varDataNascimento.getText(),
                        converteInt(varIdade.getValue().toString()), end);

                c1 = new ContaPoupanca(data, varNumeroConta.getText(), varAgencia.getText(),
                        converteDouble(varSaldo.getText()),
                        varTipo.getSelectedItem().toString(), varSenha.getText(),
                        varEmail.getText(), converteDouble(varRendaMensal.getText()), 
                        verificaAtivo(varAtivo.getSelectedItem().toString()), cli);

                if (c.criaPasta(varNumeroConta.getText(), c1) == true) {
                    JOptionPane.showMessageDialog(this, "Conta Criada com Sucesso!!\n"
                            + "Acesse novamente a página para visualizar");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "A Conta Já existe!!");
                }
            } else if (varTipo.getSelectedItem().toString().equals("Corrente Comum")) {

                Endereco end = new Endereco(varRua.getText(), varNumero.getText(), varComplemento.getText(),
                        varBairro.getText(), varCidade.getText(), varEstado.getText(), varPais.getText(),
                        varCep.getText());

                /*Conta conta, String senha, String nome, String rg, String cpf, String telefone, 
            Endereco endereco, int id*/
                Cliente cli = new Cliente(varNome.getText(), varRg.getText(), varCpf.getText(),
                        varTelefone.getText(), varDataNascimento.getText(),
                        converteInt(varIdade.getValue().toString()), end);

                c2 = new ContaCorrenteComum(varNumeroConta.getText(), varAgencia.getText(),
                        converteDouble(varSaldo.getText()),
                        varTipo.getSelectedItem().toString(), varSenha.getText(),
                        varEmail.getText(), converteDouble(varRendaMensal.getText()), 
                        verificaAtivo(varAtivo.getSelectedItem().toString()), cli);

                if (c.criaPasta(varNumeroConta.getText(), c2) == true) {
                    JOptionPane.showMessageDialog(this, "Conta Criada com Sucesso!!\n"
                            + "Acesse novamente a página para visualizar");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "A Conta Já existe!!");
                }
            } else if (varTipo.getSelectedItem().toString().equals("Corrente Limitada")) {

                Endereco end = new Endereco(varRua.getText(), varNumero.getText(), varComplemento.getText(),
                        varBairro.getText(), varCidade.getText(), varEstado.getText(), varPais.getText(),
                        varCep.getText());

                /*Conta conta, String senha, String nome, String rg, String cpf, String telefone, 
            Endereco endereco, int id*/
                Cliente cli = new Cliente(varNome.getText(), varRg.getText(), varCpf.getText(),
                        varTelefone.getText(), varDataNascimento.getText(),
                        converteInt(varIdade.getValue().toString()), end);
                double limite = Double.valueOf(varLimite.getText());
                c3 = new ContaCorrenteLimitada(limite, varNumeroConta.getText(), varAgencia.getText(),
                        converteDouble(varSaldo.getText()),
                        varTipo.getSelectedItem().toString(), varSenha.getText(),
                        varEmail.getText(), converteDouble(varRendaMensal.getText()), 
                        verificaAtivo(varAtivo.getSelectedItem().toString()), cli);

                if (c.criaPasta(varNumeroConta.getText(), c3) == true) {
                    JOptionPane.showMessageDialog(this, "Conta Criada com Sucesso!!\n"
                            + "Acesse novamente a página para visualizar");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "A Conta Já existe!!");
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Há Campos em Branco, tente novamente!", "", ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnCriarNovoClienteActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnOkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBuscarActionPerformed
        if (btnCorrenteComum.isSelected()) {
            ContaCorrenteComum ccc = ContaCorrenteComum.Leitura(varBuscar.getText());
            JOptionPane.showMessageDialog(null, ccc.toString(), "", ERROR_MESSAGE);
            preenche(ccc);
        }else if(btnCorrenteLimitada.isSelected()) {
            ContaCorrenteLimitada ccl = ContaCorrenteLimitada.Leitura(varBuscar.getText());
            JOptionPane.showMessageDialog(null,ccl.toString(), "", ERROR_MESSAGE);
            preenche(ccl);
        } else if(btnPoupanca.isSelected()) {
            ContaPoupanca cp = ContaPoupanca.Leitura(varBuscar.getText());
            JOptionPane.showMessageDialog(null,cp.toString(), "", ERROR_MESSAGE);
            preenche(cp);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Tipo de Conta para Buscar!!", "", ERROR_MESSAGE);
        }

        Conta.visualizarArquivos(varBuscar.getText());
    }//GEN-LAST:event_btnOkBuscarActionPerformed

    private void varBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varBuscarActionPerformed

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparActionPerformed
        limpar();
    }//GEN-LAST:event_LimparActionPerformed

    private void varLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varLimiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varLimiteActionPerformed

    private void varCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varCpfFocusLost
        Cliente cli = new Cliente();
        String cpf = "";
        if(cli.verificarCpf(cli.retiraPontos(varCpf.getText()))) {
            
        }else{
            JOptionPane.showMessageDialog(null,"O CPF digitado é inválido!", "", ERROR_MESSAGE);
            varCpf.requestFocus();
        }
    }//GEN-LAST:event_varCpfFocusLost

    private void varNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNomeActionPerformed

    private void varDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varDataNascimentoFocusLost
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = (java.util.Date)formatter.parse(varDataNascimento.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data Inválida!");
            varDataNascimento.setText("");
            varDataNascimento.requestFocus();
        }
        GregorianCalendar hj=new GregorianCalendar();
        GregorianCalendar nascimento=new GregorianCalendar();
        if(date!=null){
            nascimento.setTime(date);
        }
        int anohj = hj.get(Calendar.YEAR);
        int anoNascimento=nascimento.get(Calendar.YEAR);
        int idadeReal = anohj - anoNascimento;
        varIdade.setValue(idadeReal);
    }//GEN-LAST:event_varDataNascimentoFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Limpar;
    private javax.swing.JRadioButton btnCorrenteComum;
    private javax.swing.JRadioButton btnCorrenteLimitada;
    private javax.swing.JButton btnCriarNovoCliente;
    private javax.swing.JButton btnOkBuscar;
    private javax.swing.JRadioButton btnPoupanca;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField varAgencia;
    private javax.swing.JComboBox<String> varAtivo;
    private javax.swing.JTextField varBairro;
    private javax.swing.JTextField varBuscar;
    private javax.swing.JFormattedTextField varCep;
    private javax.swing.JTextField varCidade;
    private javax.swing.JTextField varComplemento;
    private javax.swing.JFormattedTextField varCpf;
    private javax.swing.JFormattedTextField varDataNascimento;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varEstado;
    private javax.swing.JSpinner varIdade;
    private javax.swing.JTextField varLimite;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextField varNumeroConta;
    private javax.swing.JTextField varPais;
    private javax.swing.JFormattedTextField varRendaMensal;
    private javax.swing.JTextField varRg;
    private javax.swing.JTextField varRua;
    private javax.swing.JTextField varSaldo;
    private javax.swing.JTextField varSenha;
    private javax.swing.JFormattedTextField varTelefone;
    private javax.swing.JComboBox<String> varTipo;
    private javax.swing.JFormattedTextField vardtaCriacao;
    // End of variables declaration//GEN-END:variables
}
