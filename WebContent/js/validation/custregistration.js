	
function reSetForm()
{
	var elements = document.getElementsByClassName("error");
	for (var i = 0; i < elements.length; i++) 
	{
		elements[i].innerHTML="*";
	}
}
	
	function validate()
	{
		reSetForm()
		
		
		fields = document.getElementsByClassName('valid');
		for (var i = 0; i < fields.length; i++) 
		{
			if(fields[i].value=="")
			{
				fields[i].nextSibling.innerHTML = "<br/>Please Fill The Field";
				return false;
			}
			else if(fields[i].value!="" && fields[i].name=="custEmailId")
			{
				pattern = new RegExp("^[a-z]+[0-9._]*@[a-z0-9]+\.+[a-z]{2,}$")
				if(!pattern.test(fields[i].value))
				{
					fields[i].nextSibling.innerHTML = "<br/>Please Enter Valid  Email Id";
					return false;
				}
			}
			else if(fields[i].value!="" && fields[i].name=="custMobileNo")
			{
				pattern = new RegExp("^[9,8,7]{1}[0-9]{9}$")
				if(!pattern.test(fields[i].value))
				{
					fields[i].nextSibling.innerHTML = "<br/>Please Enter Valid  Mobile Number";
					return false;
				}
			}
			
			
			
		}
		return true;
		
	}

	function validateOnBlur(element)
	{
		reSetForm();
		if(element.value=="")
		{
			element.nextSibling.innerHTML="<br/>Please Fill The Field."	
		}
	}
	
	function isPasswordMatch(element) 
	{
		password = document.getElementById("custPassword").value;
		if(element.value=="")
		{
			element.nextSibling.innerHTML="<br/>Please Enter same password.";
			return false;
		}
		else if(element.value == password)
		{
			element.nextSibling.innerHTML="<br/>Confirm Password is Match.";
			element.nextSibling.style.color="green"
			element.style.borderColor="black"
			return false;
		}
		else if(element.value != password)
		{
			element.nextSibling.innerHTML="<br/>Confirm Password does not Match.";
			element.nextSibling.style.color="red"
			element.style.borderColor="red"
			return false;
		}
	}
	
