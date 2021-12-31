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
public class Order {

    private String orderID;
    private Date orderDate;
    private String orderDes;
    private String orderStatus;
    private String orderAddress;
    private String orderCustommerName;
    private String orderEmailContract;
    private String orderPhoneNumber;
    private float orderTotalPrice;
    private String orderPaymentMethod;
    private String UserID;
    private String vouID;
    
    
    
    private String[] address;
    private float discount;
    private float tax;
    private float shipping;
    private float subtotal;
    
    

    public Order() {
    }
    
    public Order(String orderID, Date orderDate, String orderDes, String orderStatus, String orderAddress, String orderCustommerName, String orderEmailContract, String orderPhoneNumber, float orderTotalPrice, String orderPaymentMethod, String UserID, String vouID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderDes = orderDes;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.orderCustommerName = orderCustommerName;
        this.orderEmailContract = orderEmailContract;
        this.orderPhoneNumber = orderPhoneNumber;
        this.orderTotalPrice = orderTotalPrice;
        this.orderPaymentMethod = orderPaymentMethod;
        this.UserID = UserID;
        this.vouID = vouID;
    }

    public Order(String orderDes, String orderAddress, String orderCustommerName, String orderEmailContract, String orderPhoneNumber, float orderTotalPrice, String orderPaymentMethod, String UserID, String vouID) {
        this.orderDes = orderDes;
        this.orderAddress = orderAddress;
        this.orderCustommerName = orderCustommerName;
        this.orderEmailContract = orderEmailContract;
        this.orderPhoneNumber = orderPhoneNumber;
        this.orderTotalPrice = orderTotalPrice;
        this.orderPaymentMethod = orderPaymentMethod;
        this.UserID = UserID;
        this.vouID = vouID;
    }

    public Order(String orderID, Date orderDate, String orderDes, String orderStatus, String orderAddress, String orderCustommerName, String orderPhoneNumber, float orderTotalPrice, String orderPaymentMethod, String UserID, String vouID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderDes = orderDes;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.orderCustommerName = orderCustommerName;
        this.orderPhoneNumber = orderPhoneNumber;
        this.orderTotalPrice = orderTotalPrice;
        this.orderPaymentMethod = orderPaymentMethod;
        this.UserID = UserID;
        this.vouID = vouID;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    
    
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getShipping() {
        return shipping;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", orderDes=" + orderDes + ", orderStatus=" + orderStatus + ", orderAddress=" + orderAddress + ", orderCustommerName=" + orderCustommerName + ", orderEmailContract=" + orderEmailContract + ", orderPhoneNumber=" + orderPhoneNumber + ", orderTotalPrice=" + orderTotalPrice + ", orderPaymentMethod=" + orderPaymentMethod + ", UserID=" + UserID + ", vouID=" + vouID + '}';
    }
    
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDes() {
        return orderDes;
    }

    public void setOrderDes(String orderDes) {
        this.orderDes = orderDes;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderCustommerName() {
        return orderCustommerName;
    }

    public void setOrderCustommerName(String orderCustommerName) {
        this.orderCustommerName = orderCustommerName;
    }

    public String getOrderEmailContract() {
        return orderEmailContract;
    }

    public void setOrderEmailContract(String orderEmailContract) {
        this.orderEmailContract = orderEmailContract;
    }

    public String getOrderPhoneNumber() {
        return orderPhoneNumber;
    }

    public void setOrderPhoneNumber(String orderPhoneNumber) {
        this.orderPhoneNumber = orderPhoneNumber;
    }

    public float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getVouID() {
        return vouID;
    }

    public void setVouID(String vouID) {
        this.vouID = vouID;
    }

}
