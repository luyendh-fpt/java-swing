/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.util.HashMap;

/**
 *
 * @author daolinh
 */
public class FormHandle {

    public HashMap<String, String> validateLogin(String account, String password) {
        HashMap<String, String> errors = new HashMap<>();
        if (account.isEmpty()) {
            errors.put("txtAccount", "* Vui lòng nhập thông tin account.");
        }
        if (password.isEmpty()) {
            errors.put("txtPassword", "* Password quá ngắn.");
        }
        return errors;
    }
}
