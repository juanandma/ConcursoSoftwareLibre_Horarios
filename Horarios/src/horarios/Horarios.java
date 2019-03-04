/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author JUANM
 */
public class Horarios {

    
    //Las busquedas son todas exhaustivas (malo)
    private boolean coincidenHoras(Hora h1, Hora h2) {

        boolean coincide = false;

        LocalTime inicio1 = h1.getHInicio();
        LocalTime fin1 = h1.getHFin();

        LocalTime inicio2 = h2.getHInicio();
        LocalTime fin2 = h2.getHFin();

        if (inicio1.isBefore(fin2) && fin1.isAfter(inicio2) && !inicio1.equals(fin2)) {

            coincide = true;

        }

        return coincide;
    }
    
    
    private boolean coincideListaHoras(List<Hora> horario) {

        boolean coincide = false;

        int i, j;
        i = j = 0;

        int n = horario.size();
        while (i < n && !coincide) {

            while (j < n && !coincide) {

                if (i > j) {
                    coincide = coincidenHoras(horario.get(i), horario.get(j));
                }
            }
        }
        return coincide;

    }
    
    
    private boolean coincidenAsignaturasTeoria(Asignatura a1, Asignatura a2) {

        boolean coincide = false;
        int i, j;
        i = j = 0;
        int n1, n2;

        if (a1.getCuatrimestre() == a2.getCuatrimestre()) {

            List<Hora> clases_1 = a1.getHorarioTeoria();
            List<Hora> clases_2 = a2.getHorarioTeoria();

            n1 = clases_1.size();
            n2 = clases_2.size();

            while (i < n1 && !coincide) {
                while (j < n2 && !coincide) {

                    int dia1 = clases_1.get(i).getDia();
                    int dia2 = clases_2.get(j).getDia();

                    if (dia1 == dia2) {

                        coincide = coincidenHoras(clases_1.get(i), clases_2.get(j));
                    }

                    j++;
                }
                i++;
            }

            if (coincide) {
                System.out.println("Coinciden: " + a1.getNombre() + " y " + a2.getNombre());
            }
        }

        return coincide;
    }
}
