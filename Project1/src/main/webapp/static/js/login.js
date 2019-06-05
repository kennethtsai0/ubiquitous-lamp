var employee=null;
var supa;
var emptype;
var hier;

var navbar = `
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand">
			<span class="badge-primary">Tuition Reimbursement</span>
		</a>
		<ul class="navbar-nav mr-auto" id="authent">
		</ul>
	</nav>`;
var unauthenticated = `
	<li class="nav-item">
		Username: <input type="text" id="username">
	</li>
	<li class="nav-item">
		Password: <input type="password" id="password">
	</li>
	<li class="nav-item">
		<button class="btn btn-primary" id="login">Login</button>
	</li>
	`;
var authenticated = `
	<li class="nav-item">
		Welcome <span id="authUserName"></span> 
	</li>
	<li class="nav-item">
		<button class="btn btn-danger" id="logout">Logout</button>
	</li>`;

function addNavBar(){
	let div = document.createElement("div");
	div.innerHTML=navbar;
	let body = document.getElementsByTagName("body")[0];
	body.insertBefore(div,body.childNodes[0]);
	
	document.getElementById("authent").innerHTML=unauthenticated;
	//add event listeners
	document.getElementById("login").addEventListener("click",authenticate);
	document.getElementById("password").onkeydown=checkPasswordEnter;
	// authenticate();
}

function checkPasswordEnter(){
	if(event.which===13)
		authenticate();
}

function authenticate() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange=loginSuccess;
	xhttp.open("POST", "http://localhost:8080/TuitionReimbursement/login");
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	xhttp.send("user="+user+"&pass="+pass);
	console.log(user+pass);
	function loginSuccess() {
		if(xhttp.readyState===4 && xhttp.status===200) {
			var data = JSON.parse(xhttp.responseText);
			employee=data.employee;
			supa = employee.reportsto;
			setHierarchy();
			document.getElementById("authent").innerHTML=authenticated;
			document.getElementById("logout").addEventListener("click",logout);
			document.getElementById("authUserName").innerHTML=employee.firstname+" "+employee.lastname+", "+employee.title;
		}
	}
}

function logout() {
	console.log("logging out");
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=finish;
	xhttp.open("DELETE", "http://localhost:8080/TuitionReimbursement/login");
	setEmpNull();
	xhttp.send();
	function finish(){
		if(xhttp.readyState===4){
			document.getElementById("authent").innerHTML=unauthenticated;
			document.getElementById("login").addEventListener("click",authenticate);
			document.getElementById("password").onkeydown=checkPasswordEnter;
		}
	}
}

function checkEmpType(){
	switch(emptype) {
		case 3:
			break;
	}
}

function setEmpNull(){
	employee = null;
	emptype = null;
}

function setHierarchy() {
	if (employee.reportsto == 3) {
		hier = 4;
	}
	else if (employee.reportsto == 2) {
		hier = 3;
	}
	else if (employee.reportsto == 1) {
		hier = 2;
	}
	else if (employee.reportsto == 0) {
		hier = 1;
	}
	else hier = 0;
}

// function authenticate() {
// 	var xhttp = new XMLHttpRequest();
// 	xhttp.onreadystatechange=loginSuccess;
// 	xhttp.open("POST", baseURL+"login");
// 	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
// 	let user = document.getElementById("username").value;
// 	//console.log(user);
// 	let pass = document.getElementById("password").value;
// 	xhttp.send("user="+user+"&pass="+pass);
// 	function loginSuccess() {
// 		if(xhttp.readyState===4 && xhttp.status===200) {
// 			var data = JSON.parse(xhttp.responseText);
// 			employee=data.employee;
// 			customer=data.customer;
// 			document.getElementById("authent").innerHTML=authenticated;
// 			document.getElementById("logout").addEventListener("click",logout);
// 			if(customer) {
// 				document.getElementById("authUserName").innerHTML=customer.first+" "+customer.last;
// 			}
// 			if(employee) {
// 				document.getElementById("authUserName").innerHTML=employee.first+" "+employee.last+", "+employee.title;
// 				let btns = document.getElementsByClassName("emp-btn");
// 				for(let i=0; i<btns.length; i++){
// 					btns[i].disabled=false;
// 				}
// 			}
// 		}
// 	}
// }

// let btns = document.getElementsByClassName("emp-btn");
			// for(let i=0; i<btns.length; i++){
			// 	btns[i].disabled=false;
			// }