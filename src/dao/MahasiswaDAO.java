package dao;

import model.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.KoneksiDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class MahasiswaDAO {
    
    // 1. CREATE 
    public int create(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nim, nama_mahasiswa, jurusan) VALUES (?, ?, ?)"; 
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNamaMahasiswa());
            ps.setString(3, mhs.getJurusan()); 
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating mahasiswa: " + e.getMessage());
            return 0;
        }
    }

    // 2. READ 
    public List<Mahasiswa> getMahasiswa(String keyword, int page, int limit) {
        List<Mahasiswa> list = new ArrayList<>();
        int offset = (page - 1) * limit;
        String sql = "SELECT * FROM mahasiswa WHERE nim LIKE ? OR nama_mahasiswa LIKE ? LIMIT ? OFFSET ?";
        
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ps.setInt(3, limit);
            ps.setInt(4, offset);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new model.Mahasiswa(
                        rs.getInt("idmahasiswa"),
                        rs.getString("nim"),
                        rs.getString("nama_mahasiswa"), 
                        rs.getString("jurusan")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting mahasiswa: " + e.getMessage());
        }
        return list;
    }

    // 3. UPDATE 
    public int update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nim = ?, nama_mahasiswa = ?, jurusan = ? WHERE idmahasiswa = ?";        
        
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
           
            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNamaMahasiswa());
            ps.setString(3, mhs.getJurusan());
            ps.setInt(4, mhs.getId());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating mahasiswa: " + e.getMessage());
            return 0;
        }
    }

    // 4. DELETE
    public int delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE idmahasiswa = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting mahasiswa: " + e.getMessage());
            return 0;
        }
    }
}