
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AgendaPribadi extends javax.swing.JFrame {

    /**
     * Creates new form AgendaPribadi
     */
    public AgendaPribadi() {
        initComponents();
        loadDataFromFile();
        
        setTitle("Aplikasi Agenda Pribadi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    private int selectedRow = -1;
    private void loadDataFromFile() {
    File file = new File("agenda.csv");
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            model.addRow(row);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private void loadCSV() {
    try (BufferedReader br = new BufferedReader(new FileReader("agenda.csv"))) {
        DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
        model.setRowCount(0); // Hapus semua data sebelum memuat ulang

        String line;
        while ((line = br.readLine()) != null) {
            // Pecah baris menjadi kolom, hapus tanda kutip jika ada
            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", ""); // Hapus tanda kutip
            }
            model.addRow(data);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat membaca file CSV!");
    }
}

 private void updateCSV() {
   try (FileWriter fw = new FileWriter("agenda.csv")) {
        DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String tanggal = model.getValueAt(i, 0).toString();
            String kegiatan = model.getValueAt(i, 1).toString();
            String jenis = model.getValueAt(i, 2).toString();

            // Pastikan hanya tambahkan tanda kutip jika diperlukan
            fw.append("\"").append(tanggal).append("\",")
              .append("\"").append(kegiatan).append("\",")
              .append("\"").append(jenis).append("\"\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui file CSV!");
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKegiatan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(82, 110, 72));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Aplikasi Agenda Pribadi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(344, 344, 344))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );

        jPanel2.setBackground(new java.awt.Color(181, 159, 120));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Jenis kegiatan:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acara keluarga", "Kerja", "Nongkrong", "Tugas" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Tanggal & Hari:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Kegiatan:");

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jButton7)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton7))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("STSong", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Input Kegiatan & Jadwal");

        jPanel4.setBackground(new java.awt.Color(162, 210, 223));

        tableKegiatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal & Hari", "Kegiatan", "Jenis Kegiatan"
            }
        ));
        tableKegiatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKegiatanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableKegiatan);

        jLabel7.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel7.setText("Cari jadwal");

        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Hapus");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addComponent(jButton8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton8)
                .addGap(36, 36, 36))
        );

        jLabel6.setFont(new java.awt.Font("STSong", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Data Jadwal kegiatan");

        jButton5.setText("Keluar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String kegiatan = jTextArea1.getText();
    String jenis = jComboBox1.getSelectedItem().toString();
    Date tanggalDate = jDateChooser1.getDate(); // Ambil tanggal sebagai Date

    if (kegiatan.isEmpty() || tanggalDate == null) {
        JOptionPane.showMessageDialog(this, "Pastikan semua input terisi!");
        return;
    }

    // Format tanggal tanpa koma
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy"); // Format baru tanpa koma
    String tanggal = sdf.format(tanggalDate);

    // Tambahkan data ke tabel
    DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
    model.addRow(new Object[]{tanggal, kegiatan, jenis});

    // Simpan ke file CSV
    updateCSV();

    // Reset input form
    jTextArea1.setText("");
    jDateChooser1.setDate(null);
    jComboBox1.setSelectedIndex(0);

    JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    String keyword = jTextField1.getText().toLowerCase();
    DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    tableKegiatan.setRowSorter(sorter);

    if (keyword.trim().length() == 0) {
        sorter.setRowFilter(null); // Tampilkan semua data
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword)); // Filter berdasarkan keyword
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    int row = tableKegiatan.getSelectedRow();
    if (row != -1) { // Pastikan ada baris yang dipilih
        DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
        model.removeRow(row); // Hapus data dari tabel

        // Perbarui file CSV
        updateCSV();

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
    } else {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     if (selectedRow != -1) { // Pastikan ada baris yang dipilih
        String kegiatan = jTextArea1.getText();
        String jenis = jComboBox1.getSelectedItem().toString();
        Date tanggalDate = jDateChooser1.getDate(); // Ambil tanggal sebagai Date

        if (kegiatan.isEmpty() || tanggalDate == null) {
            JOptionPane.showMessageDialog(this, "Pastikan semua input terisi!");
            return;
        }

        // Format tanggal tanpa koma
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        String tanggal = sdf.format(tanggalDate);

        // Perbarui data di tabel
        DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
        model.setValueAt(tanggal, selectedRow, 0);
        model.setValueAt(kegiatan, selectedRow, 1);
        model.setValueAt(jenis, selectedRow, 2);

        // Perbarui data di file CSV
        updateCSV();

        // Reset input dan pilihan baris
        jTextArea1.setText("");
        jDateChooser1.setDate(null);
        jComboBox1.setSelectedIndex(0);
        selectedRow = -1; // Reset pilihan baris

        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
    } else {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit terlebih dahulu!");
    }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableKegiatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKegiatanMouseClicked
    selectedRow = tableKegiatan.getSelectedRow();
    if (selectedRow != -1) {
        DefaultTableModel model = (DefaultTableModel) tableKegiatan.getModel();
        try {
            // Ambil tanggal tanpa tanda kutip
            String tanggal = model.getValueAt(selectedRow, 0).toString().replace("\"", "");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            Date tanggalDate = sdf.parse(tanggal);
            jDateChooser1.setDate(tanggalDate);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid!");
        }

        // Ambil kegiatan dan jenis tanpa tanda kutip
        jTextArea1.setText(model.getValueAt(selectedRow, 1).toString().replace("\"", ""));
        jComboBox1.setSelectedItem(model.getValueAt(selectedRow, 2).toString().replace("\"", ""));
    }
    }//GEN-LAST:event_tableKegiatanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaPribadi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableKegiatan;
    // End of variables declaration//GEN-END:variables

}
