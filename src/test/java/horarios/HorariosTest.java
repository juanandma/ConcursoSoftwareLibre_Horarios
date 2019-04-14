/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

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
        List<Asignatura> asignaturas = null;
        Horarios instance = new Horarios();
        boolean expResult = false;
        boolean result = instance.coincideHorarioTeoria(asignaturas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerAsignaturas method, of class Horarios.
     */
    @Test
    public void testVerAsignaturas() {
        System.out.println("VerAsignaturas");
        List<Asignatura> asignaturas = null;
        Horarios instance = new Horarios();
        instance.VerAsignaturas(asignaturas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
