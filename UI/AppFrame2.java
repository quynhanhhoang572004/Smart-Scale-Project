package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame2 extends JFrame implements ActionListener {
    AppPanel2 myPanel = new AppPanel2();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu;
    JMenu administratorMenu;
    JMenuItem exitItem ;
    JMenuItem loginItem;
    JMenuItem AdministratorItem;
    JMenuItem logoutItem;
//    LoginInfor logininfor = new LoginInfor();
    private ViewModel viewModel;


    public AppFrame2(ViewModel viewModel){
        setTitle(viewModel.getTitle());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(viewModel.getWidth(), viewModel.getHeight());
        setBackground(viewModel.getBackgroundColor());
        this.viewModel=viewModel;
        add(myPanel);

        setJMenuBar(menuBar);
        setVisible(false);


         fileMenu = new JMenu("File");
        administratorMenu = new JMenu("Administrator");

        exitItem = new JMenuItem("Exit");   
        loginItem = new JMenuItem("Login");
        AdministratorItem = new JMenuItem("Administrator Option");
        logoutItem = new JMenuItem("Logout");

        fileMenu.add(exitItem);
        administratorMenu.add(loginItem);
        administratorMenu.add(AdministratorItem);
        administratorMenu.add(logoutItem);
        

        menuBar.add(fileMenu);
        menuBar.add(administratorMenu);
        setJMenuBar(menuBar);

        exitItem.addActionListener(this);
        loginItem.addActionListener(this);
        

     

    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==exitItem){
            dispose();
        }
//        if(e.getSource()== loginItem){
//            LoginPage login = new LoginPage(logininfor.getLogicInfor());
//        }
        
    }

}

    


