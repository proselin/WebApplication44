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
public class voucher {

    /* 
    * This field have in database
     */
    private String vouID;
    private String vouName;
    private float vouValues;
    private Date vouDate_Expired;
    private Date vouDate_Create;
    private String vouStatus;
    private String vouRule;

    /* 
    * this field used to show more information 
    * this not include in database 
     */
    private voucher_user vou_us;
    private String vouRulelist[];
    private int vouRuleEx[];

    public voucher(String vouID, String vouName, float vouValues, Date vouDate_Expired, Date vouDate_Create, String vouStatus, String vouRule, voucher_user vou_us) {
        this.vouID = vouID;
        this.vouName = vouName;
        this.vouValues = vouValues;
        this.vouDate_Expired = vouDate_Expired;
        this.vouDate_Create = vouDate_Create;
        this.vouStatus = vouStatus;
        this.vouRule = vouRule;
        this.vou_us = vou_us;
    }

    public voucher(String vouID, String vouName, float vouValues, Date vouDate_Expired, Date vouDate_Create, String vouStatus, String vouRule) {
        this.vouID = vouID;
        this.vouName = vouName;
        this.vouValues = vouValues;
        this.vouDate_Expired = vouDate_Expired;
        this.vouDate_Create = vouDate_Create;
        this.vouStatus = vouStatus;
        this.vouRule = vouRule;
    }

    public voucher() {
    }

    public String[] getVouRulelist() {
        return vouRulelist;
    }

    public void setVouRulelist(String[] vouRulelist) {
        this.vouRulelist = vouRulelist;
    }

    public int[] getVouRuleEx() {
        return vouRuleEx;
    }

    public void setVouRuleEx(int[] vouRuleEx) {
        this.vouRuleEx = vouRuleEx;
    }

    public voucher_user getVou_us() {
        return vou_us;
    }

    public void setVou_us(voucher_user vou_us) {
        this.vou_us = vou_us;
    }

    public Date getVouDate_Create() {
        return vouDate_Create;
    }

    public void setVouDate_Create(Date vouDate_Create) {
        this.vouDate_Create = vouDate_Create;
    }

    public String getVouID() {
        return vouID;
    }

    public void setVouID(String vouID) {
        this.vouID = vouID;
    }

    public String getVouName() {
        return vouName;
    }

    public void setVouName(String vouName) {
        this.vouName = vouName;
    }

    public double getVouValues() {
        return vouValues;
    }

    public void setVouValues(float vouValues) {
        this.vouValues = vouValues;
    }

    public Date getVouDate_Expired() {
        return vouDate_Expired;
    }

    public void setVouDate_Expired(Date vouDate_Expired) {
        this.vouDate_Expired = vouDate_Expired;
    }

    public String getVouStatus() {
        return vouStatus;
    }

    public void setVouStatus(String vouStatus) {
        this.vouStatus = vouStatus;
    }

    public String getVouRule() {
        return vouRule;
    }

    public void setVouRule(String vouRule) {
        this.vouRule = vouRule;
    }

}
