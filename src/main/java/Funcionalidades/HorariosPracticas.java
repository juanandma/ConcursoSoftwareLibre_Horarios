/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Funcionalidades.HorariosAbstracta;
import Entidades.Hora;
import Entidades.Asignatura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class HorariosPracticas extends HorariosAbstracta{
    
    private static HorariosPracticas horariosPracticas = new HorariosPracticas();

    public static HorariosPracticas getHorariosPracticas() {
        
        return horariosPracticas;
    }
    
    
    public boolean coincidenAsignaturasPracticas2(List<Asignatura> asignaturas)
    {

        boolean coincide = false;
        List<Asignatura> restantes = new ArrayList<>(asignaturas);
        List<Hora> solActual = new ArrayList<>();

        coincide = coincidenAsignaturasPracticas2Recursiva( solActual, restantes);

        return coincide;
    }

    private boolean coincidenAsignaturasPracticas2Recursiva( List<Hora> solActual, List<Asignatura> restantes)
    {

        boolean coincide = true;

        if (restantes.size() == 0)
        {
            coincide = false;
        } else
        {
            int i = 0;
            while (coincide == true && i < restantes.get(0).getHorarioPractica().size())
            {
                Hora hora1 = restantes.get(0).getHorarioPractica().get(i);
                List<Hora> solActualAux = new ArrayList<>(solActual);
                solActualAux.add(hora1);

                if (coincideListaHoras(solActualAux) == false)
                {
                    List<Asignatura> restantesAuxiliar = new ArrayList<>(restantes);
                    restantesAuxiliar.remove(0);
                    coincide = coincidenAsignaturasPracticas2Recursiva( solActualAux, restantesAuxiliar);
                }

                if (coincide == false)
                {
                    solActual = solActualAux;
                }

                i++;
            }

        }

        return coincide;
    }
}
