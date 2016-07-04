<%@page import="beans.SaleRecordList"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%@ taglib uri="/struts-tags" prefix="s"%> 

<!DOCTYPE html>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>会员消费记录</title>
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
        <li class="header">功能</li>
       <li class="treeview  active">
          <a href="#"><i class="fa-user-md fa"></i> <span>顾客信息</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
                <li><a href="<%=request.getContextPath()%>/staff/cinfo2"><i class="fa fa-clone"></i> <span>会员信息</span></a></li>
		        <li><a href="<%=request.getContextPath()%>/staff/payrecord2"><i class="fa fa-rmb"></i> <span>缴费记录</span></a></li>
		        <li><a href="<%=request.getContextPath()%>/staff/salerecord2"><i class="fa fa-tasks"></i> <span>消费记录</span></a></li>
          </ul>
        </li>
      
        <li><a href="<%=request.getContextPath()%>/staff/planlist"><i class="fa fa-toggle-right"></i><span>查看计划</span></a></li>
        <li class="treeview">
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




  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
  		消费记录
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> SweetLife</a></li>
        <li class="active">CustomerSaleRecord</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">




    

<jsp:useBean id="salelist" class="beans.SaleRecordList" scope="session"></jsp:useBean>
<jsp:useBean id="score" class="beans.SaleRecord_view" scope="page"></jsp:useBean>
<jsp:useBean id="commodity" class="beans.Commodity_view" scope="page"></jsp:useBean>



<% salelist = (SaleRecordList)session.getAttribute("salerecord"); %>



			<form action="staff/salerecord" class="form-horizontal">
			<div class="form-group">
					<div class="col-sm-2" style="margin-left:10px">
					<input type="number" class="form-control" name="customer_id" 
					placeholder="会员卡号" value=<s:property value="customer_id"/>  >
					</div>
                    <button type="submit" class="btn btn-info col-sm-1" >显示记录</button>		
             </div>
     
			</form>


    <BR>
    <TABLE class="table table-striped table-bordered" style='font-family:Microsoft Yahei'>
      <TBODY>
        <TR>
          <TH width="20%" style="text-align:center">时间</TH>
          <TH width="10%" style="text-align:center">订单状态</TH>
          <TH width="10%" style="text-align:center">商店</TH>
          <TH width="20%" style="text-align:center">商品名</TH>
          <TH width="15%" style="text-align:center">数量</TH>
          <TH width="15%" style="text-align:center">价格</TH>
        </TR>
        <%
        if(salelist!=null){
        
          for (int i = 0; i < salelist.getList().size(); i++) {
            score = salelist.getList(i);
            pageContext.setAttribute("score", salelist.getList(i));
        %>
        <TR>
        
          <TD align="center"><jsp:getProperty name="score" property="time" /></TD>
          <TD align="center">
          
          <%if(score.getSale_status()==0){%>
        	  
       		<span class="label label-danger"><a href="#myModal" data-toggle="modal">未完成</a></span> 
<%--         	  <span class="label label-danger"><a href="staff/confirmreserve?rid=<%=score.getSale_id() %>
        	  &cid=<s:property value="customer_id"/>">未完成</a></span>  --%>
        	  <%}
          
          else if(score.getSale_status()==1){%>
        	 <span class="label label-success">已完成</span>
        	  
        	  
        	  <%}
          
          else{%>
        	   <span class="label label-warning">已取消</span>
        	  
        	  <%}%>
          

          </TD>
          <TD align="center"><jsp:getProperty name="score" property="store_name" /></TD>
          <TD align="center">
          
            <%
          for (int j = 0; j < score.getList().size(); j++) {
            pageContext.setAttribute("commodity", score.getList().get(j));
          %>
          
          <p>
          <jsp:getProperty name="commodity" property="name" />       
          </p>
          <%
          
          }%>
          
          </TD>
          
          
           <TD align="center">
          
            <%
          for (int j = 0; j < score.getList().size(); j++) {
            pageContext.setAttribute("commodity", score.getList().get(j));
          %>
          
          <p>
          <jsp:getProperty name="commodity" property="amount" />    
          </p>
          <%}%>
          
          </TD>
          
           <TD align="center">
          
            <%
          for (int j = 0; j < score.getList().size(); j++) {
            pageContext.setAttribute("commodity", score.getList().get(j));
          %>
          
          <p>
   
          <jsp:getProperty name="commodity" property="price" />   
          </p>
          <%}%>
          
          </TD>
        </TR>
        <%}
        }%>
      </TBODY>
    </TABLE> 

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



<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">完成订单</h4>
      </div>
      <div class="modal-body">
      <label for="inputPassword3" class="control-label">确认完成此订单吗？</label>
      
      
      
      
      </div>
      <div class="modal-footer">
        <a class="pull-right" href="staff/confirmreserve?rid=<%=score.getSale_id() %>&cid=<s:property value="customer_id"/>"><button type="submit" class="btn btn-primary" style='float:left'>确认</button></a>
      </div>
    </div>
  </div>
</div>


</html>
