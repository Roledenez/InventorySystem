/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysystem.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

   
public class DBUtil {
    private static final String USERNAME ="root";
    private static final String PASSWORD ="Kenneth";
    private static final String CONN ="jdbc:mysql://localhost:3306/inventory_db";

    public static Connection getConnection(DBType dbType) throws SQLException{
        switch(dbType){
            case MYSQL:
                return DriverManager.getConnection(CONN+"?user="+USERNAME+"&password="+PASSWORD);
                
            default:
                return null;
        }
    
    }
    
    public static void errorProcess(SQLException e){
        System.out.println("Eroor message : "+e.getMessage());
        System.out.println("Eroor code : "+e.getErrorCode());
        System.out.println("SQL state : "+e.getSQLState());
    }
}
