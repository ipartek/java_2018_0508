package com.ipartek.formacion.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    //nombre de clase del driver mysql que nos permitira hacer la conexion a la bd de mysql
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //cadena de conexion de MySql
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/youtube_casa?useSSL=false";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "admin";
    //
    private static Driver driver = null;
    
    //con synchronized nos garantizamos que solo un hilo podra ejecturase a la vez
    public static synchronized Connection getConnection() throws SQLException {
        
            if (driver == null){
                try {
                    
                    //cargamos en memoria la clase del driver de mysql
                    Class jdbcDriverClass =  Class.forName(JDBC_DRIVER);
                    //cargada en memoria podemos instanciar la clase 
                    driver = (Driver) jdbcDriverClass.newInstance();
                    //registramos la variable del tipo driver
                    DriverManager.registerDriver(driver);
                    //Con todo esto ponemos en memoria la clase del driver que queremos utilizar
                } catch (Exception e) {
                    System.out.print("Se producjo un error al cargar el driver JDBC");
                }
                
                
            }
     return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }
    
    /**
     * Creamos 2 funciones con sobrecarga de operadores para poder cerrar
     * los objetos de conexion instaciados
     * @param resultado 
     */
    public static void close(ResultSet resultado){
        try {
        if(resultado != null){
            
                resultado.close();
           }
        } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
        
    }
    
    public static void close(Connection conexion){
        try {
        if(conexion != null){
            
                conexion.close();
           }
        } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
    }
}
