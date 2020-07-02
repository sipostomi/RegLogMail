function validation(){    
	var fName = document.forms["contactMessage"]["fullName"];
	var subject =  document.forms["contactMessage"]["subject"]; 
    var message = document.forms["contactMessage"]["messageText"];  
    var whiteSpace = /^\s+$/;
    
    if ( fName.value == ""){
    	 text = "Adja meg a nevét!";
         document.getElementById("errorName").innerHTML = text;
         return false; 
    } else if (whiteSpace.test(fName.value)){
        text = "A neved nem állhat csak szóközekből!";
        document.getElementById("errorName").innerHTML = text;
        return false; 
    } else if (fName.value.length > 60){
	   	 text = "A neved nem lehet 60 karakternél hosszabb!";
	     document.getElementById("errorName").innerHTML = text;
	     return false;
    }
    
    
    
    
    if (subject.value === ""){ 
        text = "Add meg az üzenet tárgyát!";
        document.getElementById("errorSubject").innerHTML = text;
        return false; 
    }else if (whiteSpace.test(subject.value)){
        text = "A tárgy nem állhat csak szóközekből!";
        document.getElementById("errorSubject").innerHTML = text;
        return false; 
    } else if (subject.value.length > 60){
    	 text = "A tárgy nem lehet 60 karakternél hosszabb!";
         document.getElementById("errorSubject").innerHTML = text;
         return false;
    }
    
    if (message.value === ""){ 
        text = "Add meg az üzenetet!";
        document.getElementById("errorMessage").innerHTML = text;
        return false; 
    }else if (whiteSpace.test(message.value)){
        text = "Az üzenet nem állhat csak szóközekből!";
        document.getElementById("errorMessage").innerHTML = text;
        return false; 
    } else if (message.value.length > 120){
    	 text = "Az üzenet nem lehet 120 karakternél hosszabb!";
         document.getElementById("errorMessage").innerHTML = text;
         return false;
    }
    
    return true;


}