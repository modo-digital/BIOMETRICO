package Formularios;

import BD.CargarComboBox;
import BD.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaUsuarios extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo = new DefaultTableModel();
   
    public ListaUsuarios() {
        initComponents();
        txtIdUsuario.setVisible(false);
        txtUsuarioAnterior.setVisible(false);
        try {        
            tbUsuario.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion c = new Conexion();
            java.sql.Connection con = c.getConexion();

            String sql = "" +
            "SELECT id,usuario,password from tb_usuarios order by usuario";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            //modelo.addColumn("Id");
            modelo.addColumn("Usuario");
            
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                //for (int i = 0; i < cantidadColumnas; i++) {
                //    filas[i] = rs.getObject(i + 1);
                //}
                filas[0] = rs.getString("usuario");
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNuevoUsuario = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtModificarUsuario = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        txtIdUsuario = new javax.swing.JTextField();
        txtUsuarioAnterior = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtModificarPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNuevoPass = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();

        setClosable(true);
        setTitle("Usuarios");

        jLabel1.setText("Usuario");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuario");

        txtModificarUsuario.setEnabled(false);

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setForeground(new java.awt.Color(204, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtIdUsuario.setText("idGrupo (oculto)");

        txtUsuarioAnterior.setText("grupo_anterior (oculto)");

        jLabel3.setText("Contrase??a");

        txtModificarPass.setEnabled(false);

        jLabel4.setText("Contrase??a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNuevoPass))
                            .addComponent(txtUsuarioAnterior, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdUsuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtModificarPass, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(30, 30, 30)
                                            .addComponent(txtNuevoUsuario))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(30, 30, 30)
                                            .addComponent(txtModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtNuevoPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModificarPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(39, 39, 39)
                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuarioAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbUsuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        PreparedStatement ps = null;
        String usuario = txtNuevoUsuario.getText();
        String pass = txtNuevoPass.getText();
        if(usuario.isEmpty()){
            return;
        }
        try {
            Conexion c = new Conexion();
            java.sql.Connection conn = c.getConexion();
            ps = conn.prepareStatement("INSERT INTO tb_usuarios (usuario,password,idRol) VALUES (?,?,2)");
            ps.setString(1, usuario);
            ps.setString(2, pass);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Usuario auxiliar agregado");
            txtNuevoUsuario.setText(null);
            
            limpiarDatos();
            
            c.close(conn);
            
            cargarDatos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No sepudo agregar el usuario, posiblemente ya exista un usuario con este nombre");
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        txtModificarUsuario.setEnabled(true);
        txtModificarPass.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion c = new Conexion();
            java.sql.Connection conn = c.getConexion();

            int Fila = tbUsuario.getSelectedRow();
            String codigo = tbUsuario.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT id, usuario, password FROM tb_usuarios WHERE usuario=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtModificarUsuario.setText(rs.getString("usuario"));
                txtModificarPass.setText(rs.getString("password"));
                txtIdUsuario.setText(rs.getString("id"));
                txtUsuarioAnterior.setText(rs.getString("usuario"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String usuario = txtModificarUsuario.getText();
        String pass = txtModificarPass.getText();
        String usuarioAnterior = txtUsuarioAnterior.getText();
        String id = txtIdUsuario.getText();
        
        int Fila = tbUsuario.getSelectedRow();

        PreparedStatement ps = null;
        
        try {
            Conexion c = new Conexion();
            java.sql.Connection conn = c.getConexion();
            ps = conn.prepareStatement("UPDATE tb_usuarios SET usuario=?,password=? WHERE id=?");

            ps.setString(1, usuario);
            ps.setString(2, pass);
            ps.setString(3, id);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Usuario modificado");
            c.close(conn);
            // volver a cargar los datos
            limpiarDatos();
            
            cargarDatos();
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());//"No sepudo modificar el usuario, posiblemente ya exista un usuario con este nombre");
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        PreparedStatement ps = null;
        try {
            Conexion c = new Conexion();
            java.sql.Connection conn = c.getConexion();

            int Fila = tbUsuario.getSelectedRow();
            //String codigo = tbGrupo.getValueAt(Fila, 0).toString();
            String idUsuario = txtIdUsuario.getText();

            ps = conn.prepareStatement("DELETE FROM tb_usuarios WHERE id=?");
            ps.setString(1, idUsuario);
            ps.execute();

            modelo.removeRow(Fila);
            
            txtNuevoUsuario.setText(null);
            txtNuevoPass.setText(null);
            txtModificarUsuario.setText(null);
            txtModificarPass.setText(null);
            txtModificarUsuario.setEnabled(false);
            txtModificarPass.setEnabled(false);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "Usuario eliminado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void limpiarDatos(){
            int filas=tbUsuario.getRowCount();
            for (int i = filas-1;i>=0; i--) {
                modelo.removeRow(i);
            }
            txtNuevoUsuario.setText(null);
            txtNuevoPass.setText(null);
            txtModificarUsuario.setText(null);
            txtModificarPass.setText(null);
            txtModificarUsuario.setEnabled(false);
            txtModificarPass.setEnabled(false);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
    }
    
    private void cargarDatos(){
        PreparedStatement ps = null;
        ps = null;
        ResultSet rs = null;
        try{
            Conexion c = new Conexion();
            java.sql.Connection conn = c.getConexion();

            String sql = "" +
            "SELECT id,usuario,password from tb_usuarios order by usuario";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                Object[] filass = new Object[cantidadColumnas];
                //for (int i = 0; i < cantidadColumnas; i++) {
                //    filass[i] = rs.getObject(i + 1);
                //}
                filass[0] = rs.getString("usuario");
                modelo.addRow(filass);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");
            System.out.println(ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtModificarPass;
    private javax.swing.JTextField txtModificarUsuario;
    private javax.swing.JTextField txtNuevoPass;
    private javax.swing.JTextField txtNuevoUsuario;
    private javax.swing.JTextField txtUsuarioAnterior;
    // End of variables declaration//GEN-END:variables
}
