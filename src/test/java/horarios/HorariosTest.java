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
        
        LocalTime inicio1 = LocalTime.of(10, 0);
        LocalTime fin1 = LocalTime.of(11, 0);
        LocalTime inicio2 = LocalTime.of(9, 0);
        LocalTime fin2 = LocalTime.of(9, 30);
        
        
        Hora h1= new Hora(1,inicio1,fin1);
        Hora h2= new Hora(1, inicio2, fin2);
        
        
        List<Hora> Teoria1 = new ArrayList<>();
        Teoria1.add(h1);
        List<Hora> Teoria2 = new ArrayList<>();
        Teoria2.add(h2);
        
        
        Asignatura asig1=new Asignatura("mates", 1, 1, 1, Teoria1, null);
        Asignatura asig2=new Asignatura("fisica", 1, 1, 1, Teoria2, null);
        
        
        List<Asignatura> asignaturas = new ArrayList<>();
        
        asignaturas.add(asig2);
        asignaturas.add(asig1);
        
        Horarios instance = new Horarios();
        
        instance.coincideHorarioTeoria(asignaturas);
        boolean expResult = false;
        boolean result = instance.coincideHorarioTeoria(asignaturas);
        
        
        assertEquals(expResult, result);
    }

    /**
     * Test of coincidenAsignaturasPracticas method, of class Horarios.
     */
    /*@Test
    public void testCoincidenAsignaturasPracticas() {
        System.out.println("coincidenAsignaturasPracticas");
        
        LocalTime inicio1 = LocalTime.of(10, 0);
        LocalTime fin1 = LocalTime.of(11, 0);
        LocalTime inicio2 = LocalTime.of(9, 0);
        LocalTime fin2 = LocalTime.of(9, 30);
        
        
        Hora h1= new Hora(1,inicio1,fin1);
        Hora h2= new Hora(1, inicio2, fin2);
        
        
        List<Hora> Practica1 = new ArrayList<>();
        Practica1.add(h1);
        List<Hora> Practica2 = new ArrayList<>();
        Practica2.add(h2);
        
        
        Asignatura asig1=new Asignatura("mates", 1, 1, 1, null, Practica1);
        Asignatura asig2=new Asignatura("fisica", 1, 1, 1, null, Practica2);
        
        
        List<Asignatura> asignaturas = new ArrayList<>();
        
        asignaturas.add(asig2);
        asignaturas.add(asig1);
        Horarios instance = new Horarios();
        boolean expResult = false;
        boolean result = instance.coincidenAsignaturasPracticas(asignaturas);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of coincidenPracticaTeoria method, of class Horarios.
     */
    @Test
    public void testCoincidenPracticaTeoria() {
        System.out.println("coincidenPracticaTeoria");
        
        LocalTime inicio1 = LocalTime.of(10, 0);
        LocalTime fin1 = LocalTime.of(11, 0);
        
        LocalTime inicio2 = LocalTime.of(9, 0);
        LocalTime fin2 = LocalTime.of(9, 30);
        
        LocalTime inicio3 = LocalTime.of(12, 0);
        LocalTime fin3 = LocalTime.of(13, 30);
        
        LocalTime inicio4 = LocalTime.of(9, 0);
        LocalTime fin4 = LocalTime.of(11, 30);
        
        
        Hora h1= new Hora(1,inicio1,fin1);
        Hora h2= new Hora(1, inicio2, fin2);
        Hora h3= new Hora(1, inicio3, fin3);
        Hora h4= new Hora(1, inicio4, fin4);
        
        List<Hora> Teoria1 = new ArrayList<>();
        Teoria1.add(h3);
        List<Hora> Practica1 = new ArrayList<>();
        Practica1.add(h1);
        
        List<Hora> Teoria2 = new ArrayList<>();
        Teoria2.add(h4);
        List<Hora> Practica2 = new ArrayList<>();
        Practica2.add(h2);
        
        
        Asignatura asig1=new Asignatura("mates", 1, 1, 1, Teoria1, Practica1);
        Asignatura asig2=new Asignatura("fisica", 1, 1, 1, Teoria2, Practica2);
        
        
        List<Asignatura> asignaturas = new ArrayList<>();
        
        asignaturas.add(asig2);
        asignaturas.add(asig1);
        
        Horarios instance = new Horarios();
        boolean expResult = true;
        boolean result = instance.coincidenPracticaTeoria(asignaturas);
        assertEquals(expResult, result);
        

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
