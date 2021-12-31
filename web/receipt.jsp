<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="inc/header.jsp"></jsp:include>
<div align="center">
    <h3 style="margin-bottom: 20px; margin-top: 20px; font-size: 15px">Payment Done. Thank you for purchasing our products</h1>
	<br/>
        <h5 style="margin-bottom: 20px">Receipt Details:</h2>
	<table>
		<tr>
			<td><b>Merchant:</b></td>
			<td>Charmain Perfume Store</td>
		</tr>
		<tr>
			<td><b>Payer:</b></td>
			<td>${payer.firstName} ${payer.lastName}</td>		
		</tr>
		<tr>
			<td><b>Description:</b></td>
			<td>${transaction.description}</td>
		</tr>	
		<tr>
			<td><b>Subtotal:</b></td>
			<td>${transaction.amount.details.subtotal} USD</td>
		</tr>
		<tr>
			<td><b>Shipping:</b></td>
			<td>${transaction.amount.details.shipping} USD</td>
		</tr>
		<tr>
			<td><b>Tax:</b></td>
			<td>${transaction.amount.details.tax} USD</td>
		</tr>
		<tr>
			<td><b>Total:</b></td>
			<td>${transaction.amount.total} USD</td>
		</tr>						
	</table>
</div>
                        <jsp:include page="inc/footer.jsp"></jsp:include>