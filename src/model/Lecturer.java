/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Lecturer {
    private int id;
    private String nidn;
    private String expertise;
    private String name;
    
    public Lecturer (int id, String nidn, String name, String expertise){
        this.id = id;
        this.nidn = nidn;
        this.expertise = expertise;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
        
    public String getNidn(){
        return nidn;
    }
    public void setNidn(String nidn){
        this.nidn = nidn;
    }
    public String getExpertise(){
        return expertise;
    }
    public void setExpertise(String expertise){
        this.expertise = expertise;
    }
    public String getName(){
        return name;
    }
    public void setNama(String name){
        this.name = name;
    }
}
