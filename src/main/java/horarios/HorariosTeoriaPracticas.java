/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class HorariosTeoriaPracticas extends HorariosAbstracta{
    
    // devuelve true si no existe alguna conbinacion grupos de practicas de todas las 
    //asignaturas que no tenga ninguna coincidencia entre teorias
    public boolean coincidenPracticaTeoria(List<Asignatura> asignaturas)
    {
        boolean coincide = false;

        int i = 0;

        while (coincide == false && i < asignaturas.size())
        {
            Asignatura actual = asignaturas.get(i);
            coincide = coincidenPracticaTeoria(actual, asignaturas);
            i++;
        }

        return coincide;
    }

    // devuelve true si no existe alguna conbinacion de una practica de
    // esta asignatua con las teorias de las demas
    private boolean coincidenPracticaTeoria(Asignatura actual, List<Asignatura> asignaturas)
    {
        boolean coincide = true;

        int i = 0;

        while (coincide == true && i < actual.getHorarioPractica().size())
        {
            Hora horaPractica = actual.getHorarioPractica().get(i);
            coincide = coincidenPracticaTeoria(horaPractica, asignaturas);
            i++;
        }

        return coincide;
    }

    // devuelve true si no existe alguna conbinacion de esta hora de
    // esta asignatua con las teorias de las demas
    private boolean coincidenPracticaTeoria(Hora horaPractica, List<Asignatura> asignaturas)
    {
        boolean coincide = false;

        int i = 0;

        while (coincide == false && i < asignaturas.size())
        {
            List<Hora> horasTeoria = new ArrayList<>(asignaturas.get(i).getHorarioTeoria());
            horasTeoria.add(horaPractica);

            if (coincideListaHoras(horasTeoria))
            {
                coincide = true;
            }

            i++;
        }

        return coincide;
    }
}
