package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel2 extends JPanel implements ActionListener  {
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();


    public AppPanel2() {


        button1.setBounds(20, 20, 80, 100);
        button1.setBackground(Color.white);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.setFocusable(false);
        button1.setText("New");
        add(button1);

        
        button2.setBounds(110, 20, 80, 100);
        button2.setBackground(Color.white);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setFocusable(false);
        button2.setText("Result");
        add(button2);

        button3.setBounds(200, 20, 80, 100);
        button3.setBackground(Color.white);
        button3.setBorder(BorderFactory.createEtchedBorder());
        button3.setFocusable(false);
        button3.setText("<html><center>Edit<br>Experiment</center></html");
        add(button3);

       
        button4.setBounds(290, 20, 80, 100);
        button4.setBackground(Color.white);
        button4.setBorder(BorderFactory.createEtchedBorder());
        button4.setFocusable(false);
        button4.setText("<html><center>Run<br>Experiment</center></html");
        add(button4);

     
        button5.setBounds(380, 20, 80, 100);
        button5.setBackground(Color.white);
        button5.setBorder(BorderFactory.createEtchedBorder());
        button5.setFocusable(false);
        button5.setText("<html><center>Import<br>Experiment</center></html");
        add(button5);
       
    
        button6.setBounds(470, 20, 80, 100);
        button6.setBackground(Color.white);
        button6.setBorder(BorderFactory.createEtchedBorder());
        button6.setFocusable(false);
        button6.setText("<html><center>Export<br>Experiment</center></html");
        add(button6);

        button7.setBounds(560, 20, 80, 100);
        button7.setBackground(Color.white);
        button7.setBorder(BorderFactory.createEtchedBorder());
        button7.setFocusable(false);
        button7.setText("Configure");
        add(button7);
        button7.addActionListener(this);

  
        button8.setBounds(650, 20, 80, 100);
        button8.setBackground(Color.white);
        button8.setBorder(BorderFactory.createEtchedBorder());
        button8.setFocusable(false);
        button8.setText("<html><center>Delete<br>Experiment</center></html");
        add(button8);

        setBackground(Color.white);
        setBounds(0, 0, 770, 700);
        setVisible(true);
        setLayout(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button7){
            new ConfigureFrame();
        }
    }
}


