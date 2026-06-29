/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CourseDAO;
import model.Course;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class CourseController {
    private CourseDAO courseDAO = new CourseDAO();

    public int create(Course course) {
        return courseDAO.create(course);
    }

    public List<Course> getCourse(String keyword, int page, int limit) {
        return courseDAO.getCourse(keyword, page, limit);
    }

    public int update(Course course) {
        return courseDAO.update(course);
    }

    public int delete(int id) {
        return courseDAO.delete(id);
    }
}
