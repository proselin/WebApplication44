$("#myModal").modal();
function buy() {
    $.ajax({
        type: "POST",
        data: {"orderid" : document.getElementById('orderid').value},
        url: "./ExecutePaymentNomal",
        success: function (data) {
            if (data === "true") {
                $("#myModal").modal();
            }
        }
    })
}