/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author quoch
 */
public class category {
    private String cateid;
    private String cateName;
    private String cateDes;

    public category(String cateid, String cateName, String cateDes) {
        this.cateid = cateid;
        this.cateName = cateName;
        this.cateDes = cateDes;
    }

    @Override
    public String toString() {
        return "{" + "cateid=" + cateid + ", cateName=" + cateName + ", cateDes=" + cateDes + '}';
    }
    

    public category() {
    }
    

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDes() {
        return cateDes;
    }

    public void setCateDes(String cateDes) {
        this.cateDes = cateDes;
    }
    
    
}
