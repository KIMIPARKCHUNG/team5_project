
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>Email list page</title>
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

.email-head {
	background-color: transparent;
}

.email-head-subject {
	padding: 25px 25px;
	border-bottom: 1px solid #e8ebf1;
}

@media ( max-width : 767px) {
	.email-head-subject {
		padding: 25px 10px;
	}
}

.email-head-subject .title {
	display: block;
	font-size: .99rem;
}

.email-head-subject .title a.active .icon {
	color: #fbbc06;
}

.email-head-subject .title a .icon {
	color: silver;
	margin-right: 6px;
}

.email-head-subject .title a .icon svg {
	width: 18px;
}

.email-head-subject .icons {
	font-size: 14px;
	float: right;
}

.email-head-subject .icons .icon {
	color: #000;
	margin-left: 12px;
}

.email-head-subject .icons .icon svg {
	width: 18px;
}

.email-head-sender {
	padding: 13px 25px;
}

@media ( max-width : 767px) {
	.email-head-sender {
		padding: 25px 10px;
	}
}

.email-head-sender .avatar {
	float: left;
	margin-right: 10px;
}

.email-head-sender .date {
	float: right;
	font-size: 12px;
}

.email-head-sender .avatar {
	float: left;
	margin-right: 10px;
}

.email-head-sender .avatar img {
	width: 36px;
}

.email-head-sender .sender>a {
	color: #000;
}

.email-head-sender .sender span {
	margin-right: 5px;
	margin-left: 5px;
}

.email-head-sender .sender .actions {
	display: inline-block;
	position: relative;
}

.email-head-sender .sender .actions .icon {
	color: #686868;
	margin-left: 7px;
}

.email-head-sender .sender .actions .icon svg {
	width: 18px;
}

.email-body {
	background-color: transparent;
	border-top: 1px solid #e8ebf1;
	padding: 30px 28px;
}

@media ( max-width : 767px) {
	.email-body {
		padding: 30px 10px;
	}
}

.email-attachments {
	background-color: transparent;
	padding: 25px 28px 5px;
	border-top: 1px solid #e8ebf1;
}

@media ( max-width : 767px) {
	.email-attachments {
		padding: 25px 10px 0;
	}
}

.email-attachments .title {
	display: block;
	font-weight: 500;
}

.email-attachments .title span {
	font-weight: 400;
}

.email-attachments ul {
	list-style: none;
	margin: 15px 0 0;
	padding: 0;
}

.email-attachments ul>li {
	margin-bottom: 5px;
}

.email-attachments ul>li:last-child {
	margin-bottom: 0;
}

.email-attachments ul>li a {
	color: #000;
}

.email-attachments ul>li a svg {
	width: 18px;
	color: #686868;
}

.email-attachments ul>li .icon {
	color: #737373;
	margin-right: 2px;
}

.email-attachments ul>li span {
	font-weight: 400;
}

.rtl .email-head-subject .title a .icon {
	margin-right: 0;
	margin-left: 6px;
}

.rtl .email-head-subject .icons .icon {
	margin-left: 0;
	margin-right: 12px;
}

.rtl .email-head-sender .avatar {
	margin-right: 0;
	margin-left: 10px;
}

.rtl .email-head-sender .sender .actions .icon {
	margin-left: 0;
	margin-right: 7px;
}

.email-head-title {
	padding: 15px;
	border-bottom: 1px solid #e8ebf1;
	font-weight: 400;
	color: #3d405c;
	font-size: .99rem;
}

.email-head-title .icon {
	color: #696969;
	margin-right: 12px;
	vertical-align: middle;
	line-height: 31px;
	position: relative;
	top: -1px;
	float: left;
	font-size: 1.538rem;
}

.inbox-wrapper .email-content .email-list .email-list-item .email-list-detail .date
	{
	color: #000;
}

.inbox-wrapper .email-content .email-list .email-list-item .email-list-detail .date .icon svg
	{
	width: 14px;
	margin-right: 7px;
	color: #3d405c;
}
</style>
</head>
<body>


<div class="container">
		<div class="wraper bootstrap snippets bootdeys bootdey">
			<div class="page-title">
				<h3 class="title">${email.email_subject}</h3>
			</div>
			<div class="row">

				<div class="col-md-3">
					<a href="/emailWrite" class="btn btn-success btn-block">메일 보내기</a>
					<div class="panel panel-default p-0  m-t-20">
						<div class="panel-body p-0">
							<div class="list-group no-border mail-list">
								<a href='/emailList2' class="list-group-item active"><i
									class="fa fa-download m-r-5"></i> 받은 메일함 <b></b></a>
								<a href="/emailSendList" class="list-group-item"><i
									class="fa fa-paper-plane-o m-r-5"></i> 보낸 메일함</a> 
								<a href="/deleteList" class="list-group-item"><i class="fa fa-trash-o m-r-5"></i> 휴지통<b></b></a>
							</div>
						</div>
					</div>
				</div>


				<div class="col-md-9">
					<div class="email-head">
						<div class="email-head-subject">
							<div
								class="title d-flex align-items-center justify-content-between">
								<div class="d-flex align-items-center">
									<a class="active" href="#"><span class="icon"><svg
												xmlns="http://www.w3.org/2000/svg" width="24" height="24"
												viewBox="0 0 24 24" fill="none" stroke="currentColor"
												stroke-width="2" stroke-linecap="round"
												stroke-linejoin="round"
												class="feather feather-star text-primary-muted">
												<polygon
													points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon></svg></span></a>
									<span>${email.email_subject}</span>
								</div>
								<div class="icons">
									<a href="#" class="icon"><svg
											xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none" stroke="currentColor"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round"
											class="feather feather-share text-muted hover-primary-muted"
											data-toggle="tooltip" title="" data-original-title="Forward">
											<path d="M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8"></path>
											<polyline points="16 6 12 2 8 6"></polyline>
											<line x1="12" y1="2" x2="12" y2="15"></line></svg></a> <a href="#"
										class="icon"><svg xmlns="http://www.w3.org/2000/svg"
											width="24" height="24" viewBox="0 0 24 24" fill="none"
											stroke="currentColor" stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round"
											class="feather feather-printer text-muted"
											data-toggle="tooltip" title="" data-original-title="Print">
											<polyline points="6 9 6 2 18 2 18 9"></polyline>
											<path
												d="M6 18H4a2 2 0 0 1-2-2v-5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-2"></path>
											<rect x="6" y="14" width="12" height="8"></rect></svg></a> <a href="#"
										class="icon"><svg xmlns="http://www.w3.org/2000/svg"
											width="24" height="24" viewBox="0 0 24 24" fill="none"
											stroke="currentColor" stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round"
											class="feather feather-trash text-muted"
											data-toggle="tooltip" title="" data-original-title="Delete">
											<polyline points="3 6 5 6 21 6"></polyline>
											<path
												d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path></svg>
									</a>
								</div>
							</div>
						</div>
						<div
							class="email-head-sender d-flex align-items-center justify-content-between flex-wrap">
							<div class="d-flex align-items-center">
								<div class="avatar">
									<img src="https://bootdey.com/img/Content/avatar/avatar1.png"
										alt="Avatar" class="rounded-circle user-avatar-md">
								</div>
								<div class="sender d-flex align-items-center">
									<a href="#">${email.sender_id }</a>
								</div>
							</div>
							<div class="date">${email.send_date }</div>
						</div>
					</div>
					<div class="email-body">
						<p>${email.body}</p>
						<br>
					</div>
					<c:if test="${not empty fileList }">
						<div class="email-attachments">
							<div class="title">
								첨부파일 <span>(${fileCount} files, ${fileTotalSize})</span>
							</div>
							<ul>
								<c:forEach items="${fileList }" var="file">
									<li><a href="/download/file/${file.file_id }"><svg xmlns="http://www.w3.org/2000/svg"
												width="24" height="24" viewBox="0 0 24 24" fill="none"
												stroke="currentColor" stroke-width="2" stroke-linecap="round"
												stroke-linejoin="round" class="feather feather-file">
												<path
													d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
												<polyline points="13 2 13 9 20 9"></polyline></svg> ${file.file_subject } <span
											class="text-muted tx-11">${file.file_size }</span></a></li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>



<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	<link
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
		rel="stylesheet">
	
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">

	
</script>
</body>
</html>