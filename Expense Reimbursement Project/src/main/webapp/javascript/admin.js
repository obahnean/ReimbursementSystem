/**
 * 
 */
console.log("Hello from emp.js");

window.onload = function(){
	getUser();
	
	getReimbursements(4);
	
}

function getUser(){
	let xhttp = new XMLHttpRequest();
	
	
	xhttp.open("get","http://localhost:8003/Project1/getUser.json");
	
	xhttp.send();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let user = JSON.parse(xhttp.responseText);
			setUserOnPage(user.fname);
		}
		
		
	}

}
function setUserOnPage(user){
	document.getElementById('welcome').innerHTML = 'Welcome, ' + user;
}

function getReimbursements(value){
	let xhttp = new XMLHttpRequest();
	
	xhttp.open("get", "http://localhost:8003/Project1/getTix.json");
	
	xhttp.send();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let tixs = JSON.parse(xhttp.responseText);
			addToTable(tixs,value);
		}
	}
}

function filter(tickets,value){
	
	 
	var filtered = [];
	

	if(value == 4)
		return tickets;
	
	for(var i= 0;i<tickets.length;i++){
		
		if(tickets[i].status === value){
			console.log(tickets[i]['status']);
			filtered.push(tickets[i]);
		}
			
	}
		
	return filtered	
}

function deleteRows(id){
	var obj = document.getElementById(id);
	if(!obj && obj.rows)
		return;
	var rows = obj.rows;
	if(rows.length < 0)
		return;
	for(;rows.length>0;){
		obj.deleteRow(0)
	}
}

function resetTable(){
	var a = document.getElementById("fil");
	var result = a.options[a.selectedIndex].value;
	
	
	
	deleteRows('reimbs');
	
	switch(result){
	case '1' :
		getReimbursements(1);
		break;
	case '2' :
		getReimbursements(2);
		break;
	case '3' :
		getReimbursements(3);
		break;
	case '4' :
		getReimbursements(4);
		break;
	}
	
	
}

function addToTable(tickets,len){
	let filtered = filter(tickets ,len);
	for(var f=0; f<filtered.length;f++){
		console.log(filtered[f]);
		let tr = document.createElement("tr");
		tr.scope = 'row';
		
		let td1 = document.createElement("td")	
		let td2 = document.createElement("td")	
		let td3 = document.createElement("td")	
		let td4 = document.createElement("td")	
		let td5 = document.createElement("td")
		let td6 = document.createElement("td")
		let td7 = document.createElement("td")	
		let td8 = document.createElement("td")	
		let td9 = document.createElement("td")	
		
		
		let node1 = document.createTextNode(filtered[f]["id"]);
		let node2 = document.createTextNode(filtered[f]['ammount']);
		let node3 = document.createTextNode(filtered[f]['submit']);
		let node4 = document.createTextNode(filtered[f]['resolved']);
		let node5 = document.createTextNode(filtered[f]['description']);
		let node6 = document.createTextNode(filtered[f]['owner']);
		let node7 = document.createTextNode(filtered[f]['resolver']);
		let node8 = document.createTextNode(filtered[f]['status'])
		let node9 = document.createTextNode(filtered[f]['reimb_type'])	
		
		td1.appendChild(node1);
		td2.appendChild(node2);
		td3.appendChild(node3);
		td4.appendChild(node4);
		td5.appendChild(node5);
		td6.appendChild(node6);
		td7.appendChild(node7);
		td8.appendChild(node8);
		td9.appendChild(node9);
			
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		tr.appendChild(td8);
		tr.appendChild(td9);
		
		let element = document.getElementById("reimbs");
		element.appendChild(tr);
	}	
	
}

function openForm() {
	  document.getElementById("myForm").style.display = "block";
	}

function closeForm() {
	  document.getElementById("myForm").style.display = "none";
	}

