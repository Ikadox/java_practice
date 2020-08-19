package gui_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
    public Frame(String title){
        // Set the title to be displayed in a frame.
        setTitle(title);
        // Set the coordinates, width and height of the frame.
        setBounds(100, 100, 400, 600);
        // Set up a case where the close button is pressed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Panels
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(240, 224, 214));
        headerPanel.setPreferredSize(new Dimension(300, 50));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 240, 240));

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(255, 255, 238));
        sidePanel.setPreferredSize(new Dimension(80, 600));

        Container contentPane = getContentPane();
        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(sidePanel, BorderLayout.WEST);
        contentPane.add(mainPanel);

        // Set header Label
        JLabel headerLabel = new JLabel("0");
        headerLabel.setForeground(new Color(128, 0, 0));
        headerLabel.setPreferredSize(new Dimension(900, 50));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setFont(new Font("Century", Font.BOLD, 22));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        // Set Side buttons
        SideButton buttonDiv = new SideButton("÷");
        SideButton buttonMulti = new SideButton("×");
        SideButton buttonSub = new SideButton("-");
        SideButton buttonPlus = new SideButton("＋");
        SideButton buttonDone = new SideButton("＝");
        SideButton buttonClear = new SideButton("c");
        sidePanel.add(buttonDiv);
        sidePanel.add(buttonMulti);
        sidePanel.add(buttonSub);
        sidePanel.add(buttonPlus);
        sidePanel.add(buttonDone);
        sidePanel.add(buttonClear);
    }
}