<%@page import="beans.SalePlanList"%>
<%@page import="beans.Commodity_view"%>
<%@page import="beans.SalePlan_view"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
 <%@ taglib uri="/struts-tags" prefix="s"%> 

<!DOCTYPE html>


<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>历史数据</title>
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
                  <%=session.getAttribute("staff_name") %> - Manager
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
		
      
        <li><a href="<%=request.getContextPath()%>/staff/mplan"><i class="fa fa-toggle-right"></i><span>审批计划</span></a></li>
         <li class="treeview active">
          <a href="#"><i class="fa-bar-chart fa"></i> <span>统计数据</span></a>
          <ul class="treeview-menu">
            <li><a href="<%=request.getContextPath()%>/staff/stat"><i class="fa fa-sort-numeric-asc"></i><span>总计数据</span></a></li>
            <li><a href="<%=request.getContextPath()%>/staff/stata"><i class="fa  fa-signal"></i><span>历史数据</span></a></li>
          </ul>
        </li>
        
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
  		历史数据
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> SweetLife</a></li>
        <li class="active">History Stats</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">


		
        <div class="row">
        
        <div>
        <form class="form-horizontal" action="staff/stata">
              
                <div class="form-group">
	

                    
                    <div class="col-sm-1">
					<label for="exampleInputEmail1" class="pull-right"><h4  style="margin-top:3">月份</h4></label>
					
					</div>
                    
                     <div class="col-sm-2">
                    	<input  type="month" class="form-control col-sm-2"  name="month" value="2016-03">
                    
                    </div>
                    
          

                    <button type="submit" class="btn btn-info pull-left col-sm-1">显示数据</button>

                </div>


                
                
             
              <!-- /.box-footer -->
            </form>
        
        </div>

        <div class="col-md-6">






		<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">店铺销售</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <canvas id="saled" style="height: 168px; width: 343px;" width="343" height="168"></canvas>
              </div>
            </div>
            <!-- /.box-body -->
          </div>


		<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">热卖产品</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <canvas id="hotd" style="height: 168px; width: 343px;" width="343" height="168"></canvas>
              </div>
            </div>
            <!-- /.box-body -->
          </div>
          
          </div>

        
        <div class="col-md-6">
        




			<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">店铺预订</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <canvas id="reserved" style="height: 168px; width: 343px;" width="343" height="168"></canvas>
              </div>
            </div>
            <!-- /.box-body -->
          </div>
			


          </div>


        



          </div>



		

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

<script src="<%=request.getContextPath()%>/public/plugins/chartjs/Chart.js"></script>

</body>

<script type="text/javascript">


 var areaChartOptions = {
   //Boolean - If we should show the scale at all
   showScale: true,
   //Boolean - Whether grid lines are shown across the chart
   scaleShowGridLines: false,
   //String - Colour of the grid lines
   scaleGridLineColor: "rgba(0,0,0,.05)",
   //Number - Width of the grid lines
   scaleGridLineWidth: 1,
   //Boolean - Whether to show horizontal lines (except X axis)
   scaleShowHorizontalLines: true,
   //Boolean - Whether to show vertical lines (except Y axis)
   scaleShowVerticalLines: true,
   //Boolean - Whether the line is curved between points
   bezierCurve: true,
   //Number - Tension of the bezier curve between points
   bezierCurveTension: 0.3,
   //Boolean - Whether to show a dot for each point
   pointDot: false,
   //Number - Radius of each point dot in pixels
   pointDotRadius: 4,
   //Number - Pixel width of point dot stroke
   pointDotStrokeWidth: 1,
   //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
   pointHitDetectionRadius: 20,
   //Boolean - Whether to show a stroke for datasets
   datasetStroke: true,
   //Number - Pixel width of dataset stroke
   datasetStrokeWidth: 2,
   //Boolean - Whether to fill the dataset with a color
   datasetFill: true,
   //String - A legend template
   //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
   maintainAspectRatio: true,
   //Boolean - whether to make the chart responsive to window resizing
   responsive: true
 };


 var areaChart = new Chart(document.getElementById("saled").getContext("2d"));
 areaChart.Pie(<%=session.getAttribute("saled").toString()%>, areaChartOptions);
 
 var areaChart = new Chart(document.getElementById("reserved").getContext("2d"));
 areaChart.Pie(<%=session.getAttribute("reserved").toString()%>, areaChartOptions);
 

 var areaChart = new Chart(document.getElementById("hotd").getContext("2d"));
 areaChart.Bar(<%=session.getAttribute("hotd").toString()%>, areaChartOptions);
 
</script>


</html>
