/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Persistencia.ManejaAsignatura;
import Funcionalidades.Horarios;
import Entidades.Asignatura;
import Funcionalidades.HorariosPracticas;
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
public class HorariosPracticasTest {
    
    public HorariosPracticasTest() {
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
     * Test of coincidenAsignaturasPracticas2 method, of class HorariosPracticas.
     */
    @Test
    public void testCoincidenAsignaturasPracticas2() {
        System.out.println("coincidenAsignaturasPracticas2");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        HorariosPracticas instance2 = new HorariosPracticas();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(0));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(5));
        
        instance.VerAsignaturas(horarios);
        boolean expResult = false;
        boolean result = instance2.coincidenAsignaturasPracticas2(horarios);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCoincidenAsignaturasPracticas2_2() {
        System.out.println("coincidenAsignaturasPracticas2");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        HorariosPracticas instance2 = new HorariosPracticas();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(2));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(6));
        horarios.add(asignaturas.get(1));
        
        instance.VerAsignaturas(horarios);
        boolean expResult = false;
        boolean result = instance2.coincidenAsignaturasPracticas2(horarios);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCoincidenAsignaturasPracticas2_3() {
        System.out.println("coincidenAsignaturasPracticas2");
        
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        HorariosPracticas instance2 = new HorariosPracticas();
        
        
        
        instance.VerAsignaturas(asignaturas);
        boolean expResult = true;
        boolean result = instance2.coincidenAsignaturasPracticas2(asignaturas);
        assertEquals(expResult, result);
    }
    
}
