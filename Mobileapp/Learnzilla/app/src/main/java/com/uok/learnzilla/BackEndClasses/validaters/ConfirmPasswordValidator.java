package com.uok.learnzilla.BackEndClasses.validaters;

public class ConfirmPasswordValidator {
    public boolean validateConfirmPassword(String pass, String cPass) {
        if (!pass.equals(cPass)) {
            return false;
        }
        return true;
    }
}
