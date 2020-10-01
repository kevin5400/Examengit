/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_prod;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author kevin
 */
public class marcas {
    private int idmarca;
 conexion conexion;
     public marcas(){}
     public marcas(int idmarca) {
        this.idmarca = idmarca;
    }
    
    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }
    
    
     public HashMap Mostrar(){
    
    HashMap<String,String> drop = new HashMap();
    try{
    conexion = new conexion();
    String codigoquery = "select idmarca as id,marca from marcas;";
   
    conexion.abrir_conexion();
    ResultSet consultar = conexion.conexionBD.createStatement().executeQuery(codigoquery);
    while(consultar.next()){
    drop.put(consultar.getString("id"),consultar.getString("marca"));
    }
    
    conexion.cerrar_conexion();
    
    
    }catch(SQLException ex){}
    
    return drop;
    }
    
   
}
