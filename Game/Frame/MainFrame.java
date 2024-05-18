package Game.Frame;

import Game.Object.PanelGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    public MainFrame(){
        this.setTitle("Plane Game");
        this.setSize(3000,3000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        PanelGame panelGame=new PanelGame();
        this.add(panelGame);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
             panelGame.start();
           }
        });
        this.setVisible(true);
    }
    public static void main(String[] args){
        new MainFrame();
    }
}
