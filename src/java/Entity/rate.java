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
public class rate {

    private String rateID;
    private int rateStar;
    private String comment;
    private String pid;
    private String UserID;
    private String pName;
    private String Fullname;
    private Date _date;
    private int point;

    public rate() {
    }

    public rate(String rateID, int rateStar, String comment, String pid, String UserID, Date _date) {
        this.rateID = rateID;
        this.rateStar = rateStar;
        this.comment = comment;
        this.pid = pid;
        this.UserID = UserID;
        this._date = _date;
    }


    public rate(String rateID, int rateStar, String comment, String pid, String UserID, String pName, String Fullname, Date _date, int point) {
        this.rateID = rateID;
        this.rateStar = rateStar;
        this.comment = comment;
        this.pid = pid;
        this.UserID = UserID;
        this.pName = pName;
        this.Fullname = Fullname;
        this._date = _date;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date _date) {
        this._date = _date;
    }

    public String getRateID() {
        return rateID;
    }

    public void setRateID(String rateID) {
        this.rateID = rateID;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

}
