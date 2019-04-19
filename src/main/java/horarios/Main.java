/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUANM
 */
public class Main
{

    private List<Asignatura> asignaturas;
    private List<Asignatura> asignaturasSeleccionadas;
    private Horarios horario;
    private ManejaAsignatura conexion;

    Main()
    {
        // conexion con la base de datos
        conexion = new ManejaAsignatura();
        conexion.iniciaOperacion();

        // inicializacion de variables
        asignaturas = conexion.getAsignaturas();
        asignaturasSeleccionadas = new ArrayList<>();
        horario = new Horarios();
    }

    public static void main(String[] args)
    {
        Main prueba = new Main();
        prueba.menu();
    }

    void menu()
    {
        // variables del menu
        Scanner input = new Scanner(System.in);
        int opcion;

        do
        {
            System.out.println("\t0. Salir");
            System.out.println("\t1. Comprobar horario");
            System.out.println("\t2 Crear mi horario");
            System.out.println("\t3. Ver asignaturas totales");
            System.out.println("\t4. Ver asignaturas seleccionadas");
            System.out.println("\t5. seleccionar asignaturas");

            opcion = input.nextInt();

            switch (opcion)
            {

                // comprueba si un conjunto de asignaturas es compatible
                case 1:
                {
                    if (comprobarHorario() == true)
                    {
                        System.out.println("las asignaturas son compatibles");
                    } else
                    {
                        System.out.println("las asignaturas son no son compatibles");
                    }

                    break;
                }

                // devuelve una lista de horas de teoria y practica compatibles
                case 2:
                {
                    mostrarHorario(horario.getHorario(asignaturasSeleccionadas));
                    break;
                }

                // muestra las asignaturas totales en la pantalla
                case 3:
                {
                    horario.VerAsignaturas(asignaturas);
                    System.out.println("\n\n");
                    break;
                }

                // muestra las asignaturas seleccionadas en la pantalla
                case 4:
                {
                    horario.VerAsignaturas(asignaturasSeleccionadas);
                    System.out.println("\n\n");
                    break;
                }

                // permite seleccionar asignaturas
                case 5:
                {
                    seleccionarAsignaturas();

                    break;
                }

            }

        } while (opcion != 0);

        salir();
    }

    boolean comprobarHorario()
    {
        boolean valido = true;

        valido = horario.coincideHorarioTeoria(asignaturasSeleccionadas);

        if (valido == true)
        {
            valido = horario.coincidenAsignaturasPracticas2(asignaturasSeleccionadas);
        }

        if (valido == true)
        {
            valido = horario.coincidenPracticaTeoria(asignaturasSeleccionadas);
        }

        return valido;
    }

    void seleccionarAsignaturas()
    {
        // borro las asignaturas seleccionadas anteriormente
        asignaturasSeleccionadas = new ArrayList<>();

        System.out.println("introduzca el numero de asignaturas a introducir");
        Scanner input = new Scanner(System.in);
        int numAsig = input.nextInt();

        if (numAsig > asignaturas.size() || numAsig < 0)
        {
            System.out.println("numero de asignaturas incorrecto \n\n");
        } else
        {
            for (int i = 0; i < numAsig; i++)
            {
                System.out.println("introduzca el nombre de la asignatura a seleccionar");
                String nombreAsig = input.nextLine();

                int j = 0;
                boolean encontrado = false;

                while (j < asignaturas.size() && encontrado == false)
                {
                    if (asignaturas.get(j).getNombre() == nombreAsig)
                    {
                        encontrado = true;
                        asignaturasSeleccionadas.add(asignaturas.get(j));
                    }
                    j++;
                }
            }
        }
    }

    void mostrarHorario(List<Hora> horario)
    {
        System.out.println("---- HORARIO ---\n\n");

        for (int cuatrimestre = 1; cuatrimestre < 3; cuatrimestre++)
        {
            System.out.println("---- CUATRIMESTRE " + cuatrimestre + " ---\n");
            for (int i = 0; i < horario.size(); i++)
            {
                if (horario.get(i).getTipo() == cuatrimestre)
                {
                    System.out.println(horario.get(i).getAsignatura().getNombre());

                    switch (horario.get(i).getDia())
                    {
                        case 1:
                            System.out.println("lunes" + horario.get(i).getHInicio());
                            break;
                        case 2:
                            System.out.println("Martes" + horario.get(i).getHInicio());
                            break;
                        case 3:
                            System.out.println("Miércoles" + horario.get(i).getHInicio());
                            break;
                        case 4:
                            System.out.println("Jueves" + horario.get(i).getHInicio());
                            break;
                        default:
                            System.out.println("Viernes" + horario.get(i).getHInicio());
                            break;
                    }
                }
            }
        }
    }

    void salir()
    {
        conexion.finalizaOperacion();
    }

}
