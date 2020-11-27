/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Alumno;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface Interface {
    public List<Alumno>getPersonas();
    public Alumno getId(int id);
    public int add(Alumno p);
    public int update(Alumno p);
    public int delete(int id);
}
