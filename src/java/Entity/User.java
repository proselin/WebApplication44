/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author quoch
 */
public class User {

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", FullName=" + FullName + ", _Address=" + _Address + ", Gender=" + Gender + ", Phone=" + Phone + ", Email=" + Email + ", Date_of_birth=" + Date_of_birth + ", _UserName=" + _UserName + ", _Password=" + _Password + ", point=" + point + ", RoleID=" + RoleID + '}';
    }

    private String UserID;
    private String FullName;
    private String _Address;
    private String Gender;
    private String Phone;
    private String Email;
    private Date Date_of_birth;
    private String _UserName;
    private String _Password;
    private int point;
    private String RoleID;

    private String[] addresslist;

    public User() {

    }

    public User(String UserID, String FullName, String _Address, String Gender, String Phone, String Email, Date Date_of_birth, String _UserName, String _Password, int point, String RoleID) {
        this.UserID = UserID;
        this.FullName = FullName;
        this._Address = _Address;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Email = Email;
        this.Date_of_birth = Date_of_birth;
        this._UserName = _UserName;
        this._Password = _Password;
        this.point = point;
        this.RoleID = RoleID;
    }

    public User(String Fullname, String Phone, String _UserName, String _Password) {
        this.Phone = Phone;
        this._UserName = _UserName;
        this._Password = _Password;
    }

    public User(String Email, String _UserName, String _Password) {
        this.Email = Email;
        this._UserName = _UserName;
        this._Password = _Password;

    }

    public User(String UserID, String FullName) {
        this.UserID = UserID;
        this.FullName = FullName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getAddress() {
        return _Address;
    }

    public void setAddress(String _Address) {
        this._Address = _Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(Date Date_of_birth) {
        this.Date_of_birth = Date_of_birth;
    }

    public String getUserName() {
        return _UserName;
    }

    public void setUserName(String _UserName) {
        this._UserName = _UserName;
    }

    public String getPassword() {
        return _Password;
    }

    public void setPassword(String _Password) {
        this._Password = _Password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public String[] getAddresslist() {
        return addresslist;
    }

    public void setAddresslist(String[] addresslist) {
        this.addresslist = addresslist;
    }

}
