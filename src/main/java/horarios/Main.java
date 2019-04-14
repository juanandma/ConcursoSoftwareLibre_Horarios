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
public class Main {
    
    public static void main(String[] args) {

        List<Asignatura> asignaturas = new ArrayList<>();
        Horarios horario = new Horarios();
        Scanner input = new Scanner(System.in);

        List<Asignatura> mis_clases = new ArrayList<>();

        int id, salir;

        horario.VerAsignaturas(asignaturas);
        do {
            

            System.out.println("\t4. Comprobar horario");
            System.out.println("\t Crear mi horario");
            System.out.println("\t0. Salir");
            
            salir = input.nextInt();
            
            switch (salir) {
                
                case 4: {
                    do {
                        System.out.println("        *** " + '"' + "0" + '"' + " para terminar");
                        System.out.println("Introduce el ID de la asignatura que quiere en su Horario: ");
                        id = input.nextInt();
                        
                        if (id > 0 && id < asignaturas.size() + 1) {
                            mis_clases.add(asignaturas.get(id - 1));
                        }
                        
                    } while (id != 0);
                    
                    horario.VerAsignaturas(mis_clases);
                    if (horario.coincideHorarioTeoria(mis_clases)) {
                        System.out.println("Coincide su horario de teoría");
                        
                    } else {
                        
                        /*if (horario.coincideHorarioPracticas(mis_clases)) {
                        System.out.println("Coincide su horario de práticas");
                        
                        } else {*/
                        System.out.println("No coincide ninguna asignatura");
                        
                        //}
                    }
                }
                break;
                
            }
            
        } while (salir != 0);
        
    }
}
