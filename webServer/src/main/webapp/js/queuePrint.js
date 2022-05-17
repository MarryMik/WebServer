
const divRequests = document.getElementById('requests');
let divIdCounter=0;
//print the queue

const h4Name = document.getElementById('application-wrapper1');
//let newButton =document.getElementsByClassName("form-submit-button");
//document.getElementsByClassName("form-submit-button").style.margin = "0px 0px 30px 0px";
console.log(h4Name);
document.getElementById('nextButton').style.visibility="hidden";
document.getElementById('nextButton').style.margin = "0px 0px 30px 0px";



       function postName() {
        const params = new URLSearchParams();
        params.append('user_phone', document.getElementById('userPhone').value);

        const fetchSettings = {method: 'POST', body: params};
        
         fetch('http://localhost:8080/webServer/request_by_operator', fetchSettings)
         .then((response)=>response.json())
		 .then((json) => {
			newH4 = json;
			newH4.forEach(h4 =>{
			createNewDiv();	
			document.getElementById('newButton').style.visibility="hidden";
			document.getElementById('nextButton').style.visibility="visible";
			return createNewH4s(h4.client.name+" "+h4.client.phone,h4.service.name,h4.status);
	})
	});


      }
      
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


//next request -> close and handle
function closeTicket(){
	 const params = new URLSearchParams();
        params.append('phone', document.getElementById('userPhone').value);
        const fetchSettings = {method: 'POST', body: params};
fetch('http://localhost:8080/webServer/close_Request', fetchSettings);
nextTicket();
}

function nextTicket(){
	 const params = new URLSearchParams();
        params.append('phone', document.getElementById('userPhone').value);
        const fetchSettings = {method: 'POST', body: params};
         fetch('http://localhost:8080/webServer/requestToOperator', fetchSettings);
}



fetch('http://localhost:8080/webServer/get_requests')
.then((response) => response.json())
.then((json) => {
	newOptions = json;
	console.log(newOptions);
});
fetch('http://localhost:8080/webServer/CommandOperators')
.then((response) => response.json())
.then((json) => {
	newOptions = json;
	console.log(newOptions);
});