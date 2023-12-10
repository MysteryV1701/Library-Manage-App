package DTO.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN 10
 */
public class Staff extends Person{
    private int manageID;
    
    public Staff(){
    }
    
    public Staff(int manageID, int personID, String name, String tel, String address, int status) {
        super(personID, name, tel, address, status);
        this.manageID = manageID;
    }

    public Staff(int manageID) {
        this.manageID = manageID;
    }

    public Staff(String name, String tel, String address, String role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getManageID() {
        return manageID;
    }

    public void setManageID(int manageID) {
        this.manageID = manageID;
    }
    public boolean compare(String name,String tel,String address) throws Exception {
        if(!this.getName().toUpperCase().equals(name.toUpperCase())) {
                return false;
        }
        if(!this.getTel().equals(tel)) {
                return false;
        }
        if(!this.getAddress().toUpperCase().equals(address.toUpperCase())) {
                return false;
        }
        if(!this.getAddress().toUpperCase().equals(address.toUpperCase())) {
                return false;
        }

        return true;
    }

}
