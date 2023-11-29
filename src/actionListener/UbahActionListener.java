/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;

import biodata.BiodataFrame;
import dao.BiodataDao;

/**
 *
 * @author Gilman Arief
 */

// Class UbahActionListener yang Implementasi ActionListener untuk button Ubah
public class UbahActionListener implements ActionListener {
    // Variable biodataFrame untuk menyimpan nilai biodataFrame
    private final BiodataFrame biodataFrame;
    // Variable biodataDao untuk menyimpan nilai biodataDao
    private final BiodataDao biodataDao;

    // Method UbahActionListener untuk menyimpan nilai biodataFrame dan biodataDao
    public UbahActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        // Inisialisasi nilai dari biodataFrame
        this.biodataFrame = biodataFrame;
        // Inisialisasi nilai dari biodataDao
        this.biodataDao = biodataDao;
    }

    // Override method actionPerformed dari ActionListener
    public void actionPerformed(ActionEvent e) {
        // Variable row untuk menyimpan nilai baris yang dipilih
        int row = this.biodataFrame.getTable().getSelectedRow();

        // Variable column untuk menyimpan nilai kolom yang dipilih
        int column = this.biodataFrame.getTable().getSelectedColumn();

        // Variable biodataUbah untuk menyimpan nilai dari table yang diedit
        String biodataUbah = (String) this.biodataFrame.getTable().getModel().getValueAt(row, column);

        // Variable id untuk menyimpan nilai id dari biodata yang akan diubah
        String id = "";

        // Variable col untuk menyimpan nama kolom yang dipilih
        String col = "";

        // Switch case untuk menentukan nama kolom yang dipilih
        switch (column) {
            // Case Jika kolom bernilai 0
            case 0:
                // Set col dengan nama
                col = "nama";
                break;
            // Case Jika kolom bernilai 1
            case 1:
                // Set col dengan no_telepon
                col = "no_telepon";
                break;
            // Case Jika kolom bernilai 2
            case 2:
                // Set col dengan jenis_kelamin
                col = "jenis_kelamin";
                break;
            // Case Jika kolom bernilai 3
            case 3:
                // Set col dengan alamat
                col = "alamat";
                break;
            // Case Jika kolom bernilai selain 0, 1, 2, dan 3
            default:
                // Tampilkan pesan kolom tidak ditemukan
                System.out.println("Kolom tidak ditemukan");
                break;
        }

        // Dapatkan id dari biodata yang akan diubah
        id = this.biodataDao.select(col, biodataUbah).getId();
        
        // Set nilai dari textFieldNama dengan biodata yang akan diubah
        this.biodataFrame.getNamaTextField().setText(this.biodataDao.select(col, biodataUbah).getNama());
        // Set nilai dari textFieldTelepon dengan biodata yang akan diubah
        this.biodataFrame.getNoTeleponTextField().setText(this.biodataDao.select(col, biodataUbah).getNoTelepon());

        // Jika jenis kelamin dari biodata yang akan diubah adalah Laki-Laki
        if (this.biodataDao.select(col, biodataUbah).getJenisKelamin().equals("Laki-Laki")) {
            // Set nilai dari jenisLaki menjadi true
            this.biodataFrame.getJenisLaki().setSelected(true);
        } else {
            // Set nilai dari jenisPerempuan menjadi true
            this.biodataFrame.getJenisPerempuan().setSelected(true);
        }

        // Set nilai dari textFieldAlamat dengan biodata yang akan diubah
        this.biodataFrame.getAlamatTextField().setText(this.biodataDao.select(col, biodataUbah).getAlamat());

        // Buat objek simpanUbahListener untuk menyimpan nilai biodataFrame, biodataDao, dan id
        SimpanUbahActionListener simpanUbahListener = new SimpanUbahActionListener(this.biodataFrame, this.biodataDao, id);

        // Tambahkan action listener untuk button simpanUbah
        this.biodataFrame.getButtonSimpanUbah().addActionListener(simpanUbahListener);
    }
}
