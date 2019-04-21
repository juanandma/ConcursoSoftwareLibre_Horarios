/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class Horarios
{

    //Las busquedas son todas exhaustivas (malo)
    private boolean coincidenHoras(Hora h1, Hora h2)
    {

        boolean coincide = true;

        LocalTime inicio1 = h1.getHInicio();
        LocalTime fin1 = h1.getHFin();

        LocalTime inicio2 = h2.getHInicio();
        LocalTime fin2 = h2.getHFin();

        if (fin1.isBefore(inicio2) || fin2.isBefore(inicio1))
        {
            coincide = false;
        }

        //tambien compruebo el dia de la semana
        if (h1.getDia() != h2.getDia())
        {
            coincide = false;
        }

        // y el cuatrimestre
        if (h1.getAsignatura().getCuatrimestre() != h2.getAsignatura().getCuatrimestre())
        {
            coincide = false;
        }

        return coincide;
    }

    //devuelve true si alguna de las clases pasadas por parametro coincide
    private boolean coincideListaHoras(List<Hora> horario)
    {

        boolean coincide = false;

        int i = 0;

        while (i < horario.size() && coincide == false)
        {
            Hora horaActual = horario.get(i);
            
            for (int j = i; j < horario.size(); j++)
            {
                if (j != i)
                {
                    if (coincidenHoras(horaActual, horario.get(i)))
                    {
                        coincide = true;
                    }
                }
            }
            
            i++;
        }

        return coincide;
    }

    private boolean coincidenAsignaturasTeoria(Asignatura a1, Asignatura a2)
    {

        boolean coincide = false;
        int i, j;
        i = j = 0;
        int n1, n2;

        if (a1.getCuatrimestre() == a2.getCuatrimestre())
        {

            List<Hora> clases_1 = a1.getHorarioTeoria();
            List<Hora> clases_2 = a2.getHorarioTeoria();

            n1 = clases_1.size();
            n2 = clases_2.size();

            while (i < n1 && !coincide)
            {
                while (j < n2 && !coincide)
                {

                    int dia1 = clases_1.get(i).getDia();
                    int dia2 = clases_2.get(j).getDia();

                    if (dia1 == dia2)
                    {

                        coincide = coincidenHoras(clases_1.get(i), clases_2.get(j));
                    }

                    j++;
                }
                i++;
            }

            if (coincide)
            {
                System.out.println("Coinciden: " + a1.getNombre() + " y " + a2.getNombre());
            }
        }

        return coincide;
    }

    public boolean coincideHorarioTeoria(List<Asignatura> asignaturas)
    {

        boolean coincide = false;

        int i, j;
        i = j = 0;

        int n = asignaturas.size();

        while (i < n && !coincide)
        {
            while (j < n && !coincide)
            {

                if (i != j)
                {
                    coincide = coincidenAsignaturasTeoria(asignaturas.get(i), asignaturas.get(j));
                }

                j++;
            }
            i++;
        }

        return coincide;
    }

    //devuelve true si no existe ninguna combinacion en la que las practicas de una asignatura 
    //sean compatibles con las demas practicas de otras asignaturas.
    public boolean coincidenAsignaturasPracticas(List<Asignatura> asignaturas)
    {

        boolean coincide = false;

        int i, n1, n2;
        Hora horaProvisional;
        i = 0;

        List<Hora> GruposPracticas = new ArrayList<>();
        List<List<Hora>> horariosProvisionales = new ArrayList<>();

        n1 = asignaturas.size();

        while (i < n1 && !coincide)
        {

            n2 = asignaturas.get(i).getHorarioPractica().size();
            GruposPracticas = asignaturas.get(i).getHorarioPractica();

            for (int j = 0; j < n2; j++)
            {

                horaProvisional = GruposPracticas.get(j);

                if (i == 0)
                {

                    List<Hora> nuevaCombinacion = new ArrayList<>();
                    nuevaCombinacion.add(horaProvisional);

                    horariosProvisionales.add(nuevaCombinacion);

                } else
                {

                    for (int k = 0; k < horariosProvisionales.size(); k++)
                    {

                        List<Hora> nuevaCombinacion = new ArrayList<>();

                        //Extrae un horario de la anterior iteracion
                        List<Hora> horarioBorrado = horariosProvisionales.remove(k);

                        for (int l = 0; l < horarioBorrado.size(); l++)
                        {
                            nuevaCombinacion.add(horarioBorrado.get(l));
                        }
                        nuevaCombinacion.add(horaProvisional);

                        //Si horaProvisional es compatible con el horario que tenemos por ahora
                        if (!coincideListaHoras(nuevaCombinacion))
                        {

                            horariosProvisionales.add(nuevaCombinacion);
                        } else
                        {
                            nuevaCombinacion.clear();
                        }

                    }
                }

                j++;
            }

            //Si esta vacio significa que no existe ninguna combinacion en la no coincidan practicas con practicas
            if (horariosProvisionales.isEmpty())
            {

                coincide = true;
            } else
            {
                i++;
            }

        }

        return coincide;
    }

    public boolean coincidenAsignaturasPracticas2(List<Asignatura> asignaturas)
    {

        boolean coincide = false;
        List<Asignatura> restantes = new ArrayList<>(asignaturas);
        List<Hora> solActual = new ArrayList<>();

        coincide = coincidenAsignaturasPracticas2Recursiva( solActual, restantes);

        return coincide;
    }

    public boolean coincidenAsignaturasPracticas2Recursiva( List<Hora> solActual, List<Asignatura> restantes)
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
    public boolean coincidenPracticaTeoria(Asignatura actual, List<Asignatura> asignaturas)
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
    public boolean coincidenPracticaTeoria(Hora horaPractica, List<Asignatura> asignaturas)
    {
        boolean coincide = false;

        int i = 0;

        while (coincide == false && i < asignaturas.size())
        {
            List<Hora> horasTeoria = asignaturas.get(i).getHorarioTeoria();
            horasTeoria.add(horaPractica);

            if (coincideListaHoras(horasTeoria))
            {
                coincide = true;
            }

            i++;
        }

        return coincide;
    }

    public void VerAsignaturas(List<Asignatura> asignaturas)
    {

        if (asignaturas != null)
        {

            System.out.println("---- LISTA DE ASIGNATURAS ---");
            String dia;
            for (int i = 0; i < asignaturas.size(); i++)
            {
                System.out.println("Nombre: " + asignaturas.get(i).getNombre() + "\nID: " + asignaturas.get(i).getIdAsignatura());
                System.out.println("Curso: " + asignaturas.get(i).getCurso() + "\nCuatrimestre: " + asignaturas.get(i).getCuatrimestre());
                System.out.println("Horario de teoría:");
                for (int j = 0; j < asignaturas.get(i).getHorarioTeoria().size(); j++)
                {
                    if (asignaturas.get(i).getHorarioTeoria().get(j).getDia() == 1)
                    {
                        dia = "Lunes";
                    } else if (asignaturas.get(i).getHorarioTeoria().get(j).getDia() == 2)
                    {
                        dia = "Martes";
                    } else if (asignaturas.get(i).getHorarioTeoria().get(j).getDia() == 3)
                    {
                        dia = "Miércoles";
                    } else if (asignaturas.get(i).getHorarioTeoria().get(j).getDia() == 4)
                    {
                        dia = "Jueves";
                    } else
                    {
                        dia = "Viernes";
                    }
                    System.out.println(dia + " de " + asignaturas.get(i).getHorarioTeoria().get(j).getHoraInicio() + " a " + asignaturas.get(i).getHorarioTeoria().get(j).getHoraFin());
                }
                System.out.println("Horario de prácticas:");
                for (int j = 0; j < asignaturas.get(i).getHorarioPractica().size(); j++)
                {
                    if (asignaturas.get(i).getHorarioPractica().get(j).getDia() == 1)
                    {
                        dia = "Lunes";
                    } else if (asignaturas.get(i).getHorarioPractica().get(j).getDia() == 2)
                    {
                        dia = "Martes";
                    } else if (asignaturas.get(i).getHorarioPractica().get(j).getDia() == 3)
                    {
                        dia = "Miércoles";
                    } else if (asignaturas.get(i).getHorarioPractica().get(j).getDia() == 4)
                    {
                        dia = "Jueves";
                    } else
                    {
                        dia = "Viernes";
                    }
                    System.out.println(dia + " de " + asignaturas.get(i).getHorarioPractica().get(j).getHoraInicio() + " a " + asignaturas.get(i).getHorarioPractica().get(j).getHoraFin());
                }
                System.out.println("-------------------");

            }
        }

    }

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
                    List<Asignatura> restantesAux = restantes;
                    restantesAux.remove(horarioAux.size() - 1);

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
