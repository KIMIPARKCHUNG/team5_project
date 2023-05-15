<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,700,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Contact Form #3</title>
  </head>
  <body>
  

  <div class="content">
    
    <div class="container">
      <div class="row align-items-center">
        
        </div>

        <div class="col-lg-6">
          <div class="box">
            <h3 class="heading">Send us a message</h3>
            <form class="mb-5" method="post" id="contactForm" name="contactForm">
              <div class="row">
                
                <div class="col-md-12 form-group">
                  <label for="name" class="col-form-label">Name</label>
                  <input type="text" class="form-control" name="name" id="name">
                  		<br/>
	        		<span id="someone-to-send" style="font-size:8pt;"></span>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12 form-group">
                  <label for="email" class="col-form-label">Email</label>
                  <input type="text" class="form-control" name="email" id="email">
                </div>
              </div>

              <div class="row mb-3">
                <div class="col-md-12 form-group">
                  <label for="message" class="col-form-label">Message</label>
                  <textarea class="form-control" name="message" id="message" cols="30" rows="7"></textarea>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <input type="submit" value="Send Message" class="btn btn-block btn-primary rounded-0 py-2 px-4">
                  <span class="submitting"></span>
                </div>
              </div>
            </form>

    
        </div>
      </div>
  </div>
    
    

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/main.js"></script>
    <script type="text/javascript">
	/* 시나리오
		1) deptno를 입력하는 input태그에 addEventListener('blur', () => {})
		2) blur(unfocus)가 되면 axios 비동기 요청을 서버(http://localhost:8082/api/dept/{deptno}로 보냄
		3) deptno를 @PathVariable로 받아서 -> 해당 부서 유무 확인 
										-> 해당 부서가 존재한다면! : '이미 존재하는 부서번호 입니다.'예외 메세지 출력
										-> 해당 부서가 존재X않는다면 !: '사용가능한 부서번호입니다.' 결과 메세지 출력
	*/
	const deptno = document.getElementById('deptno');
	let deptnoMsg = document.getElementById('deptnoMsg');
	deptno.addEventListener('blur', ()=>{
		console.log(deptno);
	       axios.get('http://localhost:8000/api/dept/'+deptno.value)
        .then(response => {s
        	if(response.data == ''){
        		deptnoMsg.innerHTML = "새로운 부서 번호로 사용할 수 있습니다.";
        	}
        
        })
        .catch(error=>{
        	deptnoMsg.innerHTML =	error.response.data;
        })
        }
     
	
        
	);
</script>
  </body>
</html>