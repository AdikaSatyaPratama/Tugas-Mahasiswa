/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.KoneksiDB;
import model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class CourseDAO {
    public int create(Course course) {
    String sql = "INSERT INTO course (code, name, sks) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.getKoneksi();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getCode());
            ps.setString(2, course.getName());
            ps.setInt(3, course.getSks());
            return ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Gagal menambah Data: " + e.getMessage());
            return 0;
        }
    }

    // 2. READ (Membaca idcourse)
    public List<Course> getCourse(String keyword, int page, int limit) {
        List<Course> list = new ArrayList<>();
        int offset = (page - 1) * limit;
        String sql = "SELECT * FROM course WHERE code LIKE ? OR name LIKE ? LIMIT ? OFFSET ?";
        
        try (Connection conn = KoneksiDB.getKoneksi();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ps.setInt(3, limit);
            ps.setInt(4, offset);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Course(
                        rs.getInt("idcourse"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("sks")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting courses: " + e.getMessage());
        }
        return list;
    }

    // 3. UPDATE (WHERE idcourse)
    public int update(Course course) {
        String sql = "UPDATE course SET code = ?, name = ?, sks = ? WHERE idcourse = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getCode());
            ps.setString(2, course.getName());
            ps.setInt(3, course.getSks());
            ps.setInt(4, course.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating course: " + e.getMessage());
            return 0;
        }
    }

    // 4. DELETE (WHERE idcourse)
    public int delete(int id) {
        String sql = "DELETE FROM course WHERE idcourse = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting course: " + e.getMessage());
            return 0;
        }
    }
}
