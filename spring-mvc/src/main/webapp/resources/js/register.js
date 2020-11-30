function register(e) {
    var username = document.getElementById("txtUsername").value;
    var password = document.getElementById("txtPassword").value;
    var confirmPassword = document.getElementById("txtConfirmPassword").value;
    var lastname = document.getElementById("txtLastname").value;
    var formField = {
        username: username,
        password: password,
        confirmPassword: confirmPassword,
        lastname: lastname
    }
    var request = new XMLHttpRequest();
    request.open('POST', './user/', true);
    request.setRequestHeader('Content-Type', 'application/json');
    request.onreadystatechange = function () {
        if (request.readyState === XMLHttpRequest.DONE) {
            if (request.status === 200) {
                removeError();
                location.replace("./");
            } else if (request.status === 400) {
                var error = JSON.parse(request.responseText);
                removeError();
                displayRegisterError(error);
                } else {
                console.log('Error: ' + request.responseText);
            }
        }
    }
    request.send(JSON.stringify(formField));
}

function displayRegisterError(error) {
    var usernameRow = document.getElementById("usernameRow");
    var passwordRow = document.getElementById("passwordRow");
    var confirmPasswordRow = document.getElementById("confirmPassword");
    var lastNameRow = document.getElementById("lastNameRow");
    if (error.errors.username !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.username;
        err.className = 'error';
        usernameRow.parentNode.appendChild(err);
    }

    if (error.errors.password !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.password;
        err.className = 'error';
        passwordRow.parentNode.appendChild(err);
    }

    /*if (error.errors.confirmPassword !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.confirmPassword;
        err.className = 'error';
        confirmPasswordRow.parentNode.appendChild(err);
    }*/
    if (error.errors.ConfirmPasswordNotMatch !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.ConfirmPasswordNotMatch;
        err.className = 'error';
        confirmPasswordRow.parentNode.appendChild(err);
    }

    if (error.errors.lastname !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.lastname;
        err.className = 'error';
        lastNameRow.parentNode.appendChild(err);
    }
}

function removeError() {
    var errorElements = document.getElementsByClassName("error");
    while (errorElements.length > 0){
        errorElements[0].parentNode.removeChild(errorElements[0]);
    }
}

