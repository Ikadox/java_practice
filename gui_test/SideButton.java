package gui_test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SideButton extends JButton{
    SideButton(String s){
        setText(s);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(80, 40));
        setFont(new Font("", Font.BOLD, 14));
    }
}