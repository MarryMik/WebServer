


const selectEl = document.getElementById('select'); 
const reqistrationImage = document.getElementById('main-contract');

//get the services
fetch('http://localhost:8080/webServer/CommandServices')
.then((response) => response.json())
.then((json) => {
	newOptions = json;
	console.log(newOptions);
	newOptions.forEach(option =>{
		return createNewOption(option.name)
	}) 
});

function createNewOption(name){
    let createdOption = document.createElement("option");
    createdOption.innerText = name;
    appendOption(createdOption);
}

function appendOption(option){
	selectEl.append(option);
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

const myForm =document.getElementById('request-form');
myForm.addEventListener('submit', function(e){
	e.preventDefault();

        const params = new URLSearchParams();
        params.append('name', document.getElementById('name').value);
        params.append('phone', document.getElementById('phone').value);
        params.append('selected', document.getElementById('select').value);
        const fetchSettings = {method: 'POST', body: params};
        fetch('http://localhost:8080/webServer/add_request', fetchSettings).then((response)=>response.json())
		 .then((json) => {
			newRequest = json;
			newRequest.forEach(h5 =>{
			return messageAlert(h5.id);
	})
	});;
 
      
  });

function messageAlert(id){
	alert("Вітаю, ваш номер в черзі: "+id);
}

