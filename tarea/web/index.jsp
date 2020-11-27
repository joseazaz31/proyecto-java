<%-- 
    Document   : index
    Created on : 17/11/2020, 04:22:04 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                font-size: 30px;
                
                
            }
            th{
                background: skyblue;
                font-size: 30px;
            }
            td{
                background: skyblue;
                font-size: 30px;
            }
            div{
                border-bottom: 10px;
                font-size: 20px;
            }
            button{
                border-bottom: 8px;
            }
            </style>

        <h1>REGISTRO</h1>
        <div>
            
            <a href="controlador?accion=listar" type="submit">LISTAR</a>
            <a  href="controlador?accion=agregar" type="submit">Agregar Nuevo</a>
    
        <table border="1">
            <thead>
            
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDOS</th>
                    <th>NOTA 1</th>
                    <th>NOTA 2</th>
                    <th>PROMEDIO</th>
                
            
            </thead>
            <c:forEach var="alumno" items="${Alumnos}">
            <tbody>
                <tr>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombres}</td>
                    <td>${alumno.apellidos}</td>
                    <td>${alumno.nota1}</td>
                    <td>${alumno.nota2}</td>
                    <td>${alumno.promedio}</td>
                    <td>
                        <a href="controlador?accion=editar&id=${alumno.id}">Editar</a>
                        <a href="controlador?accion=eliminar&id=${alumno.id}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </center>

    </body>
</html>
