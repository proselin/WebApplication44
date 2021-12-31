/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author quoch
 */
public class img {
    private String imgID;
    private String imgURL;
    private String pID;

    @Override
    public String toString() {
        return "{" + "imgID=" + imgID + ", imgURL=" + imgURL + ", pID=" + pID + '}';
    }
    
    public img() {
    }

    public String getImgID() {
        return imgID;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }
    
}
