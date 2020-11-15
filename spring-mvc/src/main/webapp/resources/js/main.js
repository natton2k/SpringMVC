function search(button) {
     let txtSearch = document.getElementsByName('searchValue')[0];
     let result = document.getElementById('result');
     let searchValue = txtSearch.value;
    if (searchValue !== '') {
        let url = './user/search-user?searchValue=' + searchValue;
        fetch(url, {
            method: 'GET'
        }).then(response => {
            const status = response.status;
            if (status === 200){
                response.json().then(data => {
                    renderRegistrationRows(data, result);
                });

            }
        })
        /*let req = new XMLHttpRequest();
        req.open('GET', './user/search-user?searchValue=' + searchValue, true);
        req.onreadystatechange = function () {
            if (req.readyState === 4 && req.status === 200) {
                 let users = JSON.parse(req.responseText);
                renderRegistrationRows(users, result);
            }
        }
        req.send();*/
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

function renderRegistrationRows(registrations, result){
    result.innerHTML = '';
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
                updateUser(e.target)
            }
            tr.appendChild(tdNo);
            tr.appendChild(tdUsername);
            tr.appendChild(tdPassword);
            tr.appendChild(tdLastname);
            tr.appendChild(tdAdmin);
            tr.appendChild(tdUpdate);
            table.appendChild(tr);
        }
        result.appendChild(table);
    } else {
        let noRecordsText = document.createElement('h2');
        noRecordsText.innerHTML = 'No records matched!!!';
        result.appendChild(noRecordsText);
    }

}

function updateUser(e){
    let tr = e.parentNode.parentNode;
    let username = tr.getElementsByClassName('lbl-username')[0];
    let password = tr.getElementsByClassName('txt-password')[0];
    let lastname = tr.getElementsByClassName('txt-lastname')[0];
    let role = tr.getElementsByClassName('chk-role')[0];
    let usernameVal = username.innerHTML;
    let passwordVal = password.value;
    let lastNameVal = lastname.value;
    let roleVal = role.checked;
    let param = {
        username: usernameVal,
        password: passwordVal,
        lastname: lastNameVal,
        admin: roleVal
    };
    const url = './user/';
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(param)
    }).then(response => {
        removeValidError(tr);
        let response_body = response.json();
        if (response.status === 200){
            response_body.then(data =>{
                alert(data.message);
            })
        } else if (response.status === 400){
            response_body.then(error =>{
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
            })
        } else if (response.status === 204){
            alert('User is not existed!!!');
        } else {
            console.log('Error: ');
        }
    })

    /*let req = new XMLHttpRequest();
    req.open('PUT','./user/', true);
    req.setRequestHeader('Content-Type', 'application/json');
    req.onreadystatechange = function (){
        if (req.readyState === XMLHttpRequest.DONE) {
            if (req.status === 200) {
                let res = JSON.parse(req.responseText);
                alert(res.message);
                removeValidError(tr);
                search()
            } else if (req.status === 400) {
                removeValidError(tr);

                let error = JSON.parse(req.responseText);
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
            } else if (req.status === 204) {
                alert('User is not existed!!!');
            } else {
                console.log('Error: ' + req.responseText);
            }
        }
    }
    req.send(JSON.stringify(param));*/
}

function removeValidError(tr){
    let passwordError = tr.getElementsByClassName('password-error');
    let lastnameError = tr.getElementsByClassName('lastname-error');
    for (let i = 0; i < passwordError.length; i++){
        passwordError[i].parentNode.removeChild(passwordError[i]);
    }
    for (let i = 0; i < lastnameError.length; i++){
        lastnameError[i].parentNode.removeChild(lastnameError[i]);
    }
}
