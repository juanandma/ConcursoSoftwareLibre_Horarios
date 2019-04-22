/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Persistencia.ManejaAsignatura;
import Funcionalidades.Horarios;
import Entidades.Asignatura;
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
