async function search(button) {
    let txtSearch = document.getElementsByName('searchValue')[0];
    let resultDiv = document.getElementById('result');
    let searchValue = txtSearch.value;
    if (searchValue !== '') {
        try {
            let url = './user/search-user?searchValue=' + searchValue;
            const response = await fetch(url);
            if (response.status === 200) {
                const messageBody = await response.json();
                renderRegistrationRows(messageBody, resultDiv);
            }
        } catch (err) {
            console.log(err);
        }
    }
}

function renderHeaderRegistrationRows(table) {
    let tr = document.createElement('tr');
    let thNo = document.createElement('th');
    let thUsername = document.createElement('th');
    //let thPassword = document.createElement('th');
    let thLastname = document.createElement('th');
    let thAdmin = document.createElement('th');
    let thUpdate = document.createElement('th');
    let thDelete = document.createElement('th');
    thNo.innerHTML = 'No';
    thUsername.innerHTML = 'Username';
    //thPassword.innerHTML = 'Password';
    thLastname.innerHTML = 'Last Name';
    thAdmin.innerHTML = 'Role';
    thUpdate.innerHTML = 'Update';
    thDelete.innerHTML = 'Delete';
    tr.appendChild(thNo);
    tr.appendChild(thUsername);
    //tr.appendChild(thPassword);
    tr.appendChild(thLastname);
    tr.appendChild(thAdmin);
    tr.appendChild(thUpdate);
    tr.appendChild(thDelete);
    table.appendChild(tr);
}

function renderRegistrationRows(registrations, resultDiv) {
    resultDiv.innerHTML = '';
    let table = document.createElement('table');
    table.setAttribute('border', 1);
    if (registrations != null && registrations.length !== 0) {
        renderHeaderRegistrationRows(table);
        for (let i = 0; i < registrations.length; i++) {
            let registration = registrations[i];
            let tr = document.createElement('tr');
            let tdNo = document.createElement('td');
            let tdUsername = document.createElement('td');
            //let tdPassword = document.createElement('td');
            let tdLastname = document.createElement('td');
            let tdAdmin = document.createElement('td');
            let tdUpdate = document.createElement('td');
            let tdDelete = document.createElement('td');
            tdNo.innerHTML = i + 1;
            tdUsername.innerHTML = '<a class="lbl-username">' +
                registration.username + '</a>';
            //tdPassword.innerHTML = '<input type="text" class="txt-password" value="' +
            //    registration.password + '" />';
            tdLastname.innerHTML = '<input type="text" class="txt-lastname" value="' +
                registration.lastname + '" />';
            tdAdmin.innerHTML = '<input type="checkbox" class="chk-role" ' +
                (registration.role ? 'checked' : '') + ' />';
            let btnUpdate = document.createElement('button');
            btnUpdate.innerHTML = 'Update';
            tdUpdate.appendChild(btnUpdate);
            btnUpdate.onclick = function (e) {
                let row = e.target.parentNode.parentNode;
                updateUserAtRow(row);
            }

            let deleteLink = document.createElement('a');
            deleteLink.setAttribute('href', '#');
            deleteLink.setAttribute('username', registration.username);
            deleteLink.innerHTML = 'X';
            deleteLink.onclick = function (e) {
                deleteUser(e.target);
            }
            tdDelete.appendChild(deleteLink);

            tr.appendChild(tdNo);
            tr.appendChild(tdUsername);
            //tr.appendChild(tdPassword);
            tr.appendChild(tdLastname);
            tr.appendChild(tdAdmin);
            tr.appendChild(tdUpdate);
            tr.appendChild(tdDelete);
            table.appendChild(tr);
        }
        resultDiv.appendChild(table);
    } else {
        let noRecordsText = document.createElement('h2');
        noRecordsText.innerHTML = 'No records matched!!!';
        resultDiv.appendChild(noRecordsText);
    }

}

function getUpdateInformationAtRow(row) {
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

function displayErrorAtRow(row, error) {
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

async function updateUserAtRow(row) {
    let param = getUpdateInformationAtRow(row);
    const url = './user/';
    try {
        const response = await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(param)
        });
        removeValidErrorAtRow(row);
        if (response.status === 200) {
            alert('Update successfully');
        } else if (response.status === 400) {
            const message = await response.json();
            displayErrorAtRow(row, message);
        } else if (response.status === 204) {
            alert('User does not existed');
        } else {
            const responseData = await response.text();
            console.log(responseData);
        }
    } catch (err) {
        console.log('Error');
    }
}

function removeValidErrorAtRow(row) {
    let passwordError = row.getElementsByClassName('password-error');
    let lastnameError = row.getElementsByClassName('lastname-error');
    for (let i = 0; i < passwordError.length; i++) {
        passwordError[i].parentNode.removeChild(passwordError[i]);
    }
    for (let i = 0; i < lastnameError.length; i++) {
        lastnameError[i].parentNode.removeChild(lastnameError[i]);
    }
}

async function deleteUser(e) {
    const username = e.getAttribute('username');
    const url = './user/?username=' + username;
    const response = await fetch(url, {
        method: 'DELETE'
    });
    if (response.status === 200){
        const body = await response.json();
        alert(body.message);
        search();
    } else {
        const responseData = await response.text();
        console.log('Error' + responseData);
    }
}




