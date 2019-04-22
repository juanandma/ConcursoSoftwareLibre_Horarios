/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Entidades.Hora;
import Entidades.Asignatura;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class Horarios
{


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



    

}
