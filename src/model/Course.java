/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Course {
    private int id;
    private String code;
    private String name;
    private int sks;
    
    public Course(int id, String code, String name, int sks) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sks = sks;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSks(){
        return sks;
    }
    public void setSks(int sks){
        this.sks = sks;
    }
}
