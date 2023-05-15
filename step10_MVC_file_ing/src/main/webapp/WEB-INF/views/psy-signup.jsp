<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html>
<head>
<title>Signup</title>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>SignupTest</title>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
<link href='https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css' rel='stylesheet'>

<style>::-webkit-scrollbar {
  width: 8px;
}
/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #888; 
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555; 
} body{background: #F6F6F6}.card{border: none;height: 500px}.forms-inputs{position: relative}
						.forms-inputs span{position: absolute;top:-18px;left: 10px;background-color: #fff;padding: 5px 10px;font-size: 15px}
						.forms-inputs input{height: 50px;border: 2px solid #eee}
						.forms-inputs input:focus{box-shadow: none;outline: none;border: 2px solid #000}.btn{height: 50px}
						.success-data{display: flex;flex-direction: column}
						.bxs-badge-check{font-size: 90px}
</style>

</head>
<body>
<div class="container mt-5">
   <div class="row d-flex justify-content-center">
        <div class="col-md-6">
            <div class="card px-5 py-5" id="form1">
            
               <form action="/signup" method="POST" enctype="multipart/form-data">
                
                    <div class="forms-inputs mb-4">
                    	<span>Id</span>
                    	<input id = "email_address" name = "email_address" type = "text" class ="form-control">
                        <span id="mem_idMsg" style="font-size:8pt;"></span>
                    </div>
                    
                    <div class="forms-inputs mb-4">
                    	<span>Name</span>
                    	<input id = "mem_name" name = "mem_name" type = "text" class = "form-control">
                        <div class="invalid-feedback">성함을 기입해주세요.</div>
                    </div> 
                    
                    <div class="forms-inputs mb-4">
                    	<span>Password</span>
                    	<input id = "password" name = "password" type = "password" class = "form-control" >
                        <div class="invalid-feedback">비밀번호는 5자 이상이어야 합니다.</div>
                    </div>
                    
                    <div class="mb-3"> <button type = "reset" class="btn text-white w-100" style="background-color: #D5D5D5;">다시작성</button> </div>            
                    <div class="mb-3"> <button type = "submit" class="btn text-white w-100" style="background-color: #5CB85C;" >회원가입</button> </div>
                
                
                </form>
              </div>
                     
            </div>
        </div>
    </div>
</div>
             <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
             
             
<!--          <script type='text/javascript'>
             
	         	const inputEmail = document.getElementById('email_address');
	        	const emailMsg = document.getElementById('emailMsg');
	        	
	        	
	        	inputEmail.addEventListener('blur', () => {
	        		axios.get('http://localhost:8083/signup/{email_address}' + inputEmail.value)
	        			.then(response => {
						emailMsg.innerHTML = 'ㅇㄹㄴㄴㅇㄴ';
	        	});

             </script>
-->
             <script type='text/javascript' src='#'></script>
             <script type='text/javascript' src='#'></script>


    </body>
</html>