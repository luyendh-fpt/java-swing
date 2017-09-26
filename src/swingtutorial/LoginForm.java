/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author daolinh
 */
public class LoginForm extends JFrame {

    private JLabel lblAccount;
    private JLabel lblPassword;
    private JTextField txtAccount;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnReset;
    private JLabel lblTotalMessage;
    private JLabel lblAccountMessage;
    private JLabel lblPasswordMessage;

    public LoginForm() {
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);

        // Khởi tạo các component con.
        this.lblAccount = new JLabel("Account");
        this.lblPassword = new JLabel("Password");
        this.txtAccount = new JTextField();
        this.txtPassword = new JPasswordField();
        this.btnLogin = new JButton("Login");
        this.btnReset = new JButton("Reset");
        this.lblTotalMessage = new JLabel();
        this.lblAccountMessage = new JLabel();
        this.lblPasswordMessage = new JLabel();

        // Định vị toạ độ cho các component.        
        this.lblAccount.setBounds(50, 70, 150, 40);
        this.lblPassword.setBounds(50, 115, 150, 40);
        this.txtAccount.setBounds(205, 70, 150, 40);
        this.txtPassword.setBounds(205, 115, 150, 40);
        this.btnLogin.setBounds(205, 160, 60, 30);
        this.btnReset.setBounds(270, 160, 60, 30);

        this.lblTotalMessage.setBounds(50, 25, 300, 40);
        this.lblAccountMessage.setBounds(360, 70, 150, 40);
        this.lblPasswordMessage.setBounds(360, 115, 150, 40);

        // Xử lý sự kiện.
        this.btnLogin.addActionListener(new LoginHandle());
        this.btnReset.addActionListener(new ResetHandle());

        // Thêm component vào container.        
        this.add(this.lblAccount);
        this.add(this.lblPassword);
        this.add(this.txtAccount);
        this.add(this.txtPassword);
        this.add(this.btnLogin);
        this.add(this.btnReset);
        this.add(this.lblTotalMessage);
        this.add(this.lblAccountMessage);
        this.add(this.lblPasswordMessage);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Xử lý login người dùng.
    class LoginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Xử lý login.
            String account = txtAccount.getText();
            String password = new String(txtPassword.getPassword());

            // Gọi đến hàm validateForm() của class FormHandle để validate dữ liệu.
            // Trong trường hợp không tồn tại lỗi thì hashmap trả về rỗng. Trong trường hợp,
            // hashmap có giá trị thì hiển thị thông báo.
            HashMap<String, String> errors = new FormHandle().validateLogin(account, password);
            if (errors.size() == 0) {
                resetMessage();
                // Gọi đến tầng model để xử lý, hoặc lưu thông tin.
            } else {
                showError(errors);
            }

            //JOptionPane.showMessageDialog(null, "Login thành công với tài khoản: " + txtAccount.getText());
        }
    }

    private void resetMessage() {
        lblTotalMessage.setText("");
        lblAccountMessage.setText("");
        lblPasswordMessage.setText("");
    }

    private void showError(HashMap<String, String> errors) {
        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("* Vui lòng sửa các lỗi bên dưới và submit lại form.");
        if (errors.containsKey("txtAccount")) {
            lblAccountMessage.setForeground(Color.red);
            lblAccountMessage.setText(errors.get("txtAccount"));
        } else {
            lblAccountMessage.setForeground(Color.green);
            lblAccountMessage.setText("Hợp lệ.");
        }
        if (errors.containsKey("txtPassword")) {
            lblPasswordMessage.setForeground(Color.red);
            lblPasswordMessage.setText(errors.get("txtPassword"));
        } else {
            lblPasswordMessage.setForeground(Color.green);
            lblPasswordMessage.setText("Hợp lệ.");
        }
    }

    // Xử lý reset form.
    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Xử lý reset.
            txtAccount.setText("");
            txtPassword.setText("");
        }
    }

}
