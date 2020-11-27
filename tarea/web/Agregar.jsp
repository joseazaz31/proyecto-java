<%-- 
    Document   : Agregar
    Created on : 18/11/2020, 10:40:04 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
          <style>
             h1{
                background: red;
                font-size: 34px;                   
                      }
            div{
                background: greenyellow;
                font-size: 20px;
                      }
            input{
                font-size: 20px;
   
                     }
            </style>
        <form action="controlador" method="POST">
    
            <div>
                <h1>AGREGAR ALUMNOo</h1>
            </div>
            <div>
            Nombres
            <input type="text" name="txtNombres"/>
            </div>
            <div>
            Apellidos
            <input type="text" name="txtApellidos"/>
            </div>
            <div>
            Nota1
            <input type="text" name="txtNota1"/>
            </div>
            <div>
            Nota2
            <input type="text" name="txtNota2"/>
            </div>
            <div>
            <input type="submit" value="nuevo" name="accion"/>
            <a href="controlador?accion=listar">Volver</a>
            </div>
        </form>
    </center>
    </body>
</html>
