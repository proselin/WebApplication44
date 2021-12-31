


if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready()

}
function ready() {
    addProducttoCart()
    updateCartTotal()
    requestVoucherList()
    var removeCartItemButtons = document.getElementsByClassName('icon_close')
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        var button = removeCartItemButtons[i]
        button.addEventListener('click', removeCartItem)
    }

    var quantityInputs = document.getElementsByClassName('input_quantity')
    for (var i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i]
        input.addEventListener('change', quantityChanged)
    }



}


function removeCartItem(event) {
    var buttonClicked = event.target
    var removeElement = buttonClicked.parentElement.parentElement
    var idOfProductChangedQuantity = event.currentTarget.dataset.pid

    $.ajax({
        url: `./cart?ac=doremove`,
        method: 'POST',
        data: {
            pid: idOfProductChangedQuantity,
        },
        success: function () {
            removeElement.remove()
            updateCartTotal()
        }
    });
}

function quantityChanged(event) {
    var inputQuantity = event.target
    if (isNaN(inputQuantity.value) || inputQuantity.value <= 0) {
        inputQuantity.value = 1
    }
    var take = inputQuantity.value
    var changeElementContainer = inputQuantity.parentElement.parentElement.parentElement
    var idOfProduct = changeElementContainer.getElementsByClassName('icon_close')[0].dataset.pid
    $.ajax({
        url: './cart?ac=dochange',
        method: 'POST',
        data: {
            pid: idOfProduct,
            take: take
        },
        success: function (data) {
            let obj = data
            console.log(obj.pCurrent_Quantity);
            if (inputQuantity.value > obj.pCurrent_Quantity) {
                inputQuantity.value = obj.pCurrent_Quantity
            }
            updateCartTotal()
            updateCannotUsingVoucher()
            updateUsingVoucher()
        }
    });
}

function addProducttoCart() {
    $.ajax({
        url: "./cart",
        method: 'POST',
        data: {ac: "doshow"},
        success: function (data) {
            if (data !== null) {
                console.log(data)
                let listobjectgetFromsever = data;
                var itemContainer = document.getElementById('tables');
                $.each(listobjectgetFromsever, function (key, value) {
                    var image = value.imgs[0].imgURL;
                    var price = value.pPrice;
                    var currentQuantityTake = value.take;
                    var productName = value.pName;
                    var productID = value.pID;
                    var rateCount = value.pRate_Count;
                    var rateCountStarHTML = `<i class="fa fa-star"></i>`
                    var star = ''
                    for (var i = 0; i < rateCount; i++) {
                        star += rateCountStarHTML;
                    }
                    var item = ` 
                <tr>
                                    <td class="cart__product__item">
                                        <img src="${image}" alt="" style="width: 100px; height: 100px; border: white solid 1px; border-radius: 25px">
                                        <div class="cart__product__item__title">
                                            <h6>${productName}</h6>
                                            <div class="rating">
                                            ${star}
                                            </div>
                                        </div>
                                    </td>
                                    <td class="cart__price">$ ${price}</td>
                                    <td class="cart__quantity">
                                        <div class="pro-qty">
                                            <input class="input_quantity" type="number" value="${currentQuantityTake}">
                                        </div>
                                    </td>
                                    <td class="cart__total">$ 0</td>
                                    <td class="cart__close"><span class="icon_close" data-pid="${productID}"></span></td>
                                </tr>`;
                    var row = itemContainer.insertRow(0);
                    row.innerHTML = item
                    row.getElementsByClassName('icon_close')[0].addEventListener('click', removeCartItem)
                    row.getElementsByClassName('input_quantity')[0].addEventListener('change', quantityChanged)

                });
                updateCartTotal()
            }

        }
    })

}



function updateCartTotal() {
    var cartItemContainer = document.getElementsByTagName('tbody')[0]
    var cartRows = cartItemContainer.getElementsByTagName('tr')
    var total = 0
    var subtotal = 0
    var tax = 0
    var shipping = 0
    for (var i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i]
        var priceElement = cartRow.getElementsByClassName('cart__price')[0]
        var quantityElement = cartRow.getElementsByClassName('input_quantity')[0]
        var price = parseFloat(priceElement.innerText.replace('$', ''))
        var quantity = quantityElement.value
        var currentProducTotalPrice = price * quantity
        total = total + (currentProducTotalPrice)
        currentProducTotalPrice = Math.round(currentProducTotalPrice * 100) / 100
        document.getElementsByClassName('cart__total')[i].innerText = '$' + currentProducTotalPrice
    }

    total = Math.round(total * 100) / 100
    subtotal = total
    tax = Math.round((total * 0.1) * 100) / 100
    total = Math.round((total + tax) * 100) / 100
    if (document.getElementById('current_voucher') !== null) {
        const currentVoucherElement = document.getElementById('current_voucher')
        const value = currentVoucherElement.getElementsByClassName('voucher_value')[0].innerText.replace('$', '')
        total = Math.round((total - value) * 100) / 100
        console.log(total);
        if (total < 0)
            total = 1
    }
    document.getElementsByClassName('cart_tax_price')[0].getElementsByTagName('span')[0].innerText = '$' + tax
    document.getElementsByClassName('cart_shipping_price')[0].getElementsByTagName('span')[0].innerText = "Free Ship"
    document.getElementsByClassName('cart_total_price')[0].getElementsByTagName('span')[0].innerText = '$' + total
    document.getElementsByClassName('cart_subtotal_price')[0].getElementsByTagName('span')[0].innerText = '$' + subtotal
}

