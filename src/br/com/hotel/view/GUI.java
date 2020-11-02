package br.com.hotel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI extends JFrame{

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    GUI frame = new GUI();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 640, 400);

        // barra no topo
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // items barra no topo
        JMenu mnChale = new JMenu ("Cadastrar");
        menuBar.add(mnChale);

        JMenuItem mntmChale = new JMenuItem("Chale");
        mnChale.add(mntmChale);

        JMenuItem mntmSair = new JMenuItem("Sair");
        mntmSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        mnChale.add(mntmSair);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0,424,Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0,231,Short.MAX_VALUE)
        );
        contentPane.setLayout(gl_contentPane);
    }
}