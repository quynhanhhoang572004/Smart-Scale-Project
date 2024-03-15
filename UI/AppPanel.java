package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppPanel extends JPanel implements ActionListener {
    JButton button2 = new JButton();
    JButton button1 = new JButton();
    public AppPanel() {

        button1.setBounds(20, 20, 80, 100);
        button1.setBackground(Color.white);
        button1.setBorder(BorderFactory.createEtchedBorder());
        button1.setFocusable(false);
        button1.setText("<html><center>Run<br>Experiment</center></html>");
        add(button1);

        
        button2.setBounds(110, 20, 80, 100);
        button2.setBackground(Color.white);
        button2.setBorder(BorderFactory.createEtchedBorder());
        button2.setFocusable(false);
        button2.setText("Configure");
        add(button2);


        setBackground(Color.white);
        setBounds(0, 0, 770, 700);
        setVisible(true);
        setLayout(null);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button2){
            new ConfigureFrame();
        }

    }

}
