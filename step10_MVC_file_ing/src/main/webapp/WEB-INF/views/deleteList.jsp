<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>휴지통</title>
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
				<h3 class="title">휴지통</h3>
			</div>
			<div class="row">

				<div class="col-md-3">
					<a href="/emailWrite" class="btn btn-success btn-block">메일 보내기</a>
					<div class="panel panel-default p-0  m-t-20">
						<div class="panel-body p-0">
							<div class="list-group no-border mail-list">
								<a href="/emailList2" class="list-group-item"><i
									class="fa fa-download m-r-5"></i> 받은 메일함 <b id='readCount'> (${isReadCount})</b></a>
							    <a href="#" class="list-group-item"><i
									class="fa fa-paper-plane-o m-r-5"></i>Sent Mail</a> 
								<a href="#" class="list-group-item active"><i
									class="fa fa-trash-o m-r-5"></i> 휴지통 <b>(354)</b></a>
							</div>
						</div>
					</div>
				</div>

<form action="/hardDelete" method="post">
				<div class="col-md-9">
					<div class="row">
						<div class="col-lg-12">
							<div class="btn-toolbar" role="toolbar">
								<div class="btn-group">
									<button type="button" class="btn btn-success">
										<i class="fa fa-inbox"></i>
									</button>
									<button type="button" class="btn btn-success">
										<i class="fa fa-exclamation-circle"></i>
									</button>
									<button type="submit" class="btn btn-success">
										<i class="fa fa-trash-o"></i>
									</button>
								</div>
								<div class="btn-group">
									<button type="button" class="btn btn-success dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<i class="fa fa-folder"></i> <b class="caret"></b>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#fakelink">Action</a></li>
										<li><a href="#fakelink">Another action</a></li>
										<li><a href="#fakelink">Something else here</a></li>
										<li class="divider"></li>
										<li><a href="#fakelink">Separated link</a></li>
									</ul>
								</div>
								<div class="btn-group">
									<button type="button" class="btn btn-success dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<i class="fa fa-tag"></i> <b class="caret"></b>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#fakelink">Action</a></li>
										<li><a href="#fakelink">Another action</a></li>
										<li><a href="#fakelink">Something else here</a></li>
										<li class="divider"></li>
										<li><a href="#fakelink">Separated link</a></li>
									</ul>
								</div>
								<div class="btn-group">
									<button type="button" class="btn btn-success dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										More <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#fakelink">Dropdown link</a></li>
										<li><a href="#fakelink">Dropdown link</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default m-t-20">
						<div class="panel-body">
							<table class="table table-hover mails">
								<tbody>
									<c:forEach items="${emailList}" var="email">
										<tr>
											<td class="mail-select"><label class="cr-styled">
													<input type="checkbox" name="deleteCheck" value="${email.email_id }"><i class="fa"></i>
											</label></td>
											<td><a href="##email-read.html">${email.sender_id }</a></td>
											<c:choose>
												<c:when test="${fn:contains(email.is_read,'F')}">
													<td><a href="emailRead3/${email.email_id}"><b>${email.email_subject }</b></a></td>
												</c:when>
												<c:otherwise>
													<td><a href="emailRead3/${email.email_id}">${email.email_subject }</a></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${fn:contains(email.file_exist, 'T')}">
													<td><i class="fa fa-paperclip" id="clip"></i></td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<td class="text-right">${email.send_date }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<hr>
							<div class="row">
								<div class="col-xs-7">Showing 1 - 20 of 289</div>
								<div class="col-xs-5">
									<div class="btn-group pull-right">
										<button type="button" class="btn btn-default">
											<i class="fa fa-chevron-left"></i>
										</button>
										<button type="button" class="btn btn-default">
											<i class="fa fa-chevron-right"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</form>
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