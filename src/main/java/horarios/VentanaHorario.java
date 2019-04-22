/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.List;

/**
 *
 * @author Juan
 */
public class VentanaHorario extends javax.swing.JFrame
{

    /**
     * Creates new form VentanaHorarios
     */
    List<Hora> horario;
    /**
     * Creates new form VentanaHorario
     */
    public VentanaHorario(List<Hora> horario)
    {
        initComponents();
        this.horario=horario;
        mostrarHorario(horario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        AreaHorarios = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AreaHorarios.setColumns(20);
        AreaHorarios.setRows(5);
        jScrollPane1.setViewportView(AreaHorarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {

    }
    
    public void mostrarHorario(List<Hora> horario) {
        //System.out.println("---- HORARIO ----");
        StringBuffer salida=new StringBuffer();
        String nuevo ="";

        nuevo ="---- HORARIO ----"+ "\n";
        nuevaCadena(salida, nuevo);


        for (int cuatrimestre = 1; cuatrimestre < 3; cuatrimestre++) {
            //System.out.println("\n---- CUATRIMESTRE " + cuatrimestre + " ---");

            nuevo ="\n---- CUATRIMESTRE " + cuatrimestre + " ---"+ "\n";
            nuevaCadena(salida, nuevo);
            for (int i = 0; i < horario.size(); i++) {
                if (horario.get(i).getAsignatura().getCuatrimestre() == cuatrimestre) {
                    //System.out.println();
                    nuevo="\n" + horario.get(i).getAsignatura().getNombre()+ "\n";
                    nuevaCadena(salida, nuevo);
if (horario.get(i).getTipo() == 0) {
                        //System.out.println("TEORIA");
                        nuevo="TEORIA"+ "\n";

                    } else {
                        //System.out.println("PRACTICA");
                        nuevo="PRACTICA"+ "\n";
                    }
                    nuevaCadena(salida, nuevo);

                    switch (horario.get(i).getDia()) {
                        case 1:
                            //System.out.println("lunes " + horario.get(i).getHInicio());
                            nuevo="lunes " + horario.get(i).getHInicio()+ "\n";
                            break;
                        case 2:
                            //System.out.println("Martes " + horario.get(i).getHInicio());
                            nuevo="Martes" + horario.get(i).getHInicio()+ "\n";
                            break;
                        case 3:
                            //System.out.println("Miércoles " + horario.get(i).getHInicio());
                            nuevo="Miércoles " + horario.get(i).getHInicio()+ "\n";
                            break;
                        case 4:
                            //System.out.println("Jueves " + horario.get(i).getHInicio());
                            nuevo="Jueves " + horario.get(i).getHInicio()+ "\n";
                            break;
                        default:
                            //System.out.println("Viernes " + horario.get(i).getHInicio());
                            nuevo="Viernes " + horario.get(i).getHInicio()+ "\n";
                            break;
                    }
                    nuevaCadena(salida, nuevo);
                }
            }
        }
        AreaHorarios.setText(salida.toString());

    }
public StringBuffer nuevaCadena(StringBuffer cadena, String nuevo){
        cadena.append(nuevo);
        return cadena;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaHorarios;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
