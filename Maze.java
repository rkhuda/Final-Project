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
	border = new Walls();
    }

    public static void main(String[] args){
        Maze maze = new Maze();
	maze.setTitle("Pacman");
	maze.setBackground(Color.black);
	maze.getContentPane().add(maze.border);
	maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	maze.setBounds(500, 200, 500, 520);
	maze.setVisible(true);
    }
}