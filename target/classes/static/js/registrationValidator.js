        function validation(){    
        	var email =  document.forms["registration"]["email"]; 
            var password = document.forms["registration"]["password"];    
            var passwordTwo = document.forms["registration"]["passwordSecond"];  
            var regx = /^(?:[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$/;
            var whiteSpace = /^\s+$/;
            
                if (email.value === ""){ 
                    text = "Adj meg egy email címet!";
                    document.getElementById("errorEmail").innerHTML = text;
                    return false; 
                } else if (!regx.test(email.value)){
                    text = "Valódi email címet adj meg!";
                    document.getElementById("errorEmail").innerHTML = text;
                    return false; 
                } else if (email.value.length > 60){
                	text = "Az email címed nem lehet 60 karakternél hosszabb!";
                	document.getElementById("errorEmail").innerHTML = text;
                	return false;
                }
            	
            	
            if (password.value === ""){ 
                text = "Adj meg egy jelszót!";
                document.getElementById("errorPassword").innerHTML = text;
                return false; 
            } else if (password.value.length < 6){ 
                text = "A jelszónak minimum 6 karakter hosszúnak kell lennie!";
                document.getElementById("errorPassword").innerHTML = text;
                return false; 
            } else if (password.value.length > 60){
            	text = "A jelszavad nem lehet 60 karakternél hosszabb!";
                document.getElementById("errorPassword").innerHTML = text;
                return false;
            } else if (password.value === email.value){ 
                text = "A jelszó nem egyezhet az email címeddel!";
                document.getElementById("errorPassword").innerHTML = text;
                return false; 
            } else if (whiteSpace.test(password.value)){
                text = "A jelszó nem állhat csak szóközökből!";
                document.getElementById("errorPassword").innerHTML = text;
                return false; 
            }
            
            if (passwordTwo.value === ""){ 
                text = "Írd be még egyszer a jelszavad!";
                document.getElementById("errorPasswordSecond").innerHTML = text;
                return false; 
            } else if (password.value !== passwordTwo.value){
                text = "A két jelszó nem egyezik!!";
                document.getElementById("errorPasswordSecond").innerHTML = text;
                return false; 
            }  
      
            return true; 
        }