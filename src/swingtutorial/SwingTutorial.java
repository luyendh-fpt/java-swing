/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author daolinh
 */
public class SwingTutorial {

    public void prepareGUI() {
        JFrame jFrame = new JFrame("Student");
        jFrame.setSize(700, 700);
        jFrame.setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.YELLOW);
        jPanel.setBounds(5, 5, 590, 490);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(100, 150, 100, 40);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(100, 195, 100, 40);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(100, 240, 100, 40);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(100, 285, 100, 40);

        JLabel lblRollNumber = new JLabel("RollNumber");
        lblRollNumber.setBounds(100, 330, 100, 40);

        JLabel lblClassName = new JLabel("ClassName");
        lblClassName.setBounds(100, 375, 100, 40);

        JTextField txtId = new JTextField();
        txtId.setBounds(205, 150, 200, 40);

        JTextField txtName = new JTextField();
        txtName.setBounds(205, 195, 200, 40);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(205, 240, 200, 40);

        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(205, 285, 200, 40);

        JTextField txtRollNumber = new JTextField();
        txtRollNumber.setBounds(205, 330, 200, 40);

        JTextField txtClassName = new JTextField();
        txtClassName.setBounds(205, 375, 200, 40);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(205, 420, 100, 40);
        ButtonHandle btnHandle = new ButtonHandle();
        btnLogin.addActionListener(btnHandle);

        jPanel.add(lblId);
        jPanel.add(lblName);
        jPanel.add(lblEmail);
        jPanel.add(lblPhone);
        jPanel.add(lblRollNumber);
        jPanel.add(lblClassName);
        jPanel.add(txtId);
        jPanel.add(txtName);
        jPanel.add(txtEmail);
        jPanel.add(txtPhone);
        jPanel.add(txtClassName);
        jPanel.add(txtRollNumber);
        jPanel.add(btnLogin);
        jFrame.add(jPanel);

        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingTutorial swingTutorial = new SwingTutorial();
        swingTutorial.prepareGUI();
    }

    class ButtonHandle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked by me.");
        }
    }
}
