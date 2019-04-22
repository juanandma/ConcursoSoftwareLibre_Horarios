/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author JUANM
 */
public class Main9 {

    private List<Asignatura> asignaturas;
    private List<Asignatura> asignaturasSeleccionadas;
    private ManejaAsignatura conexion;
    private Horarios horario;
    private HorariosTeoria horariosTeoria = new HorariosTeoria();
    private HorariosTeoriaPracticas horariosTeoriaPracticas = new HorariosTeoriaPracticas();
    private HorariosPracticas horariosPracticas = new HorariosPracticas();

    Main9() {
        // conexion con la base de datos
        conexion = new ManejaAsignatura();

        // inicializacion de variables
        asignaturas = conexion.getAsignaturas();
        asignaturasSeleccionadas = new ArrayList<>();
        horario = new Horarios();
    }

    public static void main(String[] args) {
        
        Main9 prueba = new Main9();
        prueba.menu();
        prueba.cerrarSesion();
        System.out.println("\n fin del programa");
        
        
    }

    void menu() {
        // variables del menu
        Scanner input = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\t0. Salir");
            System.out.println("\t1. Comprobar horario");
            System.out.println("\t2 Crear mi horario");
            System.out.println("\t3. Ver asignaturas totales");
            System.out.println("\t4. Ver asignaturas seleccionadas");
            System.out.println("\t5. seleccionar asignaturas\n\n");

            opcion = input.nextInt();

            switch (opcion) {

                // comprueba si un conjunto de asignaturas es compatible
                case 1: {
                    if (comprobarHorario() == true) {
                        System.out.println("las asignaturas son compatibles");
                    } else {
                        System.out.println("las asignaturas no son compatibles");
                    }

                    break;
                }

                // devuelve una lista de horas de teoria y practica compatibles
                case 2: {
                    mostrarHorario(horario.getHorario(asignaturasSeleccionadas));
                    break;
                }

                // muestra las asignaturas totales en la pantalla
                case 3: {
                    horario.VerAsignaturas(asignaturas);
                    System.out.println("\n\n");
                    break;
                }

                // muestra las asignaturas seleccionadas en la pantalla
                case 4: {
                    horario.VerAsignaturas(asignaturasSeleccionadas);
                    System.out.println("\n\n");
                    break;
                }

                // permite seleccionar asignaturas
                case 5: {
                    seleccionarAsignaturas();

                    break;
                }

            }

        } while (opcion != 0);

    }

    boolean comprobarHorario() {
        boolean coincide = false;

        /*
        System.out.println("teoria " + horariosTeoria.coincideHorarioTeoria(asignaturasSeleccionadas));
        System.out.println("practicas con teoria " + horariosTeoriaPracticas.coincidenPracticaTeoria(asignaturasSeleccionadas));
        System.out.println("practicas con practicas " + horariosPracticas.coincidenAsignaturasPracticas2(asignaturasSeleccionadas));

         */
        coincide = horariosTeoria.coincideHorarioTeoria(asignaturasSeleccionadas);

        if (coincide == false) {
            coincide = horariosTeoriaPracticas.coincidenPracticaTeoria(asignaturasSeleccionadas);
        }

        if (coincide == false) {
            coincide = horariosPracticas.coincidenAsignaturasPracticas2(asignaturasSeleccionadas);
        }

        return !coincide;
    }

    void seleccionarAsignaturas() {
        // borro las asignaturas seleccionadas anteriormente
        asignaturasSeleccionadas = new ArrayList<>();

        System.out.println("introduzca el numero de asignaturas a introducir");
        Scanner input = new Scanner(System.in);
        int numAsig = input.nextInt();

        if (numAsig > asignaturas.size() || numAsig < 0) {
            System.out.println("numero de asignaturas incorrecto \n\n");
        } else {
            for (int i = 0; i < numAsig; i++) {
                System.out.println("introduzca el nombre de la asignatura a seleccionar");
                String nombreAsig = input.next();

                int j = 0;
                boolean encontrado = false;

                while (j < asignaturas.size() && encontrado == false) {
                    if (nombreAsig.equals(asignaturas.get(j).getNombre())) {
                        encontrado = true;
                        asignaturasSeleccionadas.add(asignaturas.get(j));
                    }

                    j++;
                }
            }
        }
    }

    void mostrarHorario(List<Hora> horario) {
        System.out.println("---- HORARIO ----");

        for (int cuatrimestre = 1; cuatrimestre < 3; cuatrimestre++) {
            System.out.println("\n---- CUATRIMESTRE " + cuatrimestre + " ---");
            for (int i = 0; i < horario.size(); i++) {
                if (horario.get(i).getAsignatura().getCuatrimestre() == cuatrimestre) {
                    System.out.println("\n" + horario.get(i).getAsignatura().getNombre());

                    if (horario.get(i).getTipo() == 0) {
                        System.out.println("TEORIA");
                    } else {
                        System.out.println("PRACTICA");
                    }

                    switch (horario.get(i).getDia()) {
                        case 1:
                            System.out.println("lunes " + horario.get(i).getHInicio());
                            break;
                        case 2:
                            System.out.println("Martes " + horario.get(i).getHInicio());
                            break;
                        case 3:
                            System.out.println("Miércoles " + horario.get(i).getHInicio());
                            break;
                        case 4:
                            System.out.println("Jueves " + horario.get(i).getHInicio());
                            break;
                        default:
                            System.out.println("Viernes " + horario.get(i).getHInicio());
                            break;
                    }
                }
            }
        }

        System.out.println("-------------\n\n");
    }
    
    public void cerrarSesion(){
        conexion.cerrarSesion();
    }

}
