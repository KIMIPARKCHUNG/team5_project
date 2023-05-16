<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>Email Write page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
body {
	margin-top: 20px;
}

/*text color*/
.text-white {
	color: #ffffff;
}

.text-danger {
	color: #cb2a2a;
}

.text-muted {
	color: #98a6ad;
}

.text-primary {
	color: #3bc0c3;
}

.text-warning {
	color: #ebc142;
}

.text-success {
	color: #33b86c;
}

.text-info {
	color: #1ca8dd;
}

.text-inverse {
	color: #14082d;
}

.text-pink {
	color: #F13C6E;
}

.text-purple {
	color: #615ca8;
}
/* text-color */
.text-dark {
	color: #797979;
}

.list-group-item.active, .list-group-item.active:hover, .list-group-item.active:focus
	{
	background-color: #ddd;
	border-color: #ddd;
	color: #444;
	z-index: 2;
}

.list-group-item, .list-group-item:first-child, .list-group-item:last-child
	{
	border-radius: 0px;
	padding: 12px 20px;
}

.list-group-item-heading {
	font-weight: 300;
}

.list-group-item.active>.badge, .nav-pills>.active>a>.badge {
	color: #3bc0c3;
}

.list-group-item.active .list-group-item-text, .list-group-item.active:focus .list-group-item-text,
	.list-group-item.active:hover .list-group-item-text {
	color: #3bc0c3;
}

.m-t-40 {
	margin-top: 40px !important;
}

.panel {
	padding: 20px 30px;
	border: none;
	border-top: 1px solid #ddd;
	margin-bottom: 20px;
	box-shadow: none;
}

.panel .panel-body {
	padding: 0px;
	padding-top: 20px;
}

.panel .panel-body p {
	margin: 0px;
}

.panel .panel-body p+p {
	margin-top: 15px;
}

.panel-default>.panel-heading {
	background-color: #FFFFFF;
	border-color: #DDDDDD;
	color: #797979;
}

.panel-heading {
	border-color: #eff2f7;
	font-size: 16px;
	padding: 0;
	padding-bottom: 15px;
}

.panel-title {
	font-size: 18px;
	font-weight: 600;
	margin-bottom: 0;
	margin-top: 0;
}

.panel-footer {
	margin: 0px -30px -30px;
	background: #eee;
	border-top: 0px;
}

.panel-group .panel .panel-heading {
	padding-bottom: 0;
	border-bottom: 0;
}

.panel-group .panel {
	margin-bottom: 0;
	border-radius: 0;
}

.m-t-20 {
	margin-top: 20px;
}
</style>
</head>
<body>
	<link
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
		rel="stylesheet">
	<div class="container">
		<div class="wraper bootstrap snippets bootdeys bootdey">
			<div class="page-title">
				<h3 class="title">메일 보내기</h3>
			</div>
			<div class="row">

				<div class="col-md-3">
					<a href="#email-compose.html" class="btn btn-success btn-block">메일 보내기</a>
					<div class="panel panel-default p-0  m-t-20">
						<div class="panel-body p-0">
							<div class="list-group no-border mail-list">
								<a href="/emailList2" class="list-group-item"><i
									class="fa fa-download m-r-5"></i> 받은 메일함<b id='readCount'></b></a>
							    <a href="/emailSendList" class="list-group-item"><i
									class="fa fa-paper-plane-o m-r-5"></i> 보낸 메일함</a> <a
									href="/deleteList" class="list-group-item"><i
									class="fa fa-trash-o m-r-5"></i> 휴지통<b></b></a>
							</div>
						</div>
					</div>
				</div>


				<div class="col-md-9">
					<div class="row">
						<div class="col-lg-12">
							<div class="btn-toolbar" role="toolbar">
								<div class="btn-group">
									<button type="button" class="btn btn-success">
										<i class="fa fa-trash-o"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default m-t-20">
						<div class="panel-body">
						 <form class="mb-5" method="post" id="contactForm" name="contactForm" enctype="multipart/form-data">
              <div class="row">
                
                <div class="col-md-12 form-group">
                  <label for="name" class="col-form-label">받는 사람</label>
                  <input type="text" class="form-control" name="recipient_id" id="recipient_id">
                </div>
              </div>
              <div class="row">
                <div class="col-md-12 form-group">
                  <label for="email" class="col-form-label">제목</label>
                  <input type="text" class="form-control" name="email_subject" id="email_subject">
                </div>
              </div>

              <div class="row mb-3">
                <div class="col-md-12 form-group">
                  <label for="message" class="col-form-label">본문</label>
                  <textarea class="form-control" name="body" id="body" cols="30" rows="7"></textarea>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-12 form-group">
                  <label for="message" class="col-form-label">파일 첨부</label>
                 <span style="font-size:10pt;">
	        			<!-- input 박스 -->
	        			<input type="file" name="file">
	        		</span>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <input type="submit" value="Send Message" class="btn btn-block btn-primary rounded-0 py-2 px-4">
                  <span class="submitting"></span>
                </div>
              </div>
            </form>
							<hr>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">

	</script>
</body>
</html>