<%@ page import="java.util.Random" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="GBK">
</head>
<body>
<%--<jsp:forward page="/pages/main.jsp"></jsp:forward>--%>
<%----%>
<img src="${pageContext.request.contextPath}/${car.carImg}">
<h1>商店信息：${shop}</h1>
<h1>车辆信息：${car}</h1>
<h1>订单信息：${order}</h1>
<h1>用户信息：${user}</h1>
<h1>评论信息：${comment}</h1>
<h2>Hello World!</h2>
<%--<input type="hidden" name="id" value="1">--%>
<a href="${pageContext.request.contextPath}/order/findById?id=1">获取1号订单详情</a><br/>
<a href="${pageContext.request.contextPath}/order/findAll">获取所有订单</a><br/>
<a href="${pageContext.request.contextPath}/order/findUndoneOrder">获取未完成订单</a><br/>
<a href="${pageContext.request.contextPath}/order/findNotCommentOrder">获取未评价订单</a><br/>


<form method="post" action="${pageContext.request.contextPath}/order/goAlipay">
<input type="text" name="ordernum" readonly value="<%=new Random().nextInt(123456789)%>"><br/>
<input type="text" name="ordername"  placeholder="商品名"><br/>
<input type="text" name="ordermoney"  placeholder="价格"><br/>
    <%--<c:if test="${order==null}">--%>
        <%--<input type="submit" value="去支付" disabled>--%>
    <%--</c:if>--%>
    <%--<c:if test="${order!=null}">--%>
        <input type="submit" value="去支付">
    <%--</c:if>--%>
    <br/>
</form>
</body>
</html>
