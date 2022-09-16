"use strict";
  //////////////
 // SELECTORS//
//////////////
// DIVS

// INPUTS
let NameInput = document.querySelector("#NameInput");
let TypeInput = document.querySelector("#TypeInput");
let alcoholInput = document.querySelector("#alcoholInput");

// BUTTONS
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");

// FUNCTIONS
// Get ALL
let getAll = () => {
    axios.get("http://localhost:8080/customer/getAll")
    .then(res => {
        console.log(res.data);
    }).catch(err => console.log(err));
}

// Create
let create = () => {

    if(!validateInputs()){
        alert("All fields need values!!!");
        return
    }

    let obj = {
        "name": NameInput.value,
        "type": TypeInput.value,
        "alcohol": alcoholInput.value
    }

    axios.post("http://localhost:8080/customer/create", obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

// Update
let update = () => {

    let obj = {
        "name": "Velvet Cake",
        "type": "Stout",
        "alcohol": 6
    }

    axios.put("http://localhost:8080/customer/update/4", obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

// Deletelet getAll = () => {
let del = () => {
    axios.delete("http://localhost:8080/customer/delete/1")
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let validateInputs = () => {
    if (NameInput.value === "" || TypeInput.value === "" || alcoholInput.value === "") {
        return false;
    } else {
        return true;
    }
}

// EVENT LISTENERS
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);