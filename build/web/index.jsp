<%-- 
    Document   : index
    Created on : 19/09/2020, 09:29:28 PM
    Author     : kevin
--%>
<%@page import="class_prod.marcas" %>
<%@page import="class_prod.producto " %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 <div class="container" >TABLA PRODUCTOS FERRETERIA</h1>
        <div class="container">
            <form action="cone_main"  method="post" class="form-group">
      <label><b>Id</b></label>
                <input type="text" name="txt_id_produto" id="txt_id_producto" class="form-control" value="0" readonly>
                <label><b>Producto</b></label>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="XXXXXXXXXX" required>
                <label><b>Marca</b></label>
                <select name="drop_id_marca" id="drop_id_marca" class="form-control">
                        <% 
                        marcas marca = new marcas();
                        HashMap<String,String> tabla = marca.Mostrar();
                        for(String r: tabla.keySet() ){
                        
                         out.println("<option value='"+ r + "' >" + tabla.get(r) + "</option>");
                        
                        }

                        %>
                   
                </select>
                <label><b>Descripcion</b></label>
                <input type="text" name="txt_descripcion" size="30" id="txt_descripcion" class="form-control" placeholder="Descripcion del producto" required>
                <label><b>Precio costo</b></label>
                <input type="number" step="any" name="txt_costop" id="txt_costop" class="form-control" placeholder="xxx.xx" required>
                <label><b>Precio Venta</b></label>
                <input type="number" step="any" name="txt_costov" id="txt_costov" class="form-control" placeholder="xxx.xx" required>
                <label><b>Producto en existencia</b></label>
                <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="Monto de cantidad " required>
                <br>
                
                
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-dark">AGREGAR</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-danger">MODIFICAR</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-warning" onclick="javascript:if(!confirm('¿Desea eliminar?'))return false">ELIMINAR</button>
                
            </form>
                   <table class="table">  
    <thead>
      <tr>
        <th>PRODUCTO</th>
        <th>MARCA</th>
        <th>DESCRIPCION</th>
        <th>PRECIO COSTO</th>
        <th>PRECIO VENTA</th>
        <th>EXISTENCIA</th>
        
      </tr>
    </thead>
    <tbody id="tbl_producto">
   <%
       
      producto productos = new producto();
    DefaultTableModel tabl = new DefaultTableModel();
    tabl = productos.mostrar_elementos();
   for(int i=0; i<tabl.getRowCount(); i++){
    out.println("<tr data-id="+ tabl.getValueAt(i, 0)+ ">");
    out.println("<td>"+ tabl.getValueAt(i, 1) +"</td>");
    out.println("<td>"+ tabl.getValueAt(i, 2) +"</td>");
    out.println("<td>"+ tabl.getValueAt(i, 3) +"</td>");
    out.println("<td>"+ tabl.getValueAt(i, 4) +"</td>");
    out.println("<td>"+ tabl.getValueAt(i, 5) +"</td>");
    out.println("<td>"+ tabl.getValueAt(i, 6) +"</td>");
    out.println("</tr>");

}
   %>
        
        
        
    </tbody>
  </table>    
            
        </div>
        
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script> 
<script type="text/javascript">
     $('#tbl_producto').on('click','tr td', function(evt){
       var target, id,producto,id_M,descripcion,precio_c,precio_v,existencia; 
       target =$(event.target);
       id = target.parent().data('id');
       id_M = target.parent().data('id_p'); 
        producto =target.parent("tr").find("td").eq(0).html;
       descripcion =target.parent("tr").find("td").eq(2).html;
       precio_c =target.parent("tr").find("td").eq(3).html;
       precio_v =target.parent("tr").find("td").eq(4).html;
       existencia =target.parent("tr").find("td").eq(5).html;
       
    $("#txt_id").val(id);
    $("#txt_Producto").val(producto);
    $("#txt_id_Marca").val(id_M);
    $("#txt_Descripcion").val(descripcion);
    $("#txt_Precio_costo").val(precio_c);
    $("#txt_Precio_venta").val(precio_v);
    $("#txt_Existecia").val(existencia);

  
    });
    

</script>
    </body>
</html>
