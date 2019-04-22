/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.List;

/**
 *
 * @author JUANM
 */
public class HorariosTeoria extends HorariosAbstracta {

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

    public boolean coincideHorarioTeoria(List<Asignatura> asignaturas) {

        boolean coincide = false;

        int i, j;
        i = j = 0;

        int n = asignaturas.size();

        while (i < n && !coincide) {
            while (j < n && !coincide) {

                if (i != j) {
                    coincide = coincidenAsignaturasTeoria(asignaturas.get(i), asignaturas.get(j));
                }

                j++;
            }
            i++;
        }

        return coincide;
    }
}
