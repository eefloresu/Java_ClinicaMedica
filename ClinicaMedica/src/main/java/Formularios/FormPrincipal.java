package Formularios;
/**
 *
 * @author eefloresU
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null); //Centrar la ventana
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCitas = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnEspecialidades = new javax.swing.JButton();
        btnMedicos = new javax.swing.JButton();
        btnConsultorios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        mensaje = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Clinica Medica");
        setPreferredSize(new java.awt.Dimension(1300, 651));

        menus.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ARKAM");

        btnCitas.setBackground(new java.awt.Color(0, 153, 153));
        btnCitas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/citas.png"))); // NOI18N
        btnCitas.setText("Citas");
        btnCitas.setBorder(null);
        btnCitas.setBorderPainted(false);
        btnCitas.setMaximumSize(new java.awt.Dimension(45, 25));
        btnCitas.setMinimumSize(new java.awt.Dimension(45, 25));
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });

        btnPacientes.setBackground(new java.awt.Color(0, 153, 153));
        btnPacientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPacientes.setForeground(new java.awt.Color(255, 255, 255));
        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pacientes.png"))); // NOI18N
        btnPacientes.setText("Pacientes");
        btnPacientes.setBorder(null);
        btnPacientes.setBorderPainted(false);
        btnPacientes.setMaximumSize(new java.awt.Dimension(45, 25));
        btnPacientes.setMinimumSize(new java.awt.Dimension(45, 25));
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        btnEspecialidades.setBackground(new java.awt.Color(0, 153, 153));
        btnEspecialidades.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEspecialidades.setForeground(new java.awt.Color(255, 255, 255));
        btnEspecialidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/especialidades.png"))); // NOI18N
        btnEspecialidades.setText("Especialidades");
        btnEspecialidades.setBorder(null);
        btnEspecialidades.setBorderPainted(false);
        btnEspecialidades.setMaximumSize(new java.awt.Dimension(45, 25));
        btnEspecialidades.setMinimumSize(new java.awt.Dimension(45, 25));
        btnEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecialidadesActionPerformed(evt);
            }
        });

        btnMedicos.setBackground(new java.awt.Color(0, 153, 153));
        btnMedicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMedicos.setForeground(new java.awt.Color(255, 255, 255));
        btnMedicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/medical-29_icon-icons.com_73943.png"))); // NOI18N
        btnMedicos.setText("Medicos");
        btnMedicos.setBorder(null);
        btnMedicos.setBorderPainted(false);
        btnMedicos.setMaximumSize(new java.awt.Dimension(45, 25));
        btnMedicos.setMinimumSize(new java.awt.Dimension(45, 25));
        btnMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicosActionPerformed(evt);
            }
        });

        btnConsultorios.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultorios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConsultorios.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultorios.png"))); // NOI18N
        btnConsultorios.setText("Consultorios");
        btnConsultorios.setBorder(null);
        btnConsultorios.setBorderPainted(false);
        btnConsultorios.setMaximumSize(new java.awt.Dimension(45, 25));
        btnConsultorios.setMinimumSize(new java.awt.Dimension(45, 25));
        btnConsultorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultoriosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 153, 153));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setMaximumSize(new java.awt.Dimension(45, 25));
        btnSalir.setMinimumSize(new java.awt.Dimension(45, 25));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menusLayout = new javax.swing.GroupLayout(menus);
        menus.setLayout(menusLayout);
        menusLayout.setHorizontalGroup(
            menusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menusLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
            .addGroup(menusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPacientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEspecialidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMedicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menusLayout.setVerticalGroup(
            menusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(btnMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnConsultorios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        mensaje.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¡Bienvenidos a la familia de la Clínica ARKAM, donde tú salud es nuestra prioridad!");

        javax.swing.GroupLayout mensajeLayout = new javax.swing.GroupLayout(mensaje);
        mensaje.setLayout(mensajeLayout);
        mensajeLayout.setHorizontalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mensajeLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mensajeLayout.setVerticalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mensajeLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        FormCitas ventana = new FormCitas();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        FormPacientes ventana = new FormPacientes();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspecialidadesActionPerformed
        FormEspecialidades ventana = new FormEspecialidades();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEspecialidadesActionPerformed

    private void btnMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicosActionPerformed
        FormMedicos ventana = new FormMedicos();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnMedicosActionPerformed

    private void btnConsultoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultoriosActionPerformed
        FormConsultorio ventana = new FormConsultorio();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnConsultoriosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnConsultorios;
    private javax.swing.JButton btnEspecialidades;
    private javax.swing.JButton btnMedicos;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mensaje;
    private javax.swing.JPanel menus;
    // End of variables declaration//GEN-END:variables
}
