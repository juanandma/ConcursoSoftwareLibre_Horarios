/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;
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
public class HorariosTest {
    
    public HorariosTest() {
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
     * Test of coincideHorarioTeoria method, of class Horarios.
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
        boolean expResult = false;
        boolean result = instance.coincideHorarioTeoria(asignaturas);
        
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of coincidenAsignaturasPracticas method, of class Horarios.
     */
    
    @Test
    public void testCoincidenAsignaturasPracticas() {
        System.out.println("coincidenAsignaturasPracticas");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(0));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(5));
        
        
        boolean expResult = false;
        boolean result = instance.coincidenAsignaturasPracticas(horarios);
        assertEquals(expResult, result);
    }

    /**
     * Test of coincidenPracticaTeoria method, of class Horarios.
     */
    /*@Test
    public void testCoincidenPracticaTeoria() {
        System.out.println("coincidenPracticaTeoria");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(0));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(5));
        
        
        boolean expResult = false;
        boolean result = instance.coincidenPracticaTeoria(horarios);
        assertEquals(expResult, result);
        

    }*/

    /**
     * Test of VerAsignaturas method, of class Horarios.
     */
    @Test
    public void testVerAsignaturas() {
        System.out.println("VerAsignaturas");
        List<Asignatura> asignaturas = null;
        Horarios instance = new Horarios();
        instance.VerAsignaturas(asignaturas);

        
    }

}
