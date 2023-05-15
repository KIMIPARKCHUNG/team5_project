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
                                } body{background: #F6F6F6}.card{border: none;height: 430px}.forms-inputs{position: relative}
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

					<div class="text-center"> <img class="center" src = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcvyBp4%2Fbtsfdb1W0fk%2FkLgbVH12ddKLf8GB8xW0N0%2Fimg.png" width = "90px">
					
					<br>
					<span class="text-center fs-1">
						<br>에러가 발생하였습니다.<br>다시 시도해주세요.
					</span> </div>
					<br><br>
                    <div class="mb-3"> <button class="btn text-white w-100"
                    						   onclick="location.href='/login2'"
                    						   style="background-color: #5CB85C;">로그인 화면으로</button> </div>
					<div class="mb-3"> <button type = "submit"
												class="btn text-white w-100"
												style="background-color: #5CB85C;"
												onclick="location.href='/signup'">회원가입</button> </div>
           	</div>
         </div>
     </div>
 </div>
                            
</body>
</html>