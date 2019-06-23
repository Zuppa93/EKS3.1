package guiawt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;

public class MainFrame {

    private Frame frame;
    private MenuBar menuBar;
    private Menu datei;
    private Menu menuWeg;
    private Menu titelAendern;
    private MenuItem MenuItemMenuWeg;
    private MenuItem MenuItemTitelAendern;
    private MenuItem beenden;
    private Label ausgabe;

    private void initComponents() {
        frame = new Frame();
        menuBar = new MenuBar();
        datei = new Menu("Datei");
        menuWeg = new Menu("Menu Weg");
        titelAendern = new Menu("Titel Ändern");
        beenden = new MenuItem("Beenden");
        ausgabe = new Label("Default Text");
        MenuItemMenuWeg = new MenuItem("Menu Weg");
        MenuItemTitelAendern = new MenuItem("Titel Ändern");

        frame.addWindowListener(new java.awt.event.WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        beenden.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        MenuItemMenuWeg.addActionListener((ActionEvent e) -> {
            frame.setMenuBar(null);
        });

        MenuItemTitelAendern.addActionListener((Actionevent) -> {
            Frame teilFrame = new Frame();
            TextField eingabe = new TextField();
            Button OK = new Button("OK");

            Panel helpPanel = new Panel();

            GroupLayout layout = new GroupLayout(helpPanel);
            helpPanel.setLayout(layout);

            layout.setHorizontalGroup(layout.createParallelGroup()
                    .addComponent(eingabe,0,200,200)
                    .addGroup(layout.createParallelGroup()
                            .addComponent(OK,0,50,50)));
            
            layout.setVerticalGroup(layout.createSequentialGroup()
                    .addComponent(eingabe,0,20,20)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(OK, 0 , 30, 30)));

            teilFrame.addWindowListener(new java.awt.event.WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {

                }

                @Override
                public void windowClosing(WindowEvent e) {
//                    /teilFrame.dispose();
                }

                @Override
                public void windowClosed(WindowEvent e) {

                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });

            OK.addActionListener((ActionEvent) -> {
                String text;
                text = eingabe.getText();
                frame.setTitle(text);
                ausgabe.setText(text);
                teilFrame.dispose();
            });

            teilFrame.add(helpPanel);

            teilFrame.setSize(200, 200);
            teilFrame.setLocationRelativeTo(frame);
            teilFrame.setVisible(true);

        });
        
        ausgabe.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getClickCount() == 2 && e.getButton() == e.BUTTON3){
                   frame.setMenuBar(menuBar);
               }
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });

        datei.add(beenden);
        menuWeg.add(MenuItemMenuWeg);
        titelAendern.add(MenuItemTitelAendern);

        menuBar.add(datei);
        menuBar.add(menuWeg);
        menuBar.add(titelAendern);

        Panel panel = new Panel(new GridBagLayout());
        panel.add(ausgabe);

        frame.setMenuBar(menuBar);

        frame.setSize(400, 400);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public MainFrame() {
        initComponents();
    }
}
