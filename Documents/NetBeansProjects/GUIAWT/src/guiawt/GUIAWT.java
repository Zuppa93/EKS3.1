
package guiawt;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class GUIAWT {

    
    public static void main(String[] args) {
        Frame frame = new Frame();
        
        MenuBar menuBar = new MenuBar();
        Menu datei = new Menu("Datei");
        Menu menuWeg = new Menu("MenuWeg");
        Menu titelAendern = new Menu("Titel Ändern");
        MenuItem beenden = new MenuItem("Beenden");
        Label ausgabe = new Label("Default Text");
        Panel panel = new Panel(new GridBagLayout());
        panel.add(ausgabe);
        
        
        
        datei.add(beenden);
        
        menuBar.add(datei);
        menuBar.add(menuWeg);
        menuBar.add(titelAendern);
        
        frame.setMenuBar(menuBar);
        
        
        
        
        
        
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
        
        
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }

    
}

class Beenden implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
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



}
