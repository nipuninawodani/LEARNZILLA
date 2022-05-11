package com.uok.learnzilla.BackEndClasses;

public class ConfirmPasswordValidator {
    public boolean validateConfirmPassword(String pass, String cPass) {
        if (!pass.equals(cPass)) {
            return false;
        }
        return true;
    }
}
