function getRegisterInformation(){
    const username = document.getElementById("txtUsername").value;
    const password = document.getElementById("txtPassword").value;
    const confirmPassword = document.getElementById("txtConfirmPassword").value;
    const lastname = document.getElementById("txtLastname").value;
    return  {
        username: username,
        password: password,
        confirmPassword: confirmPassword,
        lastname: lastname
    }
}
async function register(e) {
    const formField = getRegisterInformation();
    const url = './user/'
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(formField)
    })
    removeError();
    if (response.status === 200){
        location.replace("./");
    } else if (response.status === 400){
        const error = await response.json();
        displayRegisterError(error);
    } else {
        const responseData = await response.text();
        console.log('Error: ' + responseData);
    }
}

function displayError(elementId, errorMessage){
    if (errorMessage !== undefined){
        const errorElement = document.createElement('div');
        const row = document.getElementById(elementId);
        errorElement.innerHTML = errorMessage;
        errorElement.className = 'error';
        row.parentNode.appendChild(errorElement);
    }
}

function displayRegisterError(error) {
    displayError("usernameRow", error.errors.username);
    displayError("passwordRow", error.errors.password);
    displayError("confirmPassword", error.errors.ConfirmPasswordNotMatch);
    displayError("lastNameRow", error.errors.lastname);
}

function removeError() {
    const errorElements = document.getElementsByClassName("error");
    while (errorElements.length > 0){
        errorElements[0].parentNode.removeChild(errorElements[0]);
    }
}

