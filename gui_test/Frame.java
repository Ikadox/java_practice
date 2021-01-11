package gui_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ウィンドウの大元になるクラス JFrame を継承しているクラス。
 * Swing は他のコンポーネントを追加することできるオブジェクトをコンテナと呼び、
 * ウィンドウの大元になるクラスのオブジェクトをトップレベルコンテナという。
 * コンポーネントは JComponent クラスのサブクラスとして定義され、
 * ボタンやラベルなど用途に応じたクラスが定義されている。 
 */
public class Frame extends JFrame{
    public Frame(String title){
        // 引数で受け取ったタイトルをウィンドウに表示する
        setTitle(title);
        // ウィンドウを表示する位置（x,y）とウィンドウの横幅と縦の長さを指定する。
        setBounds(100, 100, 400, 320);
        // 閉じるボタンを押したらプログラムを終了する。
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Panels
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(240, 224, 214));
        headerPanel.setPreferredSize(new Dimension(400, 40));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 240, 240));
        mainPanel.setPreferredSize(new Dimension(300, 280));

        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(255, 255, 238));
        sidePanel.setPreferredSize(new Dimension(100, 280));

        Container contentPane = getContentPane();
        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(sidePanel, BorderLayout.WEST);
        contentPane.add(mainPanel, BorderLayout.EAST);

        // Set header Label
        JLabel headerLabel = new JLabel("0");
        headerLabel.setForeground(new Color(128, 0, 0));
        headerLabel.setPreferredSize(new Dimension(400, 40));
        headerLabel.setHorizontalAlignment(JLabel.RIGHT);
        headerLabel.setFont(new Font("Century", Font.BOLD, 22));
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        // Set Side buttons
        SideButton buttonSub = new SideButton("-");
        SideButton buttonPlus = new SideButton("＋");
        SideButton buttonDone = new SideButton("＝");
        SideButton buttonClear = new SideButton("c");
        sidePanel.add(buttonSub);
        sidePanel.add(buttonPlus);
        sidePanel.add(buttonDone);
        sidePanel.add(buttonClear);

        // Set Number buttons
        NumberButton button9 = new NumberButton("9");
        NumberButton button8 = new NumberButton("8");
        NumberButton button7 = new NumberButton("7");
        NumberButton button6 = new NumberButton("6");
        NumberButton button5 = new NumberButton("5");
        NumberButton button4 = new NumberButton("4");
        NumberButton button3 = new NumberButton("3");
        NumberButton button2 = new NumberButton("2");
        NumberButton button1 = new NumberButton("1");
        NumberButton button0 = new NumberButton("0");
        mainPanel.add(button9);
        mainPanel.add(button8);
        mainPanel.add(button7);
        mainPanel.add(button6);
        mainPanel.add(button5);
        mainPanel.add(button4);
        mainPanel.add(button3);
        mainPanel.add(button2);
        mainPanel.add(button1);
        mainPanel.add(button0);
    }}