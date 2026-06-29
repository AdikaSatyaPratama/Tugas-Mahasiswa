/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LecturerDAO;
import model.Lecturer;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LecturerController {
    private LecturerDAO lecturerDAO = new LecturerDAO();

    public int create(Lecturer lecturer) {
        return lecturerDAO.create(lecturer);
    }

    public List<Lecturer> getLecturer(String keyword, int page, int limit) {
        return lecturerDAO.getLecturer(keyword, page, limit);
    }

    public int update(Lecturer lecturer) {
        return lecturerDAO.update(lecturer);
    }

    public int delete(String nidn) {
        return lecturerDAO.delete(nidn);
    }
}
