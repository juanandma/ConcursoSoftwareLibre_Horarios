/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Interfaz extends javax.swing.JFrame
{
    Main2 prueba;
    private List<Asignatura> asignaturas;
    private List<Asignatura> asignaturasSeleccionadas;
    
    
    /**
     * Creates new form NewJFrame
     */
    public Interfaz()
    {
        initComponents();
        
        prueba = new Main2();
        asignaturas = prueba.getAsignaturas();
        asignaturasSeleccionadas = new ArrayList<>();
        
        pintaListaAsignaturas();
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

        AsignaturaAseleccionar = new javax.swing.JTextField();
        meterAsignatura = new javax.swing.JButton();
        coincidenAsignaturas = new javax.swing.JTextField();
        comprobarAsignaturas = new javax.swing.JButton();
        generarHorario = new javax.swing.JButton();
        borrarSeleccionadas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAsignaturas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAsignaturasSeleccionadas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        meterAsignatura.setText("introducir asignatura");

        comprobarAsignaturas.setText("comprobar si coinciden");

        generarHorario.setText("generar horario");

        borrarSeleccionadas.setText("borrar seleccionadas");
        borrarSeleccionadas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                borrarSeleccionadasActionPerformed(evt);
            }
        });

        listaAsignaturas.setColumns(20);
        listaAsignaturas.setRows(5);
        jScrollPane1.setViewportView(listaAsignaturas);

        listaAsignaturasSeleccionadas.setColumns(20);
        listaAsignaturasSeleccionadas.setRows(5);
        jScrollPane2.setViewportView(listaAsignaturasSeleccionadas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(meterAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrarSeleccionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AsignaturaAseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(generarHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(comprobarAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(coincidenAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(borrarSeleccionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AsignaturaAseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(meterAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coincidenAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comprobarAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(generarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarSeleccionadasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_borrarSeleccionadasActionPerformed
    {//GEN-HEADEREND:event_borrarSeleccionadasActionPerformed
        
        // TODO add your handling code here:
        prueba.borrarSeleccionadas();
        asignaturasSeleccionadas = new ArrayList<>();
        
    }//GEN-LAST:event_borrarSeleccionadasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Interfaz().setVisible(true);
            }

        });
    }
    
    
    void pintaListaAsignaturas()
    {
        String nombresAsignaturas = "";
        for (int i = 0; i < asignaturas.size(); i++)
        {
            nombresAsignaturas = nombresAsignaturas + asignaturas.get(i).getNombre() + "\n";
        }
        
        listaAsignaturas.setText(nombresAsignaturas);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AsignaturaAseleccionar;
    private javax.swing.JButton borrarSeleccionadas;
    private javax.swing.JTextField coincidenAsignaturas;
    private javax.swing.JButton comprobarAsignaturas;
    private javax.swing.JButton generarHorario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea listaAsignaturas;
    private javax.swing.JTextArea listaAsignaturasSeleccionadas;
    private javax.swing.JButton meterAsignatura;
    // End of variables declaration//GEN-END:variables
}