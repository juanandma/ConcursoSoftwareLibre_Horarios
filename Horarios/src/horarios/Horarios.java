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

    //devuelve true si no existe ninguna combinacion en la que las practicas de una asignatura 
    //sean compatibles con las demas practicas de otras asignaturas.
    private boolean coincidenAsignaturasPracticas(List<Asignatura> asignaturas) {

        boolean coincide = false;

        int i, n1, n2;
        Hora horaProvisional;
        i = 0;

        List<Hora> GruposPracticas = new ArrayList<>();
        List<List<Hora>> horariosProvisionales = new ArrayList<>();

        n1 = asignaturas.size();

        while (i < n1 && !coincide) {

            n2 = asignaturas.get(i).getHorarioPractica().size();
            GruposPracticas = asignaturas.get(i).getHorarioPractica();

            for (int j = 0; j < n2; j++) {

                horaProvisional = GruposPracticas.get(j);

                if (i == 0) {

                    List<Hora> nuevaCombinacion = new ArrayList<>();
                    nuevaCombinacion.add(horaProvisional);

                    horariosProvisionales.add(nuevaCombinacion);

                } else {

                    for (int k = 0; k < horariosProvisionales.size(); k++) {

                        List<Hora> nuevaCombinacion = new ArrayList<>();

                        //Extrae un horario de la anterior iteracion
                        List<Hora> horarioBorrado = horariosProvisionales.remove(k);

                        for (int l = 0; l < horarioBorrado.size(); l++) {
                            nuevaCombinacion.add(horarioBorrado.get(l));
                        }
                        nuevaCombinacion.add(horaProvisional);

                        //Si horaProvisional es compatible con el horario que tenemos por ahora
                        if (!coincideListaHoras(nuevaCombinacion)) {

                            horariosProvisionales.add(nuevaCombinacion);
                        } else {
                            nuevaCombinacion.clear();
                        }

                    }
                }

                j++;
            }

            //Si esta vacio significa que no existe ninguna combinacion en la no coincidan practicas con practicas
            if (horariosProvisionales.isEmpty()) {

                coincide = true;
            } else {
                i++;
            }

        }

        return coincide;
    }

    // devuelve true si no existe alguna conbinacion grupos de practicas de todas las 
    //asignaturas que no tenga ninguna coincidencia entre teorias
    private boolean coincidenPracticaTeoria(List<Asignatura> asignaturas) {
        boolean coincide = true;

        int i = 0;

        while (coincide == true && i < asignaturas.size()) {
            Asignatura actual = asignaturas.get(i);
            coincide = coincidenPracticaTeoria(actual, asignaturas);
            i++;
        }

        return coincide;
    }

    // devuelve true si no existe alguna conbinacion grupos de practicas que
    // no tenga ninguna coincidencia entre teoria de las demas asignaturas
    private boolean coincidenPracticaTeoria(Asignatura actual, List<Asignatura> asignaturas) {
        boolean coincide = true;

        int i = 0;

        while (coincide == true && i < actual.getHorarioPractica().size()) {

            int j = 0;

            boolean provisional = false;

            //compruebo que para el grupo i de practicas de la asignatura no coincida
            while (provisional == false && j < asignaturas.size()) {
                Hora practica = actual.getHorarioPractica().get(i);

                int k = 0;
                while (provisional == false && k < asignaturas.size()) {
                    Hora teoria = asignaturas.get(j).getHorarioTeoria().get(k);
                    provisional = coincidenHoras(practica, teoria);
                }

                j++;
            }

            i++;
        }
        return coincide;
    }

}
