/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package ventasmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class conection {
    
    static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    
    /*
    private static final String user="root";
    private static final String password="root";
    private static final int port=3306;
    private static final String url="jdbc:mysql://localhost:"+port+"/customers";
    */
    
    String user;
    String password;
    int port;
    private String url;
    
    public conection(String u,String p,int po) {
        user=u;
        password=p;
        port=po;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public static Connection getConection(){
        return con;
    }
    
    public boolean conectar(){
        url="jdbc:mysql://localhost:"+port+"/customers";
        con = null;
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
            return con!=null;
        }catch(ClassNotFoundException | SQLException ex){
            return false;
        }
    }
    public static Connection getCon() {
        return con;
    }
    
    public void close(){
        con=null;
        /*if(con==null){
            System.out.println("Conexion Terminada");
        }*/
        
    }
    
    public String[][] ResultSetToArray(ResultSet rs) {
		String obj[][] = null;
		int j = 0;
		try {
			rs.last();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			int numFils = rs.getRow();
			obj = new String[numFils][numCols];		
			rs.beforeFirst();
			while (rs.next()) {
				for (int i = 0; i < numCols; i++) {
					obj[j][i] = rs.getObject(i + 1).toString();
				}
				j++;
			}
		} catch (Exception e) {
		}
		return obj;
	}
}   

