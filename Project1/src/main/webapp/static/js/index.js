window.onload = function() {
    addNavBar();
    
    console.log("hi");
	document.getElementById("viewbtn").addEventListener("click",viewForms);
}

function viewForms() {
    window.location.href="http://localhost:8080/TuitionReimbursement/static/viewforms.html";
}
