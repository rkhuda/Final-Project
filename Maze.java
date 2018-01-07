import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

//import java.awt.Graphics;
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.GridLayout;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Maze extends JFrame {

    private Walls border;

    public Maze(){
	this.border = new Walls();
    }

    public static void main(String[] args){
        Maze frame = new Maze();
	frame.setTitle("Pacman");
	frame.setBackground(Color.black);
	frame.getContentPane().add(frame.border);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(500, 200, 500, 520);
	frame.setVisible(true);
    }
}
