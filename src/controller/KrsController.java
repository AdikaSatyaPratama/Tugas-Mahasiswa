/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KrsDAO;
import model.Krs;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class KrsController {
    private final KrsDAO krsDao = new KrsDAO();
    
    public int create(Krs krs) {
        return krsDao.create(krs);
    }
    
    public List<Krs> getKrs(String keyword, int page, int limit) {
        return krsDao.getKrs(keyword, page, limit);
    }
    
    public int update(Krs krs) {
        return krsDao.update(krs);
    }
    
    public int delete(int idKrs) {
        return krsDao.delete(idKrs);
    }
}
