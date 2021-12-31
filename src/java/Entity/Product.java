/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author quoch
 */
public class Product {

    private String pID;
    private String pName;
    private Float pPrice;
    private String pDes;
    private int pSale_Quantity;
    private int pCurrent_Quantity;
    private int pYear;
    private Date pGet_Date;
    private String pBrand;
    private String pGender;
    private String pIncense;
    private String pMadeIn;
    private int pRate_Count;
    private String pStatus;
    private String cateID;
    
    
    
    
    private category cateinfo;
    private ArrayList<img> imgs;
    private int take;

    @Override
    public String toString() {
        return "{" + "pID=" + pID + ", pName=" + pName + ", pPrice=" + pPrice + ", pDes=" + pDes + ", pSale_Quantity=" + pSale_Quantity + ", pCurrent_Quantity=" + pCurrent_Quantity + ", pYear=" + pYear + ", pGet_Date=" + pGet_Date + ", pBrand=" + pBrand + ", pGender=" + pGender + ", pIncense=" + pIncense + ", pMadeIn=" + pMadeIn + ", pRate_Count=" + pRate_Count + ", pStatus=" + pStatus + ", cateID=" + cateID + ", cateinfo=" + cateinfo + ", imgs=" + imgs + ", take=" + take + '}';
    }

    public category getCateinfo() {
        return cateinfo;
    }

    public void setCateinfo(category cateinfo) {
        this.cateinfo = cateinfo;
    }

    public int getTake() {
        return take;
    }

    public void setTake(int take) {
        this.take = take;
    }

    public Product(String pID, String pName, Float pPrice, String pDes, int pSale_Quantity, int pCurrent_Quantity, int pYear, Date pGet_Date, String pBrand, String pGender, String pIncense, String pMadeIn, int pRate_Count, String pStatus, String cateID) {
        this.pID = pID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pDes = pDes;
        this.pSale_Quantity = pSale_Quantity;
        this.pCurrent_Quantity = pCurrent_Quantity;
        this.pYear = pYear;
        this.pGet_Date = pGet_Date;
        this.pBrand = pBrand;
        this.pGender = pGender;
        this.pIncense = pIncense;
        this.pMadeIn = pMadeIn;
        this.pRate_Count = pRate_Count;
        this.pStatus = pStatus;
        this.cateID = cateID;
    }

    public Product() {
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Float getpPrice() {
        return pPrice;
    }

    public void setpPrice(Float pPrice) {
        this.pPrice = pPrice;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    public int getpSale_Quantity() {
        return pSale_Quantity;
    }

    public void setpSale_Quantity(int pSale_Quantity) {
        this.pSale_Quantity = pSale_Quantity;
    }

    public int getpCurrent_Quantity() {
        return pCurrent_Quantity;
    }

    public void setpCurrent_Quantity(int pCurrent_Quantity) {
        this.pCurrent_Quantity = pCurrent_Quantity;
    }

    public int getpYear() {
        return pYear;
    }

    public void setpYear(int pYear) {
        this.pYear = pYear;
    }

    public Date getpGet_Date() {
        return pGet_Date;
    }

    public void setpGet_Date(Date pGet_Date) {
        this.pGet_Date = pGet_Date;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpGender() {
        return pGender;
    }

    public void setpGender(String pGenger) {
        this.pGender = pGenger;
    }

    public String getpIncense() {
        return pIncense;
    }

    public void setpIncense(String pIncense) {
        this.pIncense = pIncense;
    }

    public String getpMadeIn() {
        return pMadeIn;
    }

    public void setpMadeIn(String pMadeIn) {
        this.pMadeIn = pMadeIn;
    }

    public int getpRate_Count() {
        return pRate_Count;
    }

    public void setpRate_Count(int pRate_Count) {
        this.pRate_Count = pRate_Count;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public ArrayList<img> getImgs() {
        return imgs;
    }

    public void setImgs(ArrayList<img> imgs) {
        this.imgs = imgs;
    }

}
