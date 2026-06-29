/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Krs {
     private int idKrs;
     private int idMahasiswa;
     private int idLecturer;
     private int idCourse;
     private int semester;
     private String nimMahasiswa;
     private String namaMahasiswa;
     private String namaCourse;
     private String namaLecturer;
     private String nilai;
     private double nilaiSikap;
     private double nilaiUts;
     private double nilaiUas;
     
     public Krs(){
    }

     
     
     public int getIdKrs(){
         return idKrs;
     }
     public void setIdKrs(int idKrs){
         this.idKrs = idKrs;
     }
     public int getIdMahasiswa(){
         return idMahasiswa;
     }
     public void setIdMahasiswa (int idMahasiswa){
         this.idMahasiswa = idMahasiswa;
     }
     public int getIdCourse(){
         return idCourse;
     }
     public void setIdCourse (int idCourse){
         this.idCourse = idCourse;
     }
     public int getIdLecturer(){
         return idLecturer;
     }
     public void setIdLecturer(int idLecturer){
         this.idLecturer = idLecturer;
     }
     public int getSemester(){
         return semester;
     }
     public void setSemester(int semester){
         this.semester = semester;
     }
     public String getNimMahasiswa() {
          return nimMahasiswa;
     }
     public void setNimMahasiswa(String nimMahasiswa) {
          this.nimMahasiswa = nimMahasiswa;
     }
     public String getNamaMahasiswa() {
          return namaMahasiswa;
     }
     public void setNamaMahasiswa(String namaMahasiswa) {
          this.namaMahasiswa = namaMahasiswa;
     }
     public String getNamaCourse() {
          return namaCourse;
     }
     public void setNamaCourse(String namaCourse) {
          this.namaCourse = namaCourse;
     }
     public String getNamaLecturer() {
          return namaLecturer;
     }
     public void setNamaLecturer(String namaLecturer) {
          this.namaLecturer = namaLecturer;
     }
     public String getNilai(){
         return nilai;
     }
     public void setNilai (String nilai){
         this.nilai = nilai;
     }
     public double getNilaiSikap(){ 
         return nilaiSikap; 
     }
     public void setNilaiSikap(double nilaiSikap){ 
         this.nilaiSikap = nilaiSikap;
     }
    public double getNilaiUts(){ 
        return nilaiUts; 
     }
    public void setNilaiUts(double nilaiUts){ 
        this.nilaiUts = nilaiUts; 
     }
    public double getNilaiUas(){
        return nilaiUas;
     }
    public void setNilaiUas(double nilaiUas){ 
        this.nilaiUas = nilaiUas; 
     }
}

