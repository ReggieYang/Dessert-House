<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage"/></title>
</head>
<body>
<form method='POST' action='login'>
id: <input type='text' name='sid' value=''>
password: <input type='password' name='password' value=''>
<input type='submit' name='login' value='login'>
</form>
</body>
</html>
 --%>
 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>工作人员</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/dist/css/skins/skin-purple.min.css">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/dist/css/AdminLTE.min.css">

</head>

<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>S</b>L</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Sweet </b>Life</span>
    </a>

    <nav class="navbar navbar-static-top" role="navigation">
     
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
     
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="<%=request.getContextPath()%>/public/dist/img/avatar04.png" class="user-image" alt="User Image">
              <span class="hidden-xs">工作人员</span>
            </a>

          </li>
          
          <li>
           
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="<%=request.getContextPath()%>/public/dist/img/avatar04.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>工作人员</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i>未登录</a>
        </div>
      </div>


      <ul class="sidebar-menu">
        <li class="header">功能</li>
        <!-- Optionally, you can add icons to the links -->
        <li  class="active"><a href="<%=request.getContextPath()%>/user/cardinfopage"><i class="fa fa-user-md"></i> <span>登录</span></a></li>

      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       	 登录您的账号
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> SweetLife</a></li>
        <li class="active">Login</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
    <form  method='POST' action='staff/login' class="form-horizontal">
      <div class="row">
        
      <div class="box box-info col-sm-10">
            <div class="box-header with-border">
              <h3 class="box-title">登录</h3>

            </div>        
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">账号</label>

                  <div class="col-sm-5">
                    <input type="number" class="form-control" name="sid" id="inputEmail3" placeholder="id">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">密码</label>

                  <div class="col-sm-5">
                    <input type="password" class="form-control" name='password' id="inputPassword3" placeholder="Password">
                  </div>
                </div>
              </div>
      	</div>

      <div class="box-footer" >
      <div class="col-sm-6">
     
      </div>
        <button type="submit" class="btn btn-info pull-left col-sm-1">登录</button>
       		</div>
		</div>
    </form>


    </section>
    <!-- /.content -->
  </div>

  <footer class="main-footer">

    
  </footer>

 

  <div class="control-sidebar-bg"></div>
</div>

<script src="<%=request.getContextPath()%>/public/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/public/dist/js/app.min.js"></script>


</body>

</html>


 
 
 
 