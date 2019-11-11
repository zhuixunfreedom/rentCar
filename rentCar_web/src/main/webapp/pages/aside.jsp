<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/8.png"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username" />
					<a href="#" style="font-size: 10px"><i class="fa fa-circle text-success"></i> 在线</a>
				</p>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>车辆管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/car/getSectionCars"> <i
							class="fa fa-circle-o"></i> 车辆查询
					</a></li>
					<li id="system-setting1"><a
						href="${pageContext.request.contextPath}/pages/car-add.jsp"> <i
							class="fa fa-circle-o"></i> 车辆添加
					</a></li>
					<li id="system-setting2" onclick="delet()"><a> <i
							class="fa fa-circle-o"></i> 车辆删除
					</a></li>
					<li id="system-setting3" onclick="update()"><a>
							<i class="fa fa-circle-o"></i> 车辆修改
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting2-1"><a
						href="${pageContext.request.contextPath}/product/getSectionPage">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li id="system-setting2-2"><a
						href="${pageContext.request.contextPath}/order/getSectionPage">
							<i class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>