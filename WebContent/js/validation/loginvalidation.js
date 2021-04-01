	$(function(){
		$("#loginform").submit(function(){
			
			$(".error").html("*")
			
			flag = true;
			
			var userType = $("#userType").val()
			var emailId = $("#emailId").val()
			var password = $("#password").val()
			if(userType=="")
			{
				 $("#euserType").html("*<br/>Please Select User Type.");
				 return  false;
			}
			if(emailId=="")
			{
				 $("#eemailId").html("*<br/>Please Enter Email Id");
				 flag = false;
			}
			if(password=="")
			{
				 $("#epassword").html("*<br/>Please Enter Password");
				 flag = false;
			}
			return flag;
		});
		
		$("#userType").blur(function(){
			$("#euserType").html("*");
			var userType =$(this).val();
			if(userType=="")
			{
				 $("#euserType").html("*<br/>Please Select User Type.");
				 return  false;
			}
		});
		
		
		$("#emailId").blur(function(){
			$("#eemailId").html("*");
			var emailId = $(this).val()
			if(emailId!="")
			{
				pattern = new RegExp("^[a-z]+[a-z0-9._]*@[a-z0-9]{2,}\.[a-z]{2,}$");
				if(!pattern.test(emailId))
				{
					 $("#eemailId").html("*<br/>Please Enter valid email Id Email Id");
					 flag = false;
				}
			}
			else
			{
				 $("#eemailId").html("*<br/>Please Enter Email Id");
				 flag = false;	
			}
			
		});
		
	});