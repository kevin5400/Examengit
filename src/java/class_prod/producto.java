/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_prod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kevin
 */
public class producto extends marcas{
    private int idproducto,existencia;
    private String producto,descripcion;
    private float precio_costo,precio_venta;
    
    conexion conexion;
    public producto(){}
    public producto(int idproducto, int existencia, String producto, String descripcion, float precio_costo, float precio_venta, int idmarca) {
        super(idmarca);
        this.idproducto = idproducto;
        this.existencia = existencia;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
    }
    
    

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
     public int agregar(){
    int retornar=0;
    try{
        PreparedStatement parametros;
       conexion = new conexion();
      String codigo_query="insert into productos (producto,idmarca,descripcion,precio_costo,precio_venta,existencia) values (?,?,?,?,?,?);"; 
      conexion.abrir_conexion();
        
        parametros=(PreparedStatement)conexion.conexionBD.prepareStatement(codigo_query);
        
        parametros.setString(1, getProducto());
        parametros.setInt(2, getIdmarca());
        parametros.setString(3, getDescripcion());
        parametros.setFloat(4, getPrecio_costo());
        parametros.setFloat(5, getPrecio_venta());
        parametros.setInt(6, getExistencia());
        
        retornar = parametros.executeUpdate();
        conexion.cerrar_conexion();
    }catch(SQLException ex){
       System.out.println(ex.getMessage());
      return retornar = 0;
   
    }
    
    
    return retornar;
    }
      
   
    public int modificar(){
    int retorno =0;
    try{
           PreparedStatement parametros;
       conexion = new conexion();
      String codigo_query="update productos set producto=?,idmarca=?,descripcion=?,precio_costo=?,precio_venta=?,existencia=? where idproducto=?; "; 
        conexion.abrir_conexion();
        
        parametros=(PreparedStatement)conexion.conexionBD.prepareStatement(codigo_query);
        
         parametros.setString(1, getProducto());
        parametros.setInt(2, getIdmarca());
        parametros.setString(3, getDescripcion());
        parametros.setFloat(4, getPrecio_costo());
        parametros.setFloat(5, getPrecio_venta());
        parametros.setInt(6, getExistencia());
        parametros.setInt(7, getIdproducto());
     
        
        retorno = parametros.executeUpdate();
        conexion.cerrar_conexion();
    
    }catch(SQLException ex){
      System.out.println(ex.getMessage());
      return retorno = 0;
    
    
    }
    
    return retorno;
    }
   
        public int eliminar(){
    int retorno=0;
        try{
           PreparedStatement parametros;
       conexion = new conexion();
      String codigo_query="DELETE FROM  productos  WHERE idproducto=?;"; 
        conexion.abrir_conexion();
        
        parametros=(PreparedStatement)conexion.conexionBD.prepareStatement(codigo_query);
         
        parametros.setInt(1, getIdproducto());
        
        retorno = parametros.executeUpdate();
        conexion.cerrar_conexion();
    
    }catch(SQLException ex){
      System.out.println(ex.getMessage());
      return retorno = 0;
    
    }
    
    return retorno;
    }
    public DefaultTableModel mostrar_elementos(){
    
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    conexion = new conexion();
    conexion.abrir_conexion();
    
    String codigo_query = "select e.idproducto as id,e.producto,t.marca,e.descripcion,e.precio_costo,e.precio_venta,e.existencia from productos as e inner join marcas as t on e.idmarca = t.idmarca;";
    ResultSet consulta = conexion.conexionBD.createStatement().executeQuery(codigo_query);
    String encabezado[]= {"Id","Producto","Marca","Descripcion","Precio_costo","Precio_venta","Existencia"};
    tabla.setColumnIdentifiers(encabezado);
    String datos[]=new String[7];
    while(consulta.next()){
    datos[0] = consulta.getString("id");
    datos[1] = consulta.getString("producto");
    datos[2] = consulta.getString("marca");
    datos[3] = consulta.getString("descripcion");
    datos[4] = consulta.getString("precio_costo");
    datos[5] = consulta.getString("precio_venta");
    datos[6] = consulta.getString("existencia");
    
   // datos[9] = consulta.getString("id_tipo_sangre");
 
  
    tabla.addRow(datos);
  
    }
    
      conexion.cerrar_conexion();
    
    }catch(SQLException ex){
    
    System.out.println(ex.getMessage());
    
    }
    
    
    
    return tabla;
    } 
   
}
