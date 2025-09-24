package com.praktikum.testing.util;

import com.praktikum.testing.model.Buku;
import com.praktikum.testing.model.Anggota;

public class ValidationUtilsTest {

    // Validasi Email
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    // Validasi Nomor Telepon (Indonesia + support kode area)
    public static boolean isValidNomorTelepon(String telepon) {
        if (telepon == null) return false;
        // Bisa mulai dari 08..., 03..., tapi tidak boleh 07.. atau angka lain
        return telepon.matches("^(0[2-9][0-9]{7,11})$");
    }

    // Validasi ISBN (10/13 digit dengan optional '-')
    public static boolean isValidISBN(String isbn) {
        if (isbn == null) return false;
        return isbn.matches("^(\\d{10}|\\d{13}|\\d{3}-\\d{3}-\\d{3}-\\d)$");
    }

    // Validasi String
    public static boolean isValidString(String s) {
        return s != null && !s.trim().isEmpty();
    }

    // Validasi Angka
    public static boolean isAngkaPositif(double angka) {
        return angka > 0;
    }

    public static boolean isAngkaNonNegatif(double angka) {
        return angka >= 0;
    }

    // Validasi Buku
    public static boolean isValidBuku(Buku buku) {
        if (buku == null) return false;
        if (!isValidISBN(buku.getIsbn())) return false;
        if (!isValidString(buku.getJudul())) return false;
        if (!isValidString(buku.getPengarang())) return false;
        if (!isAngkaNonNegatif(buku.getJumlahTotal())) return false;
        if (!isAngkaNonNegatif(buku.getHarga())) return false;
        return true;
    }

    public static boolean isValidAnggota(Anggota anggota) {
        if (anggota == null) return false;

        return isValidString(anggota.getIdAnggota()) &&   // sebelumnya getId()
                isValidString(anggota.getNama()) &&
                isValidEmail(anggota.getEmail()) &&
                isValidNomorTelepon(anggota.getTelepon()) && // sebelumnya getNomorTelepon()
                anggota.getTipeAnggota() != null;            // sebelumnya getTipe()
    }

}
