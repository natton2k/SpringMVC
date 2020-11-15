function search(button) {
    let txtSearch = document.getElementsByName('searchValue')[0];
    let resultDiv = document.getElementById('result');
    let searchValue = txtSearch.value;
    if (searchValue !== '') {
        let url = './user/search-user?searchValue=' + searchValue;
        fetch(url, {
            method: 'GET'
        }).then(response => {
            const status = response.status;
            if (status === 200){
                response.json().then(data => {
                    renderRegistrationRows(data, resultDiv);
                });
            }
        })
    }
}
function renderHeaderRegistrationRows(table){
    let tr = document.createElement('tr');
    let thNo = document.createElement('th');
    let thUsername = document.createElement('th');
    let thPassword = document.createElement('th');
    let thLastname = document.createElement('th');
    let thAdmin = document.createElement('th');
    let thUpdate = document.createElement('th');
    thNo.innerHTML = 'No';
    thUsername.innerHTML = 'Username';
    thPassword.innerHTML = 'Password';
    thLastname.innerHTML = 'Last Name';
    thAdmin.innerHTML = 'Role';
    thUpdate.innerHTML = 'Update';
    tr.appendChild(thNo);
    tr.appendChild(thUsername);
    tr.appendChild(thPassword);
    tr.appendChild(thLastname);
    tr.appendChild(thAdmin);
    tr.appendChild(thUpdate);
    table.appendChild(tr);
}

function renderRegistrationRows(registrations, resultDiv){
    resultDiv.innerHTML = '';
    let table = document.createElement('table');
    table.setAttribute('border',1);
    if (registrations != null && registrations.length !== 0){
        renderHeaderRegistrationRows(table);
        for (let i=0; i<registrations.length; i++){
            let registration = registrations[i];
            let tr = document.createElement('tr');
            let tdNo = document.createElement('td');
            let tdUsername = document.createElement('td');
            let tdPassword = document.createElement('td');
            let tdLastname = document.createElement('td');
            let tdAdmin = document.createElement('td');
            let tdUpdate = document.createElement('td');
            tdNo.innerHTML = i + 1;
            tdUsername.innerHTML = '<a class="lbl-username">' +
                registration.username + '</a>';
            tdPassword.innerHTML = '<input type="text" class="txt-password" value="'+
                registration.password + '" />';
            tdLastname.innerHTML = '<input type="text" class="txt-lastname" value="'+
                registration.lastname + '" />';
            tdAdmin.innerHTML = '<input type="checkbox" class="chk-role" ' +
                (registration.admin ? 'checked' : '') + ' />';
            let btnUpdate = document.createElement('button');
            btnUpdate.innerHTML = 'Update';
            tdUpdate.appendChild(btnUpdate);
            btnUpdate.onclick = function (e){
                let row = e.target.parentNode.parentNode;
                updateUserAtRow(row);
            }
            tr.appendChild(tdNo);
            tr.appendChild(tdUsername);
            tr.appendChild(tdPassword);
            tr.appendChild(tdLastname);
            tr.appendChild(tdAdmin);
            tr.appendChild(tdUpdate);
            table.appendChild(tr);
        }
        resultDiv.appendChild(table);
    } else {
        let noRecordsText = document.createElement('h2');
        noRecordsText.innerHTML = 'No records matched!!!';
        resultDiv.appendChild(noRecordsText);
    }

}

function getUpdateInformationAtRow(row){
    let username = row.getElementsByClassName('lbl-username')[0];
    let password = row.getElementsByClassName('txt-password')[0];
    let lastname = row.getElementsByClassName('txt-lastname')[0];
    let role = row.getElementsByClassName('chk-role')[0];
    let usernameVal = username.innerHTML;
    let passwordVal = password.value;
    let lastNameVal = lastname.value;
    let roleVal = role.checked;
    return {
        username: usernameVal,
        password: passwordVal,
        lastname: lastNameVal,
        admin: roleVal
    };
}

function displayErrorAtRow(row, error){
    let password = row.getElementsByClassName('txt-password')[0];
    let lastname = row.getElementsByClassName('txt-lastname')[0];
    if (error.errors.password !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.password;
        err.className = 'password-error';
        password.parentNode.appendChild(err);
    }

    if (error.errors.lastname !== undefined) {
        let err = document.createElement('div');
        err.innerHTML = error.errors.lastname;
        err.className = 'lastname-error';
        lastname.parentNode.appendChild(err);
    }

}
function updateUserAtRow(row){
    let param = getUpdateInformationAtRow(row);
    const url = './user/';
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(param)
    }).then(response => {
        removeValidErrorAtRow(row);
        let response_body = response.json();
        if (response.status === 200){
            response_body.then(data =>{
                alert(data.message);
            })
        } else if (response.status === 400){
            response_body.then(error =>{
                displayErrorAtRow(row, error);
            })
        } else if (response.status === 204){
            alert('User is not existed!!!');
        } else {
            console.log('Error');
        }
    })
}

function removeValidErrorAtRow(row){
    let passwordError = row.getElementsByClassName('password-error');
    let lastnameError = row.getElementsByClassName('lastname-error');
    for (let i = 0; i < passwordError.length; i++){
        passwordError[i].parentNode.removeChild(passwordError[i]);
    }
    for (let i = 0; i < lastnameError.length; i++){
        lastnameError[i].parentNode.removeChild(lastnameError[i]);
    }
}
