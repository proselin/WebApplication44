/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


prepareRegister();
checkPersionalDetails()
function   checkPersionalDetails() {
    const name = document.getElementById('name')
    const dob = document.getElementById('dob')
    const phone = document.getElementById('phone')
    name.addEventListener('change', checkName)
    dob.addEventListener('change', checkDob)
    phone.addEventListener('change', checkPhone)
}
function prepareRegister() {
    var username = document.getElementById('username');
    var pass = document.getElementById('password');
    var cpass = document.getElementById('cpass');
    cpass.disabled = true
    pass.disabled = true
    username.addEventListener('change', checkUsername)
    pass.addEventListener('change', checkPassword)
    cpass.addEventListener('change', checkPasswordConfirm)
}
function checkUsername(event) {
    document.getElementById('alertusername').innerText = ""
    var input = event.target
    if (input.value.length < 5) {
        document.getElementById('alertusername').innerText = "Pass"
        document.getElementById('password').disabled = true
    } else {
        $.ajax({url: "./register?ac=checkUsername",
            type: "POST",
            data: {username: input.value},
            success: function (data) {
                if (data === "true") {
                    document.getElementById('alertusername').innerText = "You can using this username"
                    document.getElementById('alertusername').classList.add('ok')
                    document.getElementById('password').disabled = false
                } else {
                    document.getElementById('alertusername').innerText = "This username has been using"
                    document.getElementById('alertusername').classList.remove('ok')
                    document.getElementById('password').disabled = true
                }

            }
        })
    }
}
function checkPassword(event) {
    var input = event.target
    var notify = document.getElementById('alertpassword')
    var check = input.value
    console.log(check);
    console.log(check.match(/^(?=.*[0-9])[a-zA-Z0-9]{8,}$/));
    if (check.match(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$/) !== null) {
        notify.innerText = "You can using this password"
        notify.classList.add('ok')
        document.getElementById('cpass').disabled = false

    } else {
        notify.innerText = "Your password at least 8 character with 1 uppercase , 1 lowercase , a nummber and none spercial character"
        document.getElementById('cpass').disabled = true
        notify.classList.remove('ok')
    }

}
function checkPasswordConfirm(event) {
    var input = event.target
    var notify = document.getElementById('alertcpass')
    if (input.value === document.getElementById('password').value) {
        notify.innerText = "You can continue"
        notify.classList.add('ok')
        document.getElementsByClassName('next')[0].disabled = false
    } else {

        notify.innerText = "Confirm password dont match with password"
        notify.classList.remove('ok')
        document.getElementsByClassName('next')[0].disabled = true
    }
}
function checkPhone(event) {
    var input = event.target
    var notify = document.getElementById('alertphone')
    if (input.value.match(/\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/) !== null) {
        notify.innerText = "Pass"
        notify.classList.add('ok')
    } else {
        notify.innerText = "You cannot using this phong number"
        notify.classList.remove('ok')
    }
    checkInputPersionalDetails()
}
function checkDob(event) {
    var input = event.target
    console.log(input);
    var notify = document.getElementById('alertdob')
    if (input.value !== '') {
        notify.innerText = "Pass"
        notify.classList.add('ok')
    } else {
        notify.innerText = "You must choosing a date"
        notify.classList.remove('ok')
    }
    checkInputPersionalDetails()
}
function checkName(event) {
    var input = event.target
    var notify = document.getElementById('alertname')
    if (input.value !== '' && input.value.length > 5) {
        notify.innerText = "Pass"
        notify.classList.add('ok')
    } else {
        notify.innerText = "Your name is too short"
        notify.classList.remove('ok')
    }
    checkInputPersionalDetails()
}
function checkInputPersionalDetails() {
    var field = document.getElementsByTagName('fieldset')[1]
    var listlenght = field.getElementsByClassName('ok').length
    if (listlenght === 3) {
        field.getElementsByClassName('next')[0].disabled = false
        
    } else {
        field.getElementsByClassName('next')[0].disabled = true
    }

}


