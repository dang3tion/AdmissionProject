// data
let suggestions=[];

// getting all required elements
const searchWrapper = document.querySelector(".search-input");
const inputBox = searchWrapper.querySelector("#search");
const suggBox = searchWrapper.querySelector(".autocom-box");
const icon = searchWrapper.querySelector(".icon");
let linkTag = searchWrapper.querySelector("a");
let webLink;

// if user press any key and release
inputBox.onkeyup = (e)=>{
    let userData = e.target.value; //user enetered data
    $.ajax({
    	url:"college-list?search-method=ajax",
    	method: "GET",
		data: {text: userData},
		success: function(data){
			suggestions = JSON.parse(data);
		    let emptyArray = [];
		    if(userData){
		        icon.onclick = ()=>{
		            webLink = "https://www.google.com/search?q=" + userData;
		            linkTag.setAttribute("href", webLink);
		            console.log(webLink);
		            linkTag.click();
		        }
				
		        emptyArray = suggestions.map((data)=>{
		            // passing return data inside li tag
		            return data = '<li>'+ data.name +'</li>';
		        });
		        searchWrapper.classList.add("active"); //show autocomplete box
		        showSuggestions(emptyArray);
		        let allList = suggBox.querySelectorAll("li");
		        for (let i = 0; i < allList.length; i++) {
		            //adding onclick attribute in all li tag
		            allList[i].setAttribute("onclick", "select(this)");
		        }
		    }else{
		        searchWrapper.classList.remove("active"); //hide autocomplete box
		    }
		}    	
    })
}

function select(element){
    let selectData = element.textContent;
    inputBox.value = selectData;
    icon.onclick = ()=>{
        webLink = "https://www.google.com/search?q=" + selectData;
        linkTag.setAttribute("href", webLink);
        linkTag.click();
    }
    searchWrapper.classList.remove("active");
}

function showSuggestions(list){
    let listData;
    if(!list.length){
        userValue = inputBox.value;
        listData = '<li>'+ userValue +'</li>';
    }else{
        listData = list.join('');
    }
    suggBox.innerHTML = listData;
}