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
import Funcionalidades.HorariosTeoriaPracticas;
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
public class HorariosTeoriaPracticasTest {
    
    public HorariosTeoriaPracticasTest() {
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
     * Test of coincidenPracticaTeoria method, of class HorariosTeoriaPracticas.
     */
    @Test
    public void testCoincidenPracticaTeoria() {
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        HorariosTeoriaPracticas instance2 = new HorariosTeoriaPracticas();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(0));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(5));
        
        instance.VerAsignaturas(horarios);
        boolean expResult = true;
        boolean result = instance2.coincidenPracticaTeoria(horarios);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testCoincidenPracticaTeoria_2() {
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        HorariosTeoriaPracticas instance2 = new HorariosTeoriaPracticas();
        
        List<Asignatura> horarios = new ArrayList<>();
        
        horarios.add(asignaturas.get(2));
        horarios.add(asignaturas.get(3));
        horarios.add(asignaturas.get(6));
        horarios.add(asignaturas.get(1));
        
        
        instance.VerAsignaturas(horarios);
        boolean expResult = true;
        boolean result = instance2.coincidenPracticaTeoria(horarios);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCoincidenPracticaTeoria_3() {
        ManejaAsignatura mAsig=new ManejaAsignatura();
        
        List<Asignatura> asignaturas = mAsig.getAsignaturas();
        
        
        Horarios instance = new Horarios();
        HorariosTeoriaPracticas instance2 = new HorariosTeoriaPracticas();

        
        
        instance.VerAsignaturas(asignaturas);
        boolean expResult = true;
        boolean result = instance2.coincidenPracticaTeoria(asignaturas);
        assertEquals(expResult, result);
    }
    
}
