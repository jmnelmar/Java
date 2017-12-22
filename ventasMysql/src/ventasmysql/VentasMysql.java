/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class VentasMysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String usr;
        String pass;
        int port;
        String sql="";
        Scanner scan=new Scanner(System.in);
        System.out.print("User: ");
        usr=scan.nextLine();
        System.out.print("Password:");
        pass=scan.nextLine();
        System.out.print("Port:");
        port=scan.nextInt();
        conection con=new conection(usr,pass,port);
        
        if(con.conectar()){
            System.out.println("Coneccion Establecida!");
            
            while(!sql.equals("exit;")){
                System.out.print(">");
                sql=scan.nextLine();
                PreparedStatement prep;
                if(!sql.equals("")){
                    try {
                    prep = con.con.prepareStatement(sql);
                    ResultSet rs;
                    //prep.executeQuery();
                    if(sql.contains("insert") || sql.contains("delete") || sql.contains("update")){
                        prep.execute();
                        if(sql.contains("insert")){
                            rs=prep.executeQuery("select * from "+sql.split(" ")[2]+";");
                        }else{
                            rs=prep.executeQuery("select * from "+sql.split(" ")[3]+";");

                        }
                        
                    }else{
                        rs=prep.executeQuery();
                    }
                    
                    if(!sql.contains("use")){
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int numCols = rsmd.getColumnCount();
                        int numFils = rs.getRow();
                        
                        int j=0;
                        
                        for(int i=1;i<=numCols;i++){
                            
                            System.out.print(rsmd.getColumnName(i)+"|");
                        }
                        System.out.println(" ");
                        while (rs.next()) {
                            for (int i = 0; i < numCols; i++) {
                            	/*obj[j][i] =*/
                                System.out.print(rs.getObject(i + 1).toString()+"|");
                            }
                                System.out.println("");
                                j++;
                            }
                    }else{
                        System.out.println("Database changed");
                    }
                    
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(VentasMysql.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
               
                //sql=scan.nextLine();
            }
            if(sql.equals("exit;")){
                con.close();
                System.out.print("Coneccion terminada");
            }
        }else{
            System.out.println("Imposible establecer la coneccion");
        }
        
    }
    
    
    
}
