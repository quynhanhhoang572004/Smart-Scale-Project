package UI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConfigureFrame extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JComboBox LanguageBox;

    public ConfigureFrame(){

        String[] Language = {"English","US English","Vietnamese"};
        LanguageBox = new JComboBox(Language);
        LanguageBox.setBounds(10, 25, 200, 20);

        JLabel messLabel1 = new JLabel("Please select the model of balance that you will be using");
        messLabel1.setBounds(10, 3, 445, 50); 
        messLabel1.setFont(new Font(null, Font.BOLD, 12)); 


        panel1.setBounds(0, 5, 485, 140);
        panel1.setVisible(true);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Language",TitledBorder.LEFT,TitledBorder.TOP));
        panel1.add(LanguageBox);


        panel2.setBounds(0, 150, 485, 140);
        panel2.setVisible(true);
        panel2.setLayout(null);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Balance Configuration",TitledBorder.LEFT,TitledBorder.TOP));
        panel2.add(messLabel1);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,400);
        setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setTitle("Configure");
        add(panel1);
        add(panel2);
        

    }

}
