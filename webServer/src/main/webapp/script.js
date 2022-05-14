
alert('It works')

const selectEl = document.getElementById('select'); 
const reqistrationImage = document.getElementById('main-contract');
// registrationImage.src="./assets/img/Contract2.svg";

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
