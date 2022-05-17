
const selectEl = document.getElementById('select');
fetch('http://localhost:8080/webServer/CommandServices').then((response) => response.json()).then((json) => {
	newOptions = json;
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


const selectEl1 = document.getElementById('operator_phone');
fetch('http://localhost:8080/webServer/CommandOperators').then((response) => response.json()).then((json) => {
	newOptions = json;
	newOptions.forEach(option =>{
		return createNewOption1(option.phone)
	}) 
});

function createNewOption1(name){
	let createdOption = document.createElement("option");
	createdOption.innerText = name;
	appendOption1(createdOption);
}
function appendOption1(option){
	selectEl1.append(option);
}