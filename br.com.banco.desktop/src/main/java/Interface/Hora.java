/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.Timer;

public class Hora extends JFrame{
JLabel JLabelRotulo;
int hh,mm,ss,h;
Calendar CalendarHora;
DecimalFormat formato;

public Hora(){
super("Hora no Formulário");
Container tela = getContentPane();
tela.setLayout(null);

JLabelRotulo = new JLabel("");
JLabelRotulo.setBounds(20,30,280,20);

ActionListener tarefa = (new ActionListener(){
public void actionPerformed(ActionEvent e){
HORAS();
}
});

javax.swing.Timer time = new javax.swing.Timer(1000,tarefa);
time.start();
tela.add(JLabelRotulo);

setSize(300, 200);
setVisible(true);
setLocationRelativeTo(null);
}

public static void main(String args[]){
Hora app = new Hora();
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private void HORAS(){
CalendarHora = Calendar.getInstance();
hh = CalendarHora.get(Calendar.HOUR_OF_DAY);
mm = CalendarHora.get(Calendar.MINUTE);
ss = CalendarHora.get(Calendar.SECOND);
formato = new DecimalFormat("00");
JLabelRotulo.setText("Hora: "+formatar(hh%12)+":"+formatar(mm)+":"+formatar(ss));
}

private String formatar(int num){
formato = new DecimalFormat("00");
return formato.format(num);
}
} 