console.log("Hello");

window.onload = function (){
	//document
	//	.getElementById('myButton')
	//	.addEventListener('click', demoFunc);
	getUser();
}

function getUser(){
	//console.log("get sw is working!");
	
		
	
	//STEP 1: create the XMLHttpRequest object
	//this object allows us to make requests and get back data.
	// in short, this is our data retriever (it calls an API)
	let xhttp = new XMLHttpRequest();
	
	/*
	 * READY STATE
	 * 		State 0: not initialized
	 * 		State 1: server connection established
	 * 		State 2: request received
	 * 		State 3: processing request
	 * 		State 4: complete, request finish and response is ready
	 */
	
	//STEP 2: create the callback function for readystate changes
	xhttp.onreadystatechange = function (){
		//console.log("ready state is changing! "+xhttp.readyState);
		
		if(xhttp.readyState==4 && xhttp.status==200){
			//console.log("state 4!");
			
			//this parse function turns a JSON into a javascript object
			let sw = JSON.parse(xhttp.responseText);
			
			console.log(sw);
			
			populateUser(sw);
		}
	}
	
	//STEP 3: create and open a connection
	//xhttp.open(http method, url)
	xhttp.open("GET", 'http://localhost:8080/Project1/demo.json');
	
	//STEP 4: send the request
	xhttp.send();
	
}


function populateUser(data){
	document.getElementById('namespace').innerHTML = data.fname;
	
}


