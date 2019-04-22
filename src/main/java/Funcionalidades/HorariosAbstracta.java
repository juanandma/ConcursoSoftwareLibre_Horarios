/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Entidades.Hora;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author JUANM
 */
public abstract class  HorariosAbstracta {
    
    //Las busquedas son todas exhaustivas (malo)
    public boolean coincidenHoras(Hora h1, Hora h2)
    {

        boolean coincide = true;

        LocalTime inicio1 = h1.getHInicio();
        LocalTime fin1 = h1.getHFin();

        LocalTime inicio2 = h2.getHInicio();
        LocalTime fin2 = h2.getHFin();

        if (fin1.isBefore(inicio2) || fin1.equals(inicio2) )
        {
            coincide = false;
        }
        
        
        if ( fin2.equals(inicio1) || fin2.isBefore(inicio1))
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
    public boolean coincideListaHoras(List<Hora> horario)
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
                    if (coincidenHoras(horaActual, horario.get(j)))
                    {
                        coincide = true;
                    }
                }
            }
            
            i++;
        }

        return coincide;
    }
    
    
}
