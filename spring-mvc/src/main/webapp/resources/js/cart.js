function getCart(){
    let request = new XMLHttpRequest();
    request.open('GET', './api/v1/shoppingCart', true);
    request.onreadystatechange = function (){
        if (request.readyState === XMLHttpRequest.DONE){
            if (request.status === 200){
                let productList = JSON.parse(request.responseText);
                renderTable(productList);
            } else {
                console.log("Error " + request.status);
            }
        }
    }
    request.send();
}

function renderTable(productList){
    let mainFrame = document.getElementById("mainFrame");
    mainFrame.innerHTML = "";
    if (productList === undefined || productList.length === 0){
        let h2 = document.createElement("h2");
        h2.innerHTML = "No item in your cart";
        mainFrame.appendChild(h2);
        return;
    }
    let tableElement = document.createElement("table");
    mainFrame.appendChild(tableElement);
    tableElement.setAttribute("border", 1);
    renderTableHeaders(tableElement);
    renderTableRows(tableElement, productList);
}

function renderTableHeaders(tableElement){
    const headers = ["ID", "Name", "Price", "Quantity", "Remove item(s)"];
    let tr = document.createElement("tr");
    tableElement.appendChild(tr);
    for (let i = 0; i < headers.length; i++){
        let th = document.createElement("th");
        th.innerHTML = headers[i];
        tr.appendChild(th);
    }
}

function renderRowData(rowElement, value){
    let td = document.createElement("td");
    td.innerHTML = value;
    rowElement.appendChild(td);
}

function addElementToRowData(rowElement, element){
    let td = document.createElement("td");
    td.appendChild(element);
    rowElement.appendChild(td);
}

function renderTableRows(tableElement, productList){
    for (let i=0; i< productList.length; i++){
        let product = productList[i];
        let tr = document.createElement("tr");
        renderRowData(tr, product.id);
        renderRowData(tr, product.name);
        renderRowData(tr, product.price);
        renderRowData(tr, product.quantity);
        let btnRemove = document.createElement("button");
        btnRemove.innerHTML = "Remove";
        btnRemove.onclick = function (e){
            removeProductInCart(product.id);
        }
        addElementToRowData(tr, btnRemove);
        tableElement.appendChild(tr);
    }
}

function removeProductInCart(id){
    let request = new XMLHttpRequest();
    request.open('DELETE', './api/v1/shoppingCart/products/'+id, true);
    request.onreadystatechange = function (){
        if (request.readyState === XMLHttpRequest.DONE){
            if (request.status === 200){
                getCart();
            } else {
                console.log("Error " + request.status);
            }
        }
    }
    request.send();
}