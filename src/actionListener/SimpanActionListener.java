/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionlistener;

import java.awt.event.*;
import java.util.UUID;

import biodata.Biodata;
import biodata.BiodataFrame;
import dao.BiodataDao;

/**
 *
 * @author Gilman Arief
 */

// Class SimpanActionListener yang Implementasi ActionListener untuk button Simpan
public class SimpanActionListener implements ActionListener {
    // Variable biodataFrame untuk menyimpan nilai biodataFrame
    private final BiodataFrame biodataFrame;
    // Variable biodataDao untuk menyimpan nilai biodataDao 
    private final BiodataDao biodataDao;
    
    // Method SimpanActionListener untuk menyimpan nilai biodataFrame dan biodataDao
    public SimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        // Inisialisasi nilai dari biodataFrame
        this.biodataFrame = biodataFrame;
        // Inisialisasi nilai dari biodataDao
        this.biodataDao = biodataDao;
    }

    public void actionPerformed(ActionEvent e) {
        // Variable jenisKelamin yang berisi String kosong untuk menyimpan nilai dari objek jenisLaki atau jenisPerempuan
        String jenisKelamin = "";

        // Jika jenisLaki diklik
        if (biodataFrame.getJenisLaki().isSelected()) {
            // Maka jenisKelamin akan bernilai Laki-Laki
            jenisKelamin = biodataFrame.getJenisLaki().getText();
            // Kembalikan radio button ke kondisi semula
            biodataFrame.getJenisLaki().setSelected(false);
        }
        // Jika jenisPerempuan diklik
        if (biodataFrame.getJenisPerempuan().isSelected()) {
            // Maka jenisKelamin akan bernilai Perempuan
            jenisKelamin = biodataFrame.getJenisPerempuan().getText();
            // Kembalikan radio button ke kondisi semula
            biodataFrame.getJenisPerempuan().setSelected(false);
        }

        // Variable nama untuk menyimpan nilai dari objek textFieldNama
        String nama = biodataFrame.getNama();
        // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon
        String telepon = biodataFrame.getNoTelepon();
        // Variable alamat untuk menyimpan nilai dari objek txtOutput
        String alamat = biodataFrame.getAlamat();

        // Jika nama, telepon dan alamat bernilai kosong
        if (nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
            // Panggil method showAlertAllEmpty pada biodataFrame
            this.biodataFrame.showAlertAllEmpty();
            return;
        } else {
            // Jika nama bernilai kosong
            if (nama.equalsIgnoreCase("")) {
                // Panggil method showAlertNameEmpty pada biodataFrame
                this.biodataFrame.showAlertNameEmpty();
                return;
            }
            // Jika telepon bernilai kosong
            if (telepon.equalsIgnoreCase("")) {
                // Panggil method showAlertTelephoneEmpty pada biodataFrame
                this.biodataFrame.showAlertTelephoneEmpty();
                return;
            }
            // Jika alamat bernilai kosong
            if (alamat.equalsIgnoreCase("")) {
                // Panggil method showAlertAddressEmpty pada biodataFrame
                this.biodataFrame.showAlertAddressEmpty();
                return;
            }
        }

        // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
        int confirmation = this.biodataFrame.showConfirmation("tambah");

        // Jika confirmation bernilai opsi yes
        if (confirmation == 0) {
            // Instansiasi objek biodata dengan nama biodata
            Biodata biodata = new Biodata();

            // Set id biodata dengan nilai random
            biodata.setId(UUID.randomUUID().toString());
            // Set nama biodata dengan nilai dari variable nama
            biodata.setNama(nama);
            // Set telepon biodata dengan nilai dari variable telepon
            biodata.setNoTelepon(telepon);
            // Set jenisKelamin biodata dengan nilai dari variable jenisKelamin
            biodata.setJenisKelamin(jenisKelamin);
            // Set alamat biodata dengan nilai dari variable alamat
            biodata.setAlamat(alamat);

            // Tambahkan biodata ke objek biodataFrame
            this.biodataFrame.addBiodata(biodata);
            // Tambahkan biodata ke database
            this.biodataDao.insert(biodata);

            // Panggil method showAlertSuccess pada biodataFrame dengan parameter "ditambahkan"
            this.biodataFrame.showAlertSuccess("ditambahkan");
        }
        // Jika confirmation bernilai opsi no
        else {
            // Panggil method showAlertFailed pada biodataFrame dengan parameter "ditambahkan"
            this.biodataFrame.showAlertFailed("ditambahkan");
        }
        // Kembalikan isi textFieldNama ke kondisi kosong
        this.biodataFrame.getNamaTextField().setText("");
        // Kembalikan isi textFieldTelepon ke kondisi kosong
        this.biodataFrame.getNoTeleponTextField().setText("");
        // Kembalikan isi textare ke kondisi kosong
        this.biodataFrame.getAlamatTextField().setText("");
    }
}
