
const divRequests = document.getElementById('requests');
let divIdCounter=0;
//print the queue
fetch('http://localhost:8080/webServer/get_requests')
.then((responce)=>responce.json())
.then((json) => {
	newH4 = json;
	console.log(newH4);
	
	newH4.forEach(h4 =>{
		createNewDiv();
		console.log(h4.id+" "+h4.service.name+" "+h4.status);
		return createNewH4s(h4.id, h4.service.name, h4.status)
	})
});

function createNewDiv(){
	divIdCounter++;
	let createdDiv = document.createElement("div");
	createdDiv.className="application-wrapper";
	createdDiv.id="application-wrapper"+divIdCounter;
	console.log("id:" +createdDiv.id);
	appendDiv(createdDiv);
}
function appendDiv(div){
	divRequests.append(div);
}


function createNewH4s(id, service, status){
	
	let createdH4id= document.createElement("h4");
	createdH4id.className="application-data";
	createdH4id.id="id-application";
	createdH4id.innerText=id;
	
	let createdH4service = document.createElement("h4");
	createdH4service.className="application-data";
	createdH4service.id="type-application";
	createdH4service.innerText=service;
	
	let createdH4status = document.createElement("h4");
	createdH4status.className="application-data";
	createdH4status.id="status-application";
	createdH4status.innerText=status;
	appendH4(createdH4id, createdH4service, createdH4status);
}

function appendH4(id, service, status){
	let divRequest = document.getElementById('application-wrapper'+divIdCounter);
	divRequest.append(id);
	divRequest.append(service);
	divRequest.append(status);
}



