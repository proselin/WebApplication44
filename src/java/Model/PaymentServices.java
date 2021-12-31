/**
 * PaymentServices class - encapsulates PayPal payment integration functions.
 *
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package Model;

import Entity.Order;
import Entity.Product;
import Entity.User;
import com.paypal.api.payments.Address;
import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Currency;
import com.paypal.api.payments.CustomAmount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.orders.PurchaseUnit;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class PaymentServices {

    private static final String CLIENT_ID = "AbUxr4VsozN5okgnJ4TVW2Nvn0N19eyq0uo-Y6R0YN_Lbf96VzXxcnQws5wwTD1SuXdIyg70SeNIUsfv";
    private static final String CLIENT_SECRET = "EOLPfIuaLgQ6foWJro4sJivBvuaw0UYxJRt0XnqJlJ0sy6AQ8Fae9by9m7UJTM-MRcc9gGgE_DI9bXL8";
    private static final String MODE = "sandbox";

    public String authorizePayment(Order orderDetail, ArrayList<Product> prlist)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail, prlist);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        System.out.println("=== CREATED PAYMENT: ====");
        System.out.println(approvedPayment);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation(Order or) {
        String[] name = or.getOrderCustommerName().split(" ");
        String fname = "";
        String lname = "";
        fname = name[0];
        if (name.length >= 2) {

            for (int i = 1; i < name.length; i++) {
                lname = lname + name[i] + " ";
            }
        }
        String[] address = or.getOrderAddress().split(";");
        String street = address[0];
        String country = address[3];
        String postcode = address[4];
        String city = address[1];
        String state = address[2];

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Address ad = new Address();
        ad.setCity(city);
        ad.setLine1(street);
        ad.setPhone(or.getOrderPhoneNumber());
        ad.setState(state);
        ad.setPostalCode(postcode);

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setEmail(or.getOrderEmailContract())
                .setBillingAddress(ad)
                .setPhone(or.getOrderPhoneNumber())
                .setFirstName(fname)
                .setLastName(lname);

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/WebApplication3/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/WebApplication3/execute_payment");
        return redirectUrls;
    }

    private Payer getPayerInformation() {

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private List<Transaction> getTransactionInformation(Order orderDetail, ArrayList<Product> prlists) {

        DecimalFormat df = new DecimalFormat("#.##");
        Details details = new Details();
        details.setShipping("" + 0);
        details.setSubtotal("" + df.format(orderDetail.getSubtotal()));
        details.setTax("" + df.format(orderDetail.getSubtotal() * 0.1));

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(df.format(orderDetail.getOrderTotalPrice()));
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
//        transaction.setInvoiceNumber("Order002");
//        transaction.setDescription("Discount");

        transaction.setDescription(orderDetail.getOrderDes());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        for (Product pr : prlists) {
            Item item = new Item();
            item.setCurrency("USD");
            item.setName(pr.getpName());
            item.setPrice(df.format(pr.getpPrice()));
            item.setQuantity("" + pr.getTake());
            items.add(item);
        }
        
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
}
