<%-- 
    Document   : review_pay
    Created on : Dec 7, 2021, 12:22:21 AM
    Author     : quoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="inc/header.jsp"></jsp:include>
    

<div align="center" style="font-size: 15px">
    <h3 style="margin-bottom: 20px">Please Review Before Paying</h3>
            <form action="ExecutePaymentNomal" method="post">
                <table>
                    <tr>
                        <td colspan="2"><b>Transaction Details:</b></td>
                        <td>

                            <input type="hidden" name="orderid" value="${orderid}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>${order.getOrderDes()}</td>
                    </tr>
                    <tr>
                        <td>Subtotal:</td>
                        <td>${order.getSubtotal()} USD</td>
                    </tr>
                    <tr>
                        <td>Shipping:</td>
                        <td>0 USD</td>
                    </tr>
                    <tr>
                        <td>Tax:</td>
                        <td>${order.getTax()} USD</td>
                    </tr>
                    <tr>
                        <td>Total:</td>
                        <td>${order.getOrderTotalPrice()} USD</td>
                    </tr>	
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2"><b>Payer Information:</b></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>${order.getOrderCustommerName()}</td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td>${order.getOrderPhoneNumber()}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${order.getOrderEmailContract()}</td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2"><b>Shipping Address:</b></td>
                    </tr>
                    <tr>
                        <td>Line 1:</td>
                        <td>${address}</td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td>${towncity}</td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td>${state}</td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td>${country}</td>
                    </tr>
                    <tr>
                        <td>Postal Code:</td>
                        <td>${postcode}</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Pay Now" />
                        </td>
                    </tr>		
                </table>
            </form>
        </div>
                        <jsp:include page="inc/footer.jsp"></jsp:include>