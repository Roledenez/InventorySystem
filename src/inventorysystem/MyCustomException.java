/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Selaru Sinbath
 */
public class MyCustomException extends Exception {

    public MyCustomException(String str) {
        super(str);
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, str, "Error", JOptionPane.ERROR_MESSAGE);
        
    }
    
    public static void CustomException(String str){
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, str, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
