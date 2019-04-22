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
public class HorariosGet extends HorariosAbstracta{
    
    //devuelve una lista de horas llamando a la funcion recursiva
    //se asume que las asignaturas son compatibles entre si
    public List<Hora> getHorario(List<Asignatura> asignaturas)
    {
        List<Hora> horario = new ArrayList<>();

        //añade todas las teorias de todas las asignaturas
        for (int i = 0; i < asignaturas.size(); i++)
        {
            for (int j = 0; j < asignaturas.get(i).getHorarioTeoria().size(); j++)
            {
                horario.add(asignaturas.get(i).getHorarioTeoria().get(j));
            }
        }

        List<Asignatura> restantes = asignaturas;

        //se llama a la funcion recursiva
        horario = getHorario(horario, restantes, restantes.size());

        return horario;
    }

    // funcion recursiva que devuelve una lista de horas compatibles
    public List<Hora> getHorario(List<Hora> horario, List<Asignatura> restantes, int numAsig)
    {

        if (restantes.size() > 0)
        {

            //la iteracion con mas horas sera la que recubra el arbol de horarios
            int numHoras = 0;
            List<Hora> mejorHorario = new ArrayList<>(horario);

            // continua buscando hasta que encuentre una solucion o se quede sin practicas
            for (int i = 0; i < restantes.get(0).getHorarioPractica().size(); i++)
            {
                Hora nuevaHora = restantes.get(0).getHorarioPractica().get(i);

                List<Hora> horarioAux = new ArrayList<>(horario);
                horarioAux.add(nuevaHora);

                if (coincideListaHoras(horarioAux) == false)
                {
                    List<Asignatura> restantesAux = new ArrayList<>(restantes);
                    restantesAux.remove(0);

                    horarioAux = getHorario(horarioAux, restantesAux, numAsig);
                }

                if (horarioAux.size() > numHoras)
                {
                    numHoras = horarioAux.size();
                    mejorHorario = horarioAux;
                }
            }

            horario = mejorHorario;
        }

        return horario;
    }
}
