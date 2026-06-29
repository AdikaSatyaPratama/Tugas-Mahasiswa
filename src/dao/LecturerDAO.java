/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.KoneksiDB;
import model.Lecturer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class LecturerDAO {
    
    // 1. CREATE
    public int create(Lecturer lecturer) {
        // Ditambah kolom expertise
        String sql = "INSERT INTO lecturer (nidn, name, expertise) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getKoneksi();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lecturer.getNidn());
            ps.setString(2, lecturer.getName());
            ps.setString(3, lecturer.getExpertise());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating lecturer: " + e.getMessage());
            return 0;
        }
    }

    // 2. READ (Ambil Data + Cari + Pagination)
    public List<Lecturer> getLecturer(String keyword, int page, int limit) {
        List<Lecturer> list = new ArrayList<>();
        int offset = (page - 1) * limit;
        // Query mencari berdasarkan nidn, name, atau expertise
        String sql = "SELECT * FROM lecturer WHERE nidn LIKE ? OR name LIKE ? OR expertise LIKE ? LIMIT ? OFFSET ?";
        
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ps.setString(3, query);
            ps.setInt(4, limit);
            ps.setInt(5, offset);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Masukkan ke dalam objek Lecturer lengkap dengan expertise
                    list.add(new Lecturer(
                        rs.getInt("idlecturer"),
                        rs.getString("nidn"), 
                        rs.getString("name"),
                        rs.getString("expertise")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting lecturers: " + e.getMessage());
        }
        return list;
    }

    // 3. UPDATE
    public int update(Lecturer lecturer) {
        // Mengubah nama dan keahlian berdasarkan NIDN
        String sql = "UPDATE lecturer SET nidn = ?, name = ?, expertise = ? WHERE idlecturer = ?";
            try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lecturer.getNidn());
            ps.setString(2, lecturer.getName());
            ps.setString(3, lecturer.getExpertise());
            ps.setInt(4, lecturer.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating lecturer: " + e.getMessage());
            return 0;
        }
    }

    // 4. DELETE
    public int delete(String nidn) {
        String sql = "DELETE FROM lecturer WHERE nidn = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nidn);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting lecturer: " + e.getMessage());
            return 0;
        }
    }
}
