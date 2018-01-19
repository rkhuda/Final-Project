import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Timer;

import java.util.*;

public class tester extends JFrame {

    private Container pane;
    private JPanel[][] panels;  
    private JLabel b;      
    private ImageIcon Pacdot;
    private Pacman pac;
    public tester(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(400, 100, 700, 700);
       	this.setResizable(false);
	
	
	//	addKeyListener(this);
	pane = getContentPane();
       	
	Pacdot = new ImageIcon("Pacdot.png");
	Image imageDot = Pacdot.getImage();
	Image newimgDot = imageDot.getScaledInstance(4, 4, java.awt.Image.SCALE_SMOOTH);
	Pacdot = new ImageIcon(newimgDot);
	//	b = new JLabel();

       	pane.setLayout(new GridLayout(25, 25));
	panels = new JPanel[25][25];
	
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
		b = new JLabel();
		panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
	       	Container c = getContentPane();
		
	
	
		
		    b.setIcon(Pacdot);
		    p.setBackground(Color.BLACK);
		    p.add(b);
		    pane.add(p);
	    }
	}
    }
    public static void main(String[] args){
	tester test = new tester();
	test.setVisible(true);
    }
}