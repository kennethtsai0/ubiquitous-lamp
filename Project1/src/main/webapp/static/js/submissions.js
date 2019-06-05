window.onload = function () {
	addNavBar();
	console.log("hi");
	document.getElementById("submitbtn").addEventListener("click", submit);
	// document.getElementById("backbtn").onclick=;
}

function addSubmission() {
	var formData = {
		'empid': employee.id, 'event': document.getElementById('f_eventType').value, 'date': document.getElementById('f_date').value, 'location': document.getElementById('f_location').value,
		'description': document.getElementById('f_description').value, 'cost': document.getElementById('f_cost').value,
		'reasoning': document.getElementById('f_reasoning').value, 'grade': null, 'status': document.getElementById('f_eventType').value, 'hierarchy': hier
	};
	console.log("hi2");
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = moveToViewForms;
	xhttp.open("POST", "http://localhost:8080/TuitionReimbursement/form");
	xhttp.send(JSON.stringify(formData));
	console.log("hi3");
	// xhttp.send("user="+user+"&pass="+pass);
	function moveToViewForms() {
		if (xhttp.readyState === 4)
			viewForms();
	}
}

function checkEnter() {
	if (event.which === 13) {
		submit();
	}
}

function submit() {
	addSubmission();
}

function viewForms() {
    window.location.href="http://localhost:8080/TuitionReimbursement/static/viewforms.html";
}