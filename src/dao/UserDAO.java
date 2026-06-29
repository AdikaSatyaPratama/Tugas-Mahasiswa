/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.KoneksiDB;
import java.sql.*;
/**
 *
 * @author LENOVO
 */
public class UserDAO {
    
    // Fungsi untuk mengecek kecocokan username dan password mentah
    public boolean loginCheck(String username, String passwordMentah) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, passwordMentah);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true; // Jika data ditemukan, return true (Login Sukses)
                }
            }
        } catch (SQLException e) {
            System.out.println("Error pada proses login: " + e.getMessage());
        }
        return false; 
    }
}
