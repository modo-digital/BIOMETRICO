package Formularios;

import BD.CargarComboBox;
import BD.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerRegistros extends javax.swing.JInternalFrame {

    public int idRol = 0;
    DefaultTableModel modelo = new DefaultTableModel();
    
    public VerRegistros() {
        initComponents();
        lbIdRegistro.setVisible(false);
        // cargas comboBox
        CargarComboBox metodos_cargarcombobox = new CargarComboBox();
        metodos_cargarcombobox.consultar_status(cbStatus); //.consultar_paises(cbox_Paises);
            
        modelo.addColumn("control");
        modelo.addColumn("Fecha");
        modelo.addColumn("Empleado");
        modelo.addColumn("Hora de entrada");
        modelo.addColumn("Hora de salida");
        modelo.addColumn("Estatus");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegistros = new javax.swing.JTable();
        dcFechaCosulta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        lbEmpelado = new javax.swing.JLabel();
        lbIdRegistro = new javax.swing.JLabel();
        btnActualizarStatus = new javax.swing.JButton();

        setClosable(true);
        setTitle("Ver registros");

        tbRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRegistros);

        dcFechaCosulta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaCosultaPropertyChange(evt);
            }
        });

        jLabel1.setText("Seleccione fecha de consulta:");

        lbEmpelado.setText("Empleado");

        lbIdRegistro.setText("idRegistro");

        btnActualizarStatus.setText("Actualizar");
        btnActualizarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dcFechaCosulta, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lbIdRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbEmpelado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizarStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIdRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFechaCosulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbEmpelado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizarStatus)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dcFechaCosultaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaCosultaPropertyChange
        cargarDatos();
    }//GEN-LAST:event_dcFechaCosultaPropertyChange

    private void tbRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRegistrosMouseClicked
        if(this.idRol == 2){
            return;
        }
        try {
            cbStatus.setVisible(true);
            lbEmpelado.setVisible(true);
            btnActualizarStatus.setVisible(true);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            java.sql.Connection con = c.getConexion();
            

            int Fila = tbRegistros.getSelectedRow();
            String codigo = tbRegistros.getValueAt(Fila, 0).toString();
            lbEmpelado.setText(tbRegistros.getValueAt(Fila, 2).toString());
            lbIdRegistro.setText(codigo);
            String sql = "" +
            "SELECT " +
            "   e.id, e.status "+
            "FROM tb_estatus e "+
            "Inner join tb_reportes r "+
            " ON r.idEstatus = e.id "+
            "Where r.id = ?" ;
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt( codigo ) );
            
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("status"));
                cbStatus.setSelectedItem(rs.getString("status"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_tbRegistrosMouseClicked

    private void btnActualizarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarStatusActionPerformed
        int Fila = tbRegistros.getSelectedRow();
        String idRegistro = lbIdRegistro.getText();
        PreparedStatement ps = null;
        try {
            Conexion c = new Conexion();
            java.sql.Connection con = c.getConexion();
            
            String query = ""+
            "UPDATE tb_reportes "+
            "SET "+
            "idEstatus=(select id from tb_estatus where status = ? )"+
            "WHERE id = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, cbStatus.getSelectedItem().toString());
            ps.setString(2, idRegistro);
            
            System.out.println(ps);

            ps.execute();
            
            limpiar();
            cargarDatos();
            
            JOptionPane.showMessageDialog(null, "Status modificado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el status del empleado");
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnActualizarStatusActionPerformed

    private void limpiar(){
        int xfilasx=tbRegistros.getRowCount();
        for (int i = xfilasx-1;i>=0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void cargarDatos(){
        try{
            tbRegistros.setModel(modelo);
            
            limpiar();
            
            int a??o = dcFechaCosulta.getCalendar().get(Calendar.YEAR);
            int mes = dcFechaCosulta.getCalendar().get(Calendar.MONTH)+1;
            int dia = dcFechaCosulta.getCalendar().get(Calendar.DAY_OF_MONTH);
            
            String fechaCosulta = (a??o+"-"+mes+"-"+dia);
                        
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            java.sql.Connection con = c.getConexion();

            String sql = "" +
            "SELECT " +
            "r.id " +
            ",r.fecha " +
            ",concat(e.nombres,' ',e.apellidos) as empleado " +
            ",r.horaEntrada " +
            ",r.horaSalida " +
            ",s.status " +
            "FROM tb_reportes r " +
            "inner join tb_empleados e " +
            "	on e.id = r.idEmpleado " +
            "inner join tb_estatus s " +
            "	on s.id = r.idEstatus " +
            "WHERE r.fecha = ?";
                
            ps = con.prepareStatement(sql);
            ps.setString(1, fechaCosulta);
            
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            
            int numFilas = 0;
            while (rs.next()) {
                numFilas++;
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            if(numFilas == 0){
                JOptionPane.showMessageDialog(null, "No hay registros del d??a seleccionado.");
            }
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        cbStatus.setVisible(false);
        lbEmpelado.setVisible(false);
        btnActualizarStatus.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarStatus;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser dcFechaCosulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmpelado;
    private javax.swing.JLabel lbIdRegistro;
    private javax.swing.JTable tbRegistros;
    // End of variables declaration//GEN-END:variables
}
