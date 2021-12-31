/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author quoch
 */
public class voucher_user {
    private String UserID;
    private String VouID;
    private String status;
    private voucher voucher_info;

    public voucher getVoucher_info() {
        return voucher_info;
    }

    public void setVoucher_info(voucher voucher_info) {
        this.voucher_info = voucher_info;
    }


    public voucher_user(String UserID, String VouID, String status) {
        this.UserID = UserID;
        this.VouID = VouID;
        this.status = status;
    }

    public voucher_user() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getVouID() {
        return VouID;
    }

    public void setVouID(String VouID) {
        this.VouID = VouID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    
}
