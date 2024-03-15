package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    AppPanel myPanel = new AppPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu;
    JMenu administratorMenu;
    JMenuItem exitItem;
    JMenuItem loginItem;
    JMenuItem AdministratorItem;
    JMenuItem logoutItem;
//    LoginInfor logininfor = new LoginInfor();
    private ViewModel viewModel;

    public AppFrame(ViewModel viewModel) {
        this.viewModel=viewModel;
        setTitle(viewModel.getTitle());
        setResizable(false);
        setSize(viewModel.getWidth(), viewModel.getHeight());
        setBackground(viewModel.getBackgroundColor());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        setJMenuBar(menuBar);
        add(myPanel);


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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitItem) {
            dispose();
        }
        if (e.getSource() == loginItem) {
            AppFrame2 appFrame2 = new AppFrame2(viewModel);
            appFrame2.setVisible(true);
        }

    }

}
