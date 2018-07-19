/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.utilities;

import java.util.regex.Pattern;

/**
 *
 * @author Lea
 */
public class InputValidator {

    private static final Pattern PHONE_NUM_PATTERN = Pattern.compile("\\d{3}-\\d{7}");
    private static final Pattern OPID_PATTERN = Pattern.compile("\\d{11}");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    private InputValidator() {
    }

    public static boolean isValidPhoneNumber(String inputPhone) {
        return PHONE_NUM_PATTERN.matcher(inputPhone).matches();
    }

    public static boolean isValidOpid(String inputOpid) {
        return OPID_PATTERN.matcher(inputOpid).matches();
    }

    public static boolean isValidEmail(String inputEmail) {
        return EMAIL_PATTERN.matcher(inputEmail).matches();
    }

}
