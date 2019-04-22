/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Funcionalidades.Horarios;
import Entidades.Hora;
import Entidades.Asignatura;
import Funcionalidades.HorariosGet;
import Funcionalidades.HorariosPracticas;
import Funcionalidades.HorariosTeoria;
import Funcionalidades.HorariosTeoriaPracticas;
import Persistencia.ManejaAsignatura;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUANM
 */
public class MainInterfaz
{

    private List<Asignatura> asignaturas;
    private List<Asignatura> asignaturasSeleccionadas;
    private Horarios horario;
    private ManejaAsignatura conexion;
    private HorariosTeoria horariosTeoria = new HorariosTeoria();
    private HorariosTeoriaPracticas horariosTeoriaPracticas = new HorariosTeoriaPracticas();
    private HorariosPracticas horariosPracticas = new HorariosPracticas();
    private HorariosGet horariosGet = new HorariosGet();

    MainInterfaz()
    {
        // conexion con la base de datos
        conexion = new ManejaAsignatura();

        // inicializacion de variables
        asignaturas = conexion.getAsignaturas();
        asignaturasSeleccionadas = new ArrayList<>();
        horario = new Horarios();
    }
  

    
    boolean comprobarHorario()
    {
        boolean coincide = false;

        coincide = horariosTeoria.coincideHorarioTeoria(asignaturasSeleccionadas);

        if (coincide == false)
        {
            coincide = horariosTeoriaPracticas.coincidenPracticaTeoria(asignaturasSeleccionadas);
        }

        if (coincide == false)
        {
            coincide = horariosPracticas.coincidenAsignaturasPracticas2(asignaturasSeleccionadas);
        }

        return !coincide;
    }

    void borrarSeleccionadas()
    {
        // borro las asignaturas seleccionadas anteriormente
        asignaturasSeleccionadas = new ArrayList<>();
    }
    
    void seleccionarAsignatura(String nombreAsig)
    {
        
        int j = 0;
        boolean encontrado = false;

        while (j < asignaturas.size() && encontrado == false)
        {
            if (nombreAsig.equals(asignaturas.get(j).getNombre()))
            {
                encontrado = true;
                asignaturasSeleccionadas.add(asignaturas.get(j));
            }
            j++;
        }
    }

    List<Hora> getHorario()
    {
        return (horariosGet.getHorario(asignaturasSeleccionadas));
    }
    
    List<Asignatura> getAsignaturas()
    {
        return asignaturas;
    }
    
    List<Asignatura> getAsignaturasSeleccionadas()
    {
        return asignaturasSeleccionadas;
    }

}
