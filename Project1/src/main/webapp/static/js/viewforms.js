window.onload = function () {
    addNavBar();
    // getSubmissions();
}
function getSubmissions() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = displayForms;
    xhttp.open("GET", "form");
    xhttp.send();
    function displayForms() {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            forms = JSON.parse(xhttp.responseText);
            console.log(forms);
            forms.forEach(function (form) {
                addFormToTable(form);
            });
        }
    }
}

function addFormToTable(form) {
    var table = document.getElementById("forms");
    var tr = document.createElement("tr");
    let td;
    //id
    addTableDef(form.id, tr);
    // cover
    td = document.createElement("td");
    tr.appendChild(td);
    addTableDef(form.idemp, tr);
    addTableDef(form.idevent, tr);
    addTableDef(form.date, tr);
    addTableDef(form.location, tr);
    addTableDef(form.description, tr);
    addTableDef(form.cost, tr);
    addTableDef(form.justification, tr);
    addTableDef(form.grade, tr);
    addTableDef(form.status, tr);
    addTableDef(form.hierarchy, tr);
    table.appendChild(tr);
}

function addTableDef(value, tr) {
    let td = document.createElement("td");
    td.innerHTML = value;
    tr.appendChild(td);
}

function editform(){
    var btn = event.target;
    console.log(btn);
    console.log(btn.id);
    var id = btn.id.substring("e_f_".length);
    console.log(id);
    window.location.href="editBook/"+id;
}

