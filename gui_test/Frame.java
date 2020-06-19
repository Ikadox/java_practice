package gui_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
    public Frame(String title){
        // Set the title to be displayed in a frame.
        setTitle(title);
        // Set the coordinates, width and height of the frame.
        setBounds(100, 100, 900, 600);
        // Set up a case where the close button is pressed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(240, 224, 214));
        headerPanel.setPreferredSize(new Dimension(900, 50));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 240, 240));

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(255, 255, 238));
        sidePanel.setPreferredSize(new Dimension(190, 600));

        Container contentPane = getContentPane();
        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(sidePanel, BorderLayout.WEST);
        contentPane.add(mainPanel);
    }
}