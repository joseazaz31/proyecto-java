<%-- 
    Document   : Editar
    Created on : 18/11/2020, 12:03:39 PM
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
            <h1>EDITAR ALUMNO</h1>
            </div>
            <div>
            ID
            <input type="text" name="txtId" value="${alumno.id}"/>
            </div>
            <div>
            Nombres
            <input type="text" name="txtNombres" value="${alumno.nombres}"/>
            </div>
            <div>
            Apellidos
            <input type="text" name="txtApellidos" value="${alumno.apellidos}"/>
            </div>
            <div>
            Nota1
            <input type="text" name="txtNota1" value="${alumno.nota1}"/>
            </div>
            <div>
            Nota2
            <input type="text" name="txtNota2" value="${alumno.nota2}"/>
            </div>
            <div>
            Promedio
            <input type="text" name="txtPromedio" value="${alumno.promedio}"/>
            </div>
            <div>
            <input type="submit" value="actualizar" name="accion"/>
            <a href="controlador?accion=listar">Volver</a>
            </div>
        </form>
 </center>
    </body>
</html>

