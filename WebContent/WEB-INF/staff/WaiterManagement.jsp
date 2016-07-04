<%@page import="beans.StoreList"%>
<%@page import="model.Store"%>
<%@page import="model.WorkingRecord"%>
<%@page import="beans.WorkingList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%@ taglib uri="/struts-tags" prefix="s"%> 

<!DOCTYPE html>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>店员管理</title>
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

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>S</b>L</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Sweet </b>Life</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">

      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">


          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="<%=request.getContextPath()%>/public/dist/img/user7-128x128.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><%=session.getAttribute("staff_name") %></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="<%=request.getContextPath()%>/public/dist/img/user7-128x128.jpg" class="img-circle" alt="User Image">

                <p>
                  <%=session.getAttribute("staff_name") %> - Admin
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="user/personalinfopage" class="btn btn-default btn-flat"></a>
                </div>
                <div class="pull-right">
                  <a href="<%=request.getContextPath()%>/staff/loginpage" class="btn btn-default btn-flat">注销</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
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
          <img src="<%=request.getContextPath()%>/public/dist/img/user7-128x128.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%=session.getAttribute("staff_name") %></p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> 已登录</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
     <ul class="sidebar-menu">
        <li class="header">功能</li>
        <li><a href="<%=request.getContextPath()%>/staff/storelist"><i class="fa fa-university"></i> <span>店面管理</span></a></li>
         <li class="active"><a href="<%=request.getContextPath()%>/staff/waiterlist"><i class="fa fa-male"></i> <span>店员管理</span></a></li>
        </ul> 
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>



  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
  		店员列表
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> SweetLife</a></li>
        <li class="active">WaiterManagement</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

	<jsp:useBean id="workinglist" class="beans.WorkingList" scope="session"></jsp:useBean>
	<jsp:useBean id="info" class="model.WorkingRecord" scope="page"></jsp:useBean>
	<jsp:useBean id="slist" class="beans.StoreList" scope="session"></jsp:useBean>
	<jsp:useBean id="store" class="model.Store" scope="page"></jsp:useBean>

<% 

workinglist = (WorkingList)session.getAttribute("workinglist");

slist = (StoreList)session.getAttribute("storelist");

%>



    <table class="table table-striped">
        <tbody>
        <tr>
          <th style="width:10%">id</th>
          <th style="width:20%">店名</th>
          <th style="width:25%">所在店面</th>
          <th style="width:24%"></th>
        </tr>
        
        <%if(workinglist!=null){
        	for(int i=0;i<workinglist.getList().size();i++){
        	pageContext.setAttribute("info", workinglist.getList().get(i));
        	
        	
        	%>
        
          <tr>
            <td><jsp:getProperty name="info" property="waiter_id" /></td>
            <td id=<%="name"+i %>><jsp:getProperty name="info" property="waiter_name" /></td>
            <td id=<%="address"+i %>><jsp:getProperty name="info" property="store_name" /></td>
            <td>
              <a data-toggle="modal" data-target="#modifyEmployee" id="<%=i %>"
              wid=<jsp:getProperty name="info" property="waiter_id" /> sid=<jsp:getProperty name="info" property="store_id" />
              class="btn btn-primary modify"> 修改 </a>
              <a href="staff/deletewaiter?waiter_id=<jsp:getProperty name="info"  property="waiter_id" />" class="btn btn-danger"> 删除 </a>
            </td>
          </tr>
          
          
          <%
        	}
        	} %>
        </tbody>
        <tfoot>
           <tr>
            <td colspan="5" style="text-align: center">
              <a data-toggle="modal" data-target="#addEmployee" class="btn btn-success"> 添加店员 </a>
            </td>
          </tr>
        </tfoot>
    </table>
    


    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">

    
  </footer>


  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.1.4 -->
<script src="<%=request.getContextPath()%>/public/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/public/dist/js/app.min.js"></script>





</body>


<div class="modal fade" id="modifyEmployee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改店员信息</h4>
      </div>
      <div class="modal-body">
        <div class="form-horizontal">

          <div class="form-group">
            <label class="col-sm-2 control-label" for="modify-employee-belong-shop">所属店铺</label>
            <div class="col-sm-10">
              <select class="form-control" name="modify-employee-belong-shop" id="ms">
              <%for(int j=0;j<slist.getList().size();j++){ 
              store = slist.getList(j);
              %>
                <option i=<%=store.getId() %>><%=store.getName() %></option>
                <%} %>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label" for="modify-employee-role">身份</label>
            <div class="col-sm-10">
              <select class="form-control" id="modify-employee-role">
                <option t="waiter">分店服务员</option>
                <option t="head_waiter">总店服务员</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="confirm-modify-employee">确认修改</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="addEmployee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加店员</h4>
      </div>
      <div class="modal-body">
        <div class="form-horizontal">
          <div class="form-group">
            <label class="col-sm-2 control-label" for="add-employee-name">店员名称</label>
            <div class="col-sm-10">
              <input type="text" placeholder="店员名称" id="add-employee-name" class="form-control">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label" for="add-employee-role">身份</label>
            <div class="col-sm-10">
              <select class="form-control" id="add-employee-role">
                <option t="waiter">分店服务员</option>
                <option t="head_waiter">总店服务员</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="confirm-add-employee">确认添加</button>
      </div>
    </div>
  </div>
</div>



<script type="text/javascript">
$("#confirm-add-employee").click(function(){
	var name = $("#add-employee-name");
	var type = $("#add-employee-role");
	var option = type.find("option:selected");
  	  $.post("staff/addwaiter",
	  {
	    name:name.val(),
	    type:option.attr('t')
	  }, function(data){
	 		self.location.assign("staff/waiterlist");
	  });  
	});


</script>



<script type="text/javascript">
$(".modify").click(function(){
	var wid = $(this).attr('wid');
	var sid = $(this).attr('sid');
	$("#modifyEmployee").attr('wid',wid);
	$("#modifyEmployee").attr('sid',sid);
	});


</script>


<script type="text/javascript">
$("#confirm-modify-employee").click(function(){
	var option = $("#ms").find("option:selected");
	var store_id = option.attr('i');	
	var wid = $("#modifyEmployee").attr('wid');
	var sid = $("#modifyEmployee").attr('sid');
	var type = $("#modify-employee-role").find("option:selected").attr('t');
   	  $.post("staff/modifywaiter",
	  {
  		  store_id:store_id,
	   	  waiter_id:wid,
	   	  type:type,
	   	  sid:sid
	  }, function(data){
	 		self.location.assign("staff/waiterlist");
	  });   
	});


</script>



</html>
