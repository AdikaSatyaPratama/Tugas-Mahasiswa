package controller;

import dao.MahasiswaDAO;
import model.Mahasiswa;
import java.util.List;

public class MahasiswaController {
    private MahasiswaDAO mhsDAO = new MahasiswaDAO();

    public int create(Mahasiswa mhs) {
        return mhsDAO.create(mhs);
    }

    public List<Mahasiswa> getMahasiswa(String keyword, int page, int limit) {
        return mhsDAO.getMahasiswa(keyword, page, limit);
    }

    public int update(Mahasiswa mhs) {
        return mhsDAO.update(mhs);
    }

    public int delete(int id) {
        return mhsDAO.delete(id);
    }
}