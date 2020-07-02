function validation(){ 
            var name = document.forms["login"]["username"];               
            var password = document.forms["login"]["password"];    
            
            if (name.value === ""){ 
                text = "Add meg az email címed!";
                document.getElementById("errorUser").innerHTML = text;
                return false; 
            } else if (name.value.length > 60){
            	text = "Az email címed nem lehet 60 karakternél hosszabb!";
                document.getElementById("errorUser").innerHTML = text;
                return false; 
            }else if (password.value === ""){ 
                text = "Add meg a jelszavad!";
                document.getElementById("errorPassword").innerHTML = text; 
                return false; 
            }else if (password.value.length > 60){
            	text = "A jelszavad nem lehet 60 karakternél hosszabb!";
                document.getElementById("errorPassword").innerHTML = text;
                return false; 
            }
            return true; 
        }