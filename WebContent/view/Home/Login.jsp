<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đăng nhập hệ thống</title>
    <link rel="shortcut icon" href="view/resources/favicon.png">
    <link href="view/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="view/resources/css/font-awesome.min.css" rel="stylesheet">
    <script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script type="text/javascript" src="view/resources/js/jquery-3.3.1.js"></script>
	  
     <style>
        body {
         background: #34495e;
        }
        #loginForm {
            width: 400px;
            min-height:300px;
            padding: 20px;
            margin: 140px auto 0;
            background:#fff;
            border-radius: 7px #fffff;
        }
    </style>
</head>
    <div id="loginForm">
    <form action="./login" class="form-signin" role="form" method="post">
       <div class="form-group" style="text-align: center"><h4>ĐĂNG NHẬP HỆ THỐNG</h4></div>
        <div class="form-group">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-envelope-o"></i></span>
              <input name="email" type="email"  class="form-control" id="email" placeholder="Email" maxlength="100" required="">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
              <span class="input-group-addon"><i class="fa fa-key"></i></span>
              <input name="password" type="password" class="form-control" id="password" placeholder="Mật khẩu" required="">
            </div>
        </div>
         <div class="form-group">
        <button class="btn btn-primary align-self-center " type="submit" style="margin-left:120px;"><i class="fa fa-sign-in"></i>Đăng nhập</button>
        <br>
        <a style="margin-left:120px; margin-top:5px" href="./CallForgotPass">Quên mật khẩu?</a>
      </div>
	</form>
  </div>
	<script>
		$(document).ready(function(){
			if(<%= request.getAttribute("content")!= null %>){
			swal ( '<%= (String)request.getAttribute("title")%>','<%= (String)request.getAttribute("content")%>','<%= (String)request.getAttribute("type")%>')
			<%request.removeAttribute("title");%>
			<%request.removeAttribute("content");%>
			<%request.removeAttribute("type");%>
			}
			return false
				});
		</script>
</body>
</html>
