/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.util.List;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import biodata.BiodataFrame;
import biodata.Biodata;

/**
 *
 * @author Gilman Arief
 */


  // Class SaveToFileActionListener yang Implementasi ActionListener untuk button Simpan
  public class SaveToFileActionListener implements ActionListener {
    // Variable biodataFrame untuk menyimpan nilai biodataFrame
    private final BiodataFrame biodataFrame;
    // Variable biodataList untuk menyimpan nilai biodataList
    private final List<Biodata> biodataList;

    // Method SimpanActionListener untuk menyimpan nilai biodataFrame dan biodataList
  public SaveToFileActionListener(BiodataFrame biodataFrame, List<Biodata> biodataList) {
    // Inisialisasi nilai dari biodataFrame
    this.biodataFrame = biodataFrame;
    // Inisialisasi nilai dari biodataList
    this.biodataList = biodataList;
  }

  // Override method actionPerformed dari ActionListener
  public void actionPerformed(ActionEvent e) {
    // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
    int confirmation = JOptionPane.showConfirmDialog(this.biodataFrame,
            "Apakah anda yakin ingin menyimpan data ke file?",
            "Form Biodata",
            JOptionPane.YES_NO_OPTION);
    
    
    // Jika confirmation memiliki nilai opsi yes
    if (confirmation == JOptionPane.YES_OPTION) {
        // Instansiasi JFileChooser dengan nama fileChooser
        JFileChooser fileChooser = new JFileChooser();
        // Atur title dari fileChooser
        fileChooser.setDialogTitle("Simpan Data ke File");
        // Atur filter dari fileChooser
        fileChooser.setFileFilter(new FileNameExtensionFilter("File Teks", "txt"));
        // Variable userSelection untuk menyimpan nilai dari fileChooser
        int userSelection = fileChooser.showSaveDialog(this.biodataFrame);


        // Jika userSelection memiliki nilai JFileChooser.APPROVE_OPTION
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                // Instansiasi FileWriter dengan nama writer
                FileWriter writer = new FileWriter("data.txt");

                // Tulis data ke file
                for (int i = 0; i < biodataList.size(); i++) {
                    // Dapatkan data dari kolom dt
                    if (i == biodataList.size() - 1) {
                        // Tulis data dari dt ke file, jika j == 3 maka tambahkan baris baru
                        System.out.print(
                                biodataList.get(i).getNama() + "," + biodataList.get(i).getNoTelepon() + " "
                                        + biodataList.get(i).getJenisKelamin() + ","
                                        + biodataList.get(i).getAlamat());
                        writer.write(biodataList.get(i).getNama() + ",");
                        writer.write(biodataList.get(i).getNoTelepon() + ",");
                        writer.write(biodataList.get(i).getJenisKelamin() + ",");
                        writer.write(biodataList.get(i).getAlamat());
                    } else {
                        // Tulis data dari dt ke file, jika j != 3 maka tambahkan koma
                        System.out.print(
                                biodataList.get(i).getNama() + "," + biodataList.get(i).getNoTelepon() + ","
                                        + biodataList.get(i).getJenisKelamin() + ","
                                        + biodataList.get(i).getAlamat() + "\n");
                        writer.write(biodataList.get(i).getNama() + ",");
                        writer.write(biodataList.get(i).getNoTelepon() + ",");
                        writer.write(biodataList.get(i).getJenisKelamin() + ",");
                        writer.write(biodataList.get(i).getAlamat() + "\n");
                    }
                }

                // Tutup file
                writer.close();

                // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                JOptionPane.showMessageDialog(this.biodataFrame, "Data berhasil disimpan ke file",
                        "Perhatian",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                // Jika ada Error, tampilkan error pada console
                ex.printStackTrace();
            }
        }
    }
  }
}
