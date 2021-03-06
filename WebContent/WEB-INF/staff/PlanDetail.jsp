
<%@page import="beans.Commodity_view"%>
<%@page import="beans.SalePlan_view" %>
<%@page import="model.Store" %>
<%@page import="beans.StoreList" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 

<!DOCTYPE html>

<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>购物车</title>
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
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/public/dist/css/AdminLTE.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
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
          <!-- Messages: style can be found in dropdown.less-->
          

          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="<%=request.getContextPath()%>/public/dist/img/avatar2.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><%=session.getAttribute("staff_name") %></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="<%=request.getContextPath()%>/public/dist/img/avatar2.png" class="img-circle" alt="User Image">

                <p>
                  <%=session.getAttribute("staff_name") %> - Waiter
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
          <img src="<%=request.getContextPath()%>/public/dist/img/avatar2.png" class="img-circle" alt="User Image">
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
<li class="treeview">
          <a href="#"><i class="fa-user-md fa"></i> <span>顾客信息</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
                <li><a href="<%=request.getContextPath()%>/staff/cinfo2"><i class="fa fa-clone"></i> <span>会员信息</span></a></li>
		        <li><a href="<%=request.getContextPath()%>/staff/payrecord2"><i class="fa fa-rmb"></i> <span>缴费记录</span></a></li>
		        <li><a href="<%=request.getContextPath()%>/staff/salerecord2"><i class="fa fa-tasks"></i> <span>消费记录</span></a></li>
          </ul>
        </li>
      
        <li><a href="<%=request.getContextPath()%>/staff/planlist"><i class="fa fa-toggle-right"></i><span>查看计划</span></a></li>
        <li class="treeview active">
          <a href="#"><i class="fa-pencil fa"></i> <span>制定计划</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
            <li><a href="<%=request.getContextPath()%>/staff/planhome"><i class="fa  fa-sort-alpha-desc"></i><span>商品列表</span></a></li>
            <li><a href="<%=request.getContextPath()%>/staff/plandetail"><i class="fa fa-search-plus"></i><span>计划详情</span></a></li>
          </ul>
        </li>
         <li><a href="<%=request.getContextPath()%>/staff/sinfo2"><i class="fa fa-user-md"></i> <span>注册信息</span></a></li>
        </ul> 
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

<jsp:useBean id="cart" class="beans.SalePlan_view" scope="page"></jsp:useBean>
<jsp:useBean id="com" class="beans.Commodity_view" scope="page"></jsp:useBean>
<jsp:useBean id="slist" class="beans.StoreList" scope="session"></jsp:useBean>
<jsp:useBean id="store" class="model.Store" scope="page"></jsp:useBean>


<% cart = (SalePlan_view)session.getAttribute("cart");
slist = (StoreList)session.getAttribute("storelist");
%>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> SweetLife</a></li>
        <li class="active">PlanDetail</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
		
<form class="form-horizontal" action="user/commoditylist">
          <div class="form-group">
					<div class="col-sm-1">
					<label for="exampleInputEmail1" class="pull-right"><h4  style="margin-top:3">店面</h4></label>
					
					</div>
				
                  <div class="col-sm-2">
                    <!-- <input type="email" class="form-control" id="inputEmail3" placeholder="Email" > -->
                    <select class="form-control col-sm-2" id="store">

                                       <% for(int i=0;i<slist.getList().size();i++){
                    	store = slist.getList(i);               	
							   %>
                    <option sid=<%=store.getId()%> ><%=store.getName()%></option>
         					<% }%>
                        
                    </select>
                    
                    </div>
                    
                    
                    <div class="col-sm-1">
					<label for="exampleInputEmail1" class="pull-right"><h4  style="margin-top:3">日期</h4></label>
					
					</div>
                    
                     <div class="col-sm-2">
                    	<input  type="date" class="form-control col-sm-2"  id="time" value="2016-03-29">
                    
                    </div>
                    
         

                </div>
            </form>





 <form class="form-horizontal" action="user/commoditylist">
 
              <!-- /.box-body -->

              <!-- /.box-footer -->
            </form>
		<%double sum=0; %>
		<BR>
		<TABLE class="table table-striped table-bordered">
			<TBODY>
				<TR>
					<TH width="20%" style="text-align:center">商品编号</TH>
					<TH width="21%" style="text-align:center">商品名</TH>
					<TH width="21%" style="text-align:center">数量</TH>
					<TH width="20%" style="text-align:center">单价</TH>
					<TH width="18%" style="text-align:center">  </TH>
				</TR>
				<%
					for (int i = 0; i < cart.getList().size(); i++) {
						pageContext.setAttribute("com", cart.getList().get(i));
						com = cart.getList().get(i);
						sum = sum + com.getAmount()*com.getPrice();
				%>
				<TR>
					<TD align="center" id="1btn<%=i %>"><jsp:getProperty name="com" property="commodity_id" /></TD>
					<TD align="center" id="1btn<%=i %>"><jsp:getProperty name="com" property="name" /></TD>
					<TD align="center" id="2btn<%=i %>"><jsp:getProperty name="com" property="amount"/></TD>
					<TD align="center" id="3btn<%=i %>"><jsp:getProperty name="com" property="price" /></TD>


                    <td align="right">
                    <div>
<%--                     <button id="btn<%=i%>" cid=<jsp:getProperty name="com" property="commodity_id" /> 
                     class="btn-danger pull-left col-sm-2 btn-sm sendmessage">删除</button> --%>
                     <a class="btn-danger col-sm-3 btn-sm sendcid" href="staff/deletefromplan?commodity_id=<%=com.getCommodity_id() %>">删除</a>
                  </div>
					</TD>
					
				</TR>
				

				<%} %>
				
				
								<tr>
								<td align='center'>
				</td>
				<td align='center'>
				</td>
				<td align='center'>
				</td>
				
				<td align='center'>
				
				</td>
				
				
				<td align='center'>
				                    <div>

                     <a class="btn-primary col-sm-3 btn-sm" id="sub" href="#">提交</a>
                  </div>
				</td>
				
				</tr>
			</TBODY>
		</TABLE> 
	
      <!-- Your Page Content Here -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->

    <!-- Default to the left -->
    
  </footer>


  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
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

<script type="text/javascript">
$("#sub").click(function(){
	var option = $("#store").find("option:selected");
	var store_id = option.attr('sid');	
	var time = $("#time").val();
   	  $.post("staff/submitplan",
	  {
  		  store_id:store_id,
	   	  time:time
	  }, function(data){
	 		self.location.assign("staff/planlist");
	  });   
	});


</script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>
