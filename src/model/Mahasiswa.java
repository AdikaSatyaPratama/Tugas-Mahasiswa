/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Mahasiswa {
    private int id;
    private String nim;
    private String namaMahasiswa;
    private String jurusan;
    
    public Mahasiswa (int id, String nim, String namaMahasiswa, String jurusan){
        this.id = id;
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.jurusan = jurusan;
    }
    
    public int getId(){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
    public String getNim(){
        return nim;
    } public void setNim (String nim){
        this.nim = nim;
    }
    public String getNamaMahasiswa(){
        return namaMahasiswa;
    } public void setNamaMahasiswa(String namaMahasiswa){
        this.namaMahasiswa = namaMahasiswa;
    }
    public String getJurusan(){
        return jurusan;
    } public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }  
}
