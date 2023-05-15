<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Login2</title>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Snippet - BBBootstrap</title>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
<link href='https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css' rel='stylesheet'>
<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js'></script>

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

                                } body{background: #}.card{border: none;height: 320px}.forms-inputs{position: relative}.forms-inputs span{position: absolute;top:-18px;left: 10px;background-color: #fff;padding: 5px 10px;font-size: 15px}.forms-inputs input{height: 50px;border: 2px solid #eee}.forms-inputs input:focus{box-shadow: none;outline: none;border: 2px solid #000}.btn{height: 50px}.success-data{display: flex;flex-direction: column}.bxs-badge-check{font-size: 90px}</style>
                                </head>
                                <body className='snippet-body'>
                                <div class="container mt-5">
    <div class="row d-flex justify-content-center">

                                } body{background: #F6F6F6}.card{border: none;height: 370px}.forms-inputs{position: relative}
                                						.forms-inputs span{position: absolute;top:-18px;left: 10px;background-color: #fff;padding: 5px 10px;font-size: 15px}
                                						.forms-inputs input{height: 50px;border: 2px solid #eee}
                                						.forms-inputs input:focus{box-shadow: none;outline: none;border: 2px solid #000}.btn{height: 50px}
                                						.success-data{display: flex;flex-direction: column}
                                						.bxs-badge-check{font-size: 90px}
</style>

</head>
<body className='snippet-body'>
<div class="container mt-5">
   <div class="row d-flex justify-content-center">

        <div class="col-md-6">
            <div class="card px-5 py-5" id="form1">
               <form action="/login2" method="POST" enctype="multipart/form-data">               
                    <div class="forms-inputs mb-4">
                    	<span>Email</span>
                    	<input id = "email_address" name = "email_address" type = "text" class ="form-control">
                        <div class="invalid-feedback">유효한 이메일 주소를 기입해주세요.</div>
                    </div>              
                    
                    <div class="forms-inputs mb-4">
                    	<span>Password</span>
                    	<input id = "password" name = "password" type = "password" class = "form-control" >
                        <div class="invalid-feedback">비밀번호는 5자 이상이어야 합니다.</div>
                    </div>
                    <div class="mb-3"> <button type = "submit" class="btn text-white w-100" style="background-color: #5CB85C;" >로그인</button> </div>
                </form>
                    <div class="mb-3"> <button class="btn btn-link w-100" onclick="location.href='/signup'">회원가입</button> </div>
           	</div>
                <!--  
                <div class="success-data" v-else>
                    <div class="text-center d-flex flex-column"> <i class='bx bxs-badge-check'></i> <span class="text-center fs-1">You have been logged in <br> Successfully</span> </div>
                </div>
                -->
            </div>
        </div>
    </div>
</div>


<!--  
<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
<script type='text/javascript' src='#'></script>
<script type='text/javascript' src='#'></script>
<script type='text/javascript' src='#'></script>
<script type='text/javascript'>var app = new Vue({
  el: '#form1',
  data: function () {
    return {
    email : "",
    emailBlured : false,
    valid : false,
    submitted : false,
    password:"",
    passwordBlured:false
    }
  },

  methods:{

  validate : function(){
  this.emailBlured = true;
  this.passwordBlured = true;
  if( this.validEmail(this.email) && this.validPassword(this.password)){
  	this.valid = true;
    }
   },

validEmail : function(email) {
   
var re = /(.+)@(.+){2,}\.(.+){2,}/;
if(re.test(email.toLowerCase())){
  return true;
}

},

validPassword : function(password) {
   if (password.length > 7) {
    return true;
   }
},

submit : function(){
this.validate();
if(this.valid){
this.submitted = true;
}
}
  }
});
</script>
 <script type='text/javascript'>var myLink = document.querySelector('a[href="#"]');
 myLink.addEventListener('click', function(e) {
   e.preventDefault();
 });</script>
-->
                            
</body>
</html>