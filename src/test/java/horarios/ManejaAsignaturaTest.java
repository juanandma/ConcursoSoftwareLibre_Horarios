/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import Persistencia.ManejaAsignatura;
import Entidades.Hora;
import Entidades.Asignatura;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
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
public class ManejaAsignaturaTest {
    
    public ManejaAsignaturaTest() {
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
     * Test of iniciaOperacion method, of class ManejaAsignatura.
     */
    @Test
    public void testIniciaOperacion() {
        System.out.println("iniciaOperacion");
        ManejaAsignatura instance = new ManejaAsignatura();
        instance.iniciaOperacion();

    }


    /**
     * Test of getAsignaturas method, of class ManejaAsignatura.
     */
    @Test
    public void testGetAsignaturas() {
        System.out.println("getAsignaturas");
        ManejaAsignatura instance = new ManejaAsignatura();
        List<Asignatura> result = instance.getAsignaturas();
        
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getNombre());
            

            Set<Hora> asigHoras = result.get(i).getHoras();
            
            for (Iterator<Hora> it = asigHoras.iterator(); it.hasNext();) {
                
                Hora horas=it.next();
                System.out.println(horas.getHInicio()+" "+horas.getHFin());
            }
        }
        
        assertNotNull(result);
    }

   
    
}
