package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    // Alamat database. javadb adalah nama schema yang kamu buat di MySQL Workbench tadi
    private static final String URL = "jdbc:mysql://localhost:3306/javadb";
    private static final String USER = "root"; 
    private static final String PASSWORD = "rahasiabanget#1"; // UBAH INI: sesuaikan dengan password MySQL Workbench-mu. Jika kosong, biarkan ""

    public static Connection getKoneksi() {
        Connection koneksi = null;
        try {
            // Mendaftarkan driver MySQL Connector
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Mencoba menghubungkan ke database
            koneksi = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke Database Berhasil!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return koneksi;
    }
    
    // Baris ini untuk ngetes aja apakah beneran bisa tersambung atau tidak
    public static void main(String[] args) {
        getKoneksi();
    }
}