/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem;

import inventorysystem.MyCustomException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Selaru Sinbath
 */
public class InputHelper {

    //for console application
    public static String getInput(String prompt) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        System.out.flush();

        try {
            return stdin.readLine();
        } catch (IOException e) {
            return "Error" + e.getMessage();
        }
    }

    //for console application
    public static double getDoubleInput(String prompt) throws NumberFormatException {
        String input = getInput(prompt);
        return Double.parseDouble(input);

    }

    //for console application
    public static int getIntegerInput(String input) throws NumberFormatException {
       // String input = getInput(prompt);
        return Integer.parseInt(input);
    }

       //for GUI application 
    public static float getPositiveFloat(String str) {
        float floatNum = 0;
        try {

            if (str.trim().length() == 0) {
                try {
                    throw new MyCustomException("Inserted field can not be empty");
                } catch (MyCustomException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                try {
                    floatNum = Float.parseFloat(str);
                } catch (NumberFormatException nex) {
                    try {
                        throw new MyCustomException("Input field can not have letter \n" + nex.getMessage());
                    } catch (MyCustomException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                if (floatNum < 0) {
                    try {
                        throw new MyCustomException("your entered number must be positive");
                    } catch (MyCustomException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    return floatNum;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        return -1.1f;//error range
    }

    //for GUI application
    public static int getPositiveInt(String str) {
        int intNum = 0;
        try {

            if (str.trim().length() == 0) {
                try {
                    throw new MyCustomException("Insert flied can not be empty");
                } catch (MyCustomException ex) {
                    MyCustomException.CustomException(ex.getMessage());
                    Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                intNum = Integer.parseInt(str);
                if (intNum < 0) {
                    try {
                        throw new MyCustomException("your entered number must be positive");
                    } catch (MyCustomException ex) {
                        MyCustomException.CustomException(ex.getMessage());
                        Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return intNum;
                }
            }
        } catch (NumberFormatException e) {
            MyCustomException.CustomException(e.getMessage());
            System.err.println(e.getMessage());

        }
        return -1;//error range
    }

    //for GUI application
    public static Date getValidFormatedDate(String str) {
        DateFormat df = new SimpleDateFormat("MMMM d, yyyy",Locale.ENGLISH);
        Date date = null;
        if (str.trim().length() == 0) {
            try {
                throw new MyCustomException("EX date flied can not be empty");
            } catch (MyCustomException ex) {
                MyCustomException.CustomException(ex.getMessage());
                Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                date = df.parse(str);
            } catch (ParseException ex) {
                try {
                    throw new MyCustomException("Date is not valied type \n" + ex.getMessage());

                } catch (MyCustomException ex1) {
                    MyCustomException.CustomException(ex1.getMessage());
                    Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        return date;

    }
}
