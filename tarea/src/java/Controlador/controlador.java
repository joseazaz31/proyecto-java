/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class controlador extends HttpServlet {
    PersonaDAO dao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        List<Alumno>alumnos=new ArrayList<>();
        
        
        switch(accion){
            case "listar":
                dao=new PersonaDAO();
                alumnos =dao.getPersonas();
                request.setAttribute("Alumnos", alumnos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "agregar":
                request.getRequestDispatcher("Agregar.jsp").forward(request, response);
                break;
            case "nuevo":
                
                int r=0;
                String nombres=request.getParameter("txtNombres");
                String apellidos=request.getParameter("txtApellidos");
                int nota1=Integer.parseInt(request.getParameter("txtNota1"));
                int nota2 =Integer.parseInt( request.getParameter("txtNota2"));
                float promedio=(nota1+nota2)/2;
                Alumno p=new Alumno();
                p.setNombres(nombres);
                p.setApellidos(apellidos);
                p.setNota1(nota1);
                p.setNota2(nota2);
                p.setPromedio(promedio);
                r=dao.add(p);
                if(r!=0){
                request.setAttribute("mensaje", "SE AGREGO CON EXITO");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else{
                request.setAttribute("mensaje","Error al guardar");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
            case "editar":
                int id=Integer.valueOf(request.getParameter("id"));
                Alumno alumno=dao.getId(id);
                request.setAttribute("alumno", alumno);
                request.getRequestDispatcher("Editar.jsp").forward(request, response);
                break;
             case "actualizar":
                int resultado=0;
                String nombres1=request.getParameter("txtNombres");
                String apellidos1=request.getParameter("txtApellidos");
                int  nota11=Integer.parseInt(request.getParameter("txtNota1"));
                int  nota21 =Integer.parseInt(request.getParameter("txtNota2"));
                float promedio1 =Float.parseFloat(request.getParameter("txtPromedio"));
                int id1=Integer.valueOf(request.getParameter("txtId"));
                Alumno per=new Alumno(id1 ,nombres1,apellidos1,nota11, nota21,promedio1);
                resultado=dao.update(per);
                if(resultado!=0){
                request.setAttribute("mensaje", "SE EDITO  CON EXITO");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else{
                request.setAttribute("mensaje","ERROR AL EDITAR ");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                

            case "eliminar":
                int idAlumno=Integer.valueOf(request.getParameter("id"));
                int res=dao.delete(idAlumno);
                if(res!=0){
                request.setAttribute("mensaje", "SE ELIMINO CON EXITO");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else{
                request.setAttribute("mensaje","Error al ELIMINAR EN LA BASE DE DATOS");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
            
        
    

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
