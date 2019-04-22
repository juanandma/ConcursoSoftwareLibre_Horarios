/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JUANM
 */
public class HorariosTeoriaTest {
    
    public HorariosTeoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of coincideHorarioTeoria method, of class HorariosTeoria.
     */
    @Test
    public void testCoincideHorarioTeoria() {
        System.out.println("coincideHorarioTeoria");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(0));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(5));
        
        instance.coincideHorarioTeoria(horarios);
        boolean expResult = true;
        boolean result = instance.coincideHorarioTeoria(asignaturas);
        
        instance.VerAsignaturas(horarios);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testCoincideHorarioTeoria_2() {
        System.out.println("coincideHorarioTeoria");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(2));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(6));
        horarios.add(asignaturas.get(1));
        
        instance.coincideHorarioTeoria(horarios);
        boolean expResult = true;
        boolean result = instance.coincideHorarioTeoria(asignaturas);
        
        instance.VerAsignaturas(horarios);
        assertEquals(expResult, result);
    }
    
}
