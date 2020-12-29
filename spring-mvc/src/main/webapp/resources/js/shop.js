function getProducts(){
    let request = new XMLHttpRequest();
    request.open('GET', './api/v1/products', true);
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
    if (productList === undefined || productList.length === 0){
        let h2 = document.createElement("h2");
        h2.innerHTML = "Shop is out of order. Please come back again";
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
    const headers = ["ID", "Name", "Price", "Add to cart"];
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
        let btnAddToCart = document.createElement("button");
        btnAddToCart.innerHTML = "Add to cart";
        btnAddToCart.onclick = function (e){
            addToCart(product.id);
        }
        addElementToRowData(tr, btnAddToCart);
        tableElement.appendChild(tr);
    }

    function addToCart(id){

    }
}