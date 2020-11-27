/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Alumno;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class PersonaDAO implements Interface{

    @Override
    public List<Alumno> getPersonas() {
        List<Alumno>alumnos=new ArrayList<>();
        String sql="select * from alumno";
        try {
             PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while (rs.next()) {
             Alumno p =new Alumno();    
             p.setId(rs.getInt(1));
             p.setNombres(rs.getString(2));
             p.setApellidos(rs.getString(3));
             p.setNota1(rs.getInt(4));
             p.setNota2(rs.getInt(5));
             p.setPromedio(rs.getFloat(6));
             alumnos.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error: "+ e);
        }return alumnos;
    }

    @Override
    public Alumno getId(int id) {
        String sql="select *from alumno where idAlumno=?";
        Alumno persona=new Alumno();
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            persona.setId(rs.getInt(1));
            persona.setNombres(rs.getString(2));
            persona.setApellidos(rs.getString(3));
            persona.setNota1(rs.getInt(4));
            persona.setNota2(rs.getInt(5));
            persona.setPromedio(rs.getFloat(6));
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }return persona;
    }

    @Override
    public int add(Alumno p) {
        int resultado=0;
        String sql="insert into alumno(Nombres,Apellidos,Nota1,Nota2,Promedio) values(?,?,?,?,?)";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setInt(3, p.getNota1());
            ps.setInt(4, p.getNota2());
            ps.setFloat(5, p.getPromedio());
            resultado=ps.executeUpdate();
            
        } catch (Exception e) {
        System.err.println("Error para agregar para la BD" + e);
        }return resultado;
    }

    @Override
    public int update(Alumno p) {
                int resultado=0;
        String sql="update alumno set Nombres=?,Apellidos=?,Nota1=?,Nota2=?,Promedio=? where idAlumno=?";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setInt(3, p.getNota1());
            ps.setInt(4, p.getNota2());
            ps.setFloat(5, p.getPromedio());
            ps.setInt(6, p.getId());
            resultado=ps.executeUpdate();
            
        } catch (Exception e) {
        System.err.println("Error para editar para la BD" + e);
        }return resultado;
    }

    @Override
    public int delete(int id) {
        int resultado=0;
        String sql="delete from alumno where idAlumno=" + id;
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error para eliminar de la BD: " + e);
        }return resultado;
    }

    
    
}
