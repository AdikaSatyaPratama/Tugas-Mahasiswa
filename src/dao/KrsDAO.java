/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Krs;
import database.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class KrsDAO {

    // CREATE
    public int create(Krs krs) {
        String sql = "INSERT INTO krs (idmahasiswa, idcourse, idlecturer, semester, nilai_sikap, nilai_uts, nilai_uas) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, krs.getIdMahasiswa());
            ps.setInt(2, krs.getIdCourse());
            ps.setInt(3, krs.getIdLecturer());
            ps.setInt(4, krs.getSemester());
            ps.setDouble(5, krs.getNilaiSikap());
            ps.setDouble(6, krs.getNilaiUts());   
            ps.setDouble(7, krs.getNilaiUas());   
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating KRS: " + e.getMessage());
            return 0;
        }
    }
    
    //READ
    public List<Krs> getKrs(String keyword, int page, int limit) {
        List<Krs> list = new ArrayList<>();
        int offset = (page - 1) * limit;
        
        String sql = "SELECT k.idkrs, k.idmahasiswa, k.idcourse, k.idlecturer, k.semester, " +
                     "k.nilai_sikap, k.nilai_uts, k.nilai_uas, " + 
                     "m.nim, m.nama_mahasiswa, c.name AS name_course, l.name AS nama_dosen " +
                     "FROM krs k " +
                     "LEFT JOIN mahasiswa m ON k.idmahasiswa = m.idmahasiswa " +
                     "LEFT JOIN course c ON k.idcourse = c.idcourse " +
                     "LEFT JOIN lecturer l ON k.idlecturer = l.idlecturer " +
                     "WHERE m.nama_mahasiswa LIKE ? OR c.name LIKE ? " +
                     "LIMIT ? OFFSET ?";
        
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);
            ps.setInt(3, limit);
            ps.setInt(4, offset);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Krs krs = new Krs();
                    krs.setIdKrs(rs.getInt("idkrs"));
                    krs.setIdMahasiswa(rs.getInt("idmahasiswa"));
                    krs.setIdCourse(rs.getInt("idcourse"));
                    krs.setIdLecturer(rs.getInt("idlecturer"));
                    krs.setSemester(rs.getInt("semester"));
                    
                    krs.setNimMahasiswa(rs.getString("nim"));
                    krs.setNamaMahasiswa(rs.getString("nama_mahasiswa"));
                    krs.setNamaCourse(rs.getString("name_course"));
                    krs.setNamaLecturer(rs.getString("nama_dosen"));
                    krs.setNilaiSikap(rs.getDouble("nilai_sikap"));
                    krs.setNilaiUts(rs.getDouble("nilai_uts"));
                    krs.setNilaiUas(rs.getDouble("nilai_uas"));
                    
                    list.add(krs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting KRS: " + e.getMessage());
        }
        return list;
    }
    //UPDATE
    public int update(Krs krs) {
        String sql = "UPDATE krs SET idmahasiswa = ?, idcourse = ?, idlecturer = ?, semester = ?, nilai_sikap = ?, nilai_uts = ?, nilai_uas = ? WHERE idkrs = ?";
    
        try (Connection conn = KoneksiDB.getKoneksi();
            PreparedStatement ps = conn.prepareStatement(sql)) {
        
                    ps.setInt(1, krs.getIdMahasiswa());
                    ps.setInt(2, krs.getIdCourse());
                    ps.setInt(3, krs.getIdLecturer());
                    ps.setInt(4, krs.getSemester());
                    ps.setDouble(5, krs.getNilaiSikap()); 
                    ps.setDouble(6, krs.getNilaiUts());  
                    ps.setDouble(7, krs.getNilaiUas());   
                    ps.setInt(8, krs.getIdKrs());         
        
                    return ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error updating KRS: " + e.getMessage());
                    return 0;
                }
            }
    // 4. DELETE
    public int delete(int idKrs) {
        String sql = "DELETE FROM krs WHERE idkrs = ?";
        try (Connection conn = KoneksiDB.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idKrs);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting KRS: " + e.getMessage());
            return 0;
        }
    }
}
