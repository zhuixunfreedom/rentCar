<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 页面头部 -->
<header class="main-header">
	<!-- Logo -->
	<a href="all-admin-index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>租车</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>租车</b>后台管理系统</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${pageContext.request.contextPath}/img/8.png"
						class="user-image" alt="User Image"> <span class="hidden-xs">
					<security:authentication property="principal.username" />
					</span>

				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header" style="background: white"><img
							src="${pageContext.request.contextPath}/img/8.png"
							class="img-circle" alt="User Image"></li>

						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">修改密码</a>
							</div>
							<div class="pull-right">
								<a href="${pageContext.request.contextPath}/index.jsp"
									class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul></li>
				<li class="dropdown user user-menu"><a href="#"
													   class="dropdown-toggle" data-toggle="dropdown"> <img
						src="${pageContext.request.contextPath}/img/2.png"
						class="user-image" alt="User Image"> <span class="hidden-xs">
							设置
					<%--<security:authentication property="principal.username" />--%>
					</span>

				</a></li>
				<li class="dropdown user user-menu"><a href="${pageContext.request.contextPath}/logout"> <img
						src="${pageContext.request.contextPath}/img/1.png"
						class="user-image" alt="User Image"> <span class="hidden-xs">
							退出
					<%--<security:authentication property="principal.username" />--%>
					</span>

				</a></li>

			</ul>
		</div>
	</nav>
</header>
<!-- 页面头部 /-->