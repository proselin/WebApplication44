
var modalBody = document.getElementsByClassName('modal-body')[0];
function checkRule(limit1, limit2) {
    var cartItemContainer = document.getElementsByTagName('tbody')[0]
    var inputlist = cartItemContainer.getElementsByClassName('input_quantity')
    var cartQuantity = 0;
    var result = true;
    for (var i = 0; i < inputlist.length; i++) {
        cartQuantity += inputlist[i].value
    }
    cartQuantity = parseInt(cartQuantity)

    if (limit1 > cartQuantity || cartQuantity > limit2) {
        result = false
    }
    console.log(result);
    return result
}

function start() {
    requestVoucherList()
}

function requestVoucherList() {
    if (document.getElementById('profile') !== null) {
        console.log('in');
        var containerCanUsingElement = document.getElementsByClassName('list_voucher_can_using')[0]
        const listOfVoucher = containerCanUsingElement.getElementsByClassName('usingbtn')
        var containerCannotUsingElement = document.getElementById('voucher_cannot_use')
        console.log(containerCannotUsingElement);
        $.ajax({
            url: "./cart?ac=requestVoucher",
            type: 'POST',
            success: function (data) {
                if (data.length !== 0) {
                    voucherList = data
                    console.log(data);
                    $.each(data, function (key, value) {
                        var vouId = value.VouID
                        var voucherinfo = value.voucher_info
                        var vouId = voucherinfo.vouID
                        var vouName = voucherinfo.vouName
                        var vouValue = voucherinfo.vouValues
                        var vouEx_date = voucherinfo.vouDate_Expired
                        var vouRule = voucherinfo.vouRule
                        var limit1 = vouRule.split(",")[1].split('product')[0]
                        var limit2 = vouRule.split(",")[1].split('product')[1]
                        if (checkRule(limit1, limit2)) {
                            var item = `
        <div class="coupon_Container">
            <div class="row">
                <div class="col-md-2">
                    <div class="image_coupon">
                        &nbsp;
                    </div>
                </div>
                <div class="col-md-5 mid_coupon" data-vou=${vouId} data-limit1="${limit1}" data-limit2="${limit2}">
                    <div class="row">
                        <div class="col-md-12">
                             <span class="badge badge-success">Valid</span>
                        </div>
                        <div class="col-md-12 name">
                            ${vouName}
                        </div>
                        <div class="col-md-12">
                           <p class="text-muted mb-0 voucher_value">$ ${vouValue}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 button">
                    <p>
                        Expired:
                    </p>
                     <p class="ex_date">${vouEx_date}</p>
                </div>
                <div class='col-md-2 button_Container'>
                    <button class="usingbtn btn btn-sm btn-outline-danger btn-block">using</button>
                </div>
            </div>
        </div>`

                            containerCanUsingElement.insertAdjacentHTML('afterbegin', item)
                            containerCanUsingElement = document.getElementsByClassName('list_voucher_can_using')[0]
                            containerCanUsingElement.getElementsByClassName('usingbtn')[0].addEventListener('click', usingAVoucher)
                        } else {
                            var item = `
        <div class="coupon_Container">
            <div class="row">
                <div class="col-md-2">
                    <div class="image_coupon">
                        &nbsp;
                    </div>
                </div>
                <div class="col-md-5 mid_coupon" data-vou=${vouId} data-limit1="${limit1}" data-limit2="${limit2}">
                    <div class="row">
                        <div class="col-md-12">
                             <span class="badge badge-success">Valid</span>
                        </div>
                        <div class="col-md-12 name">
                            ${vouName}
                        </div>
                        <div class="col-md-12">
                           <p class="text-muted mb-0 voucher_value">$ ${vouValue}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 button">
                    <p>
                        Expired:
                    </p>
                     <p class="ex_date">${vouEx_date}</p>
                </div>
                <div class='col-md-2 button_Container'>
                    <button class="usingbtn btn btn-sm btn-outline-danger btn-block">using</button>
                </div>
            </div>
        </div>`
                            containerCannotUsingElement.insertAdjacentHTML('afterbegin', item)
                        }
                    })
                }
            }
        })
    }
}



function usingAVoucher(event) {
    const button = event.target
    const voucherContainerElement = button.parentElement.parentElement.parentElement
    var midcoupon = voucherContainerElement.getElementsByClassName('mid_coupon')[0]

    var limit1 = midcoupon.dataset.limit1
    var limit2 = midcoupon.dataset.limit2
    var vouId = midcoupon.dataset.vou
    var vouName = voucherContainerElement.getElementsByClassName('name')[0].innerText
    var vouEx_date = voucherContainerElement.getElementsByClassName('ex_date')[0].innerText
    var vouValue = voucherContainerElement.getElementsByClassName('voucher_value')[0].innerText.replace('$', '')




    const containerElement = document.getElementsByClassName('current_select_voucher')[0]

    const item = `        <div class="coupon_Container" id = "current_voucher">
            <div class="row">
                <div class="col-md-2">
                    <div class="image_coupon">
                        &nbsp;
                    </div>
                </div>
                <div class="col-md-5 mid_coupon" data-vou=${vouId} data-limit1="${limit1}" data-limit2="${limit2}">
                    <div class="row">
                        <div class="col-md-12">
                             <span class="badge badge-success">Valid</span>
                        </div>
                        <div class="col-md-12 name">
                            ${vouName}
                        </div>
                        <div class="col-md-12">
                           <p class="text-muted mb-0 voucher_value">$ ${vouValue}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 button">
                    <p>
                        Expired:
                    </p>
                     <p class="ex_date">${vouEx_date}</p>
                </div>
                <div class='col-md-2 button_Container'>
                    <button class="removebtn btn btn-sm btn-outline-danger btn-block">remove</button>
                </div>
            </div>
        </div>`
    containerElement.innerHTML = item
    const currentvoucher = document.getElementById('current_voucher')
    console.log(currentvoucher)
    currentvoucher.getElementsByClassName('removebtn')[0].addEventListener('click', removeCurrentVoucher)
    updateCartTotalWithVoucher(vouId, vouValue)
}

function updateCartTotalWithVoucher(id, value) {
    const inputElement = document.getElementById('my_form').getElementsByTagName('input')[0]
    inputElement.value = id

    var discountElement = document.getElementById('discount_value').getElementsByTagName('span')[0]
    discountElement.innerText = '$' + value
    updateCartTotal()
}

function removeCurrentVoucher(event) {
    event.target.parentElement.parentElement.parentElement.remove()
    updateCartTotalWithVoucher("", 0)
}

function updateUsingVoucher() {
    var voucherContainerElement = document.getElementsByClassName('list_voucher_can_using')[0]
    const voucherLimit = voucherContainerElement.getElementsByClassName('mid_coupon')
    var importlocation = document.getElementById('voucher_cannot_use')
    const len = voucherLimit.length
    if (document.getElementById('current_voucher') !== null) {
        var cn = document.getElementById('current_voucher').getElementsByClassName('mid_coupon')
        var id = cn[0].dataset.vou
    }
    var i = 0;
    var j = 0;
    while (j < len) {
        var limit1 = voucherLimit[i].dataset.limit1
        var limit2 = voucherLimit[i].dataset.limit2
        var vouId = voucherLimit[i].dataset.vou

        if (checkRule(limit1, limit2) === false) {
            if (vouId === id) {
                cn[0].parentElement.parentElement.parentElement.remove()
                updateCartTotalWithVoucher("", 0)
            }
            var removeElement = voucherLimit[i].parentElement.parentElement
            removeElement.remove()
            var vouName = removeElement.getElementsByClassName('name')[0].innerText
            var vouEx_date = removeElement.getElementsByClassName('ex_date')[0].innerText
            var vouValue = removeElement.getElementsByClassName('voucher_value')[0].innerText.replace('$', '')

            var item = `
            <div class="coupon_Container">
            <div class="row">
                <div class="col-md-2">
                    <div class="image_coupon">
                        &nbsp;
                    </div>
                </div>
                <div class="col-md-5 mid_coupon" data-vou=${vouId} data-limit1="${limit1}" data-limit2="${limit2}">
                    <div class="row">
                        <div class="col-md-12">
                             <span class="badge badge-success">Valid</span>
                        </div>
                        <div class="col-md-12 name">
                            ${vouName}
                        </div>
                        <div class="col-md-12">
                           <p class="text-muted mb-0 voucher_value">$ ${vouValue}</p>
                            <p class= "warning">${limit1} to use voucher</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 button">
                    <p>
                        Expired:
                    </p>
                     <p class="ex_date">${vouEx_date}</p>

                </div>
                <div class='col-md-2 button_Container'>
                        <button disable class=" btn btn-sm btn-outline-danger btn-block">Using</button>
                </div>
            </div>
        </div> `
            importlocation.insertAdjacentHTML('afterbegin', item);
            i--
        }
        i++;
        j++;
    }
}

function updateCannotUsingVoucher() {
    var voucherContainerElement = document.getElementById('voucher_cannot_use')
    const voucherLimit = voucherContainerElement.getElementsByClassName('mid_coupon')
        const len = voucherLimit.length
        const importlocation = document.getElementsByClassName('list_voucher_can_using')[0]
        var i = 0;
        var j = 0;
        while (j < len) {

            var limit1 = voucherLimit[i].dataset.limit1
            var limit2 = voucherLimit[i].dataset.limit2
            var vouId = voucherLimit[i].dataset.vou
            if (checkRule(limit1, limit2)) {
                var removeElement = voucherLimit[i].parentElement.parentElement
                removeElement.remove()
                var vouName = removeElement.getElementsByClassName('name')[0].innerText
                var vouEx_date = removeElement.getElementsByClassName('ex_date')[0].innerText
                var vouValue = removeElement.getElementsByClassName('voucher_value')[0].innerText.replace('$', '')
                var item = `
        <div class="coupon_Container">
            <div class="row">
                <div class="col-md-2">
                    <div class="image_coupon">
                        &nbsp;
                    </div>
                </div>
                <div class="col-md-5 mid_coupon" data-vou=${vouId} data-limit1="${limit1}" data-limit2="${limit2}">
                    <div class="row">
                        <div class="col-md-12">
                             <span class="badge badge-success">Valid</span>
                        </div>
                        <div class="col-md-12 name">
                            ${vouName}
                        </div>
                        <div class="col-md-12">
                           <p class="text-muted mb-0 voucher_value">$ ${vouValue}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 button">
                    <p>
                        Expired:
                    </p>
                     <p class="ex_date">${vouEx_date}</p>
                </div>
                <div class='col-md-2 button_Container'>
                    <button class="usingbtn btn btn-sm btn-outline-danger btn-block">using</button>
                </div>
            </div>
        </div>`

                importlocation.insertAdjacentHTML('afterbegin', item)
                var btn = document.getElementsByClassName('usingbtn')[0]
                btn.addEventListener('click', usingAVoucher)
                i--;
            }
            i++;
            j++;
        }
    }


function claimAVoucher(event) {
    const button = event.target
    const removeElement = button.parentElement.parentElement.parentElement.parentElement
    removeElement.remove()


    const voucherNameElement = removeElement.getElementsByClassName('lead')[0]
    const name = voucherNameElement.getElementsByTagName('strong')[0].innerText
    const voucherValuesElement = removeElement.getElementsByClassName('voucher_value')[0]
    const voucherValues = parseFloat(voucherValuesElement.innerText.replace('$', ''))
    const voucherExpiredDate = removeElement.getElementsByClassName('ex_date')[0].innerText
    const voucherid = removeElement.getElementsByClassName('claimbtn')[0].dataset.vou




    const containerCanUsingElement = document.getElementsByClassName('list_voucher_can_using')[0]
    const item =
            ` < div class = "coupon bg-white rounded mb-3 d-flex justify-content-between" >
                        <div class="kiri p-3">
    <div class="icon-container ">
        <div class="icon-container_box" >
            <img src="img/coupon/p1.jpg" width="170px" height="120px" alt=""/>
        </div>
    </div>
</div>
                        <div class="tengah py-3 d-flex w-100 justify-content-start">
    <div>
        <span class="badge badge-success">Valid</span>
        <span class="badge badge-success" style="background-color: red;color: black">Invalidok</span>
        <h3 class="lead" style="margin-top: 20px;font-size: 20px"><strong>${name} ${"notok"}</strong></h3>
        <p >Value: </p>
        <p class="text-muted mb-0 voucher_value">$ ${voucherValues}</p>
    </div>
</div>
                        <div class="kanan">
    <div class="info m-3 d-flex align-items-center">
        <div class="w-100">
            <div class="block">
                <span class="time font-weight-light">
                    <p >Expired:</p>
                    <p class="ex_date">${voucherExpiredDate}</p>
                </span>
            </div>
            <button class=" usingbtn btn btn-sm btn-outline-danger btn-block""  data-vou="${voucherid}">using</button>
        </div>
    </div>
</div>
                        </div>
                        </div>
                `
    containerCanUsingElement.insertAdjacentHTML('afterbegin', item)
    containerCanUsingElement.getElementsByClassName('coupon bg-white rounded mb-3 d-flex justify-content-between')[0].addEventListener('click', usingAVoucher)

}