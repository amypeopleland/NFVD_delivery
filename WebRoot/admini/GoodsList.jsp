<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Goods" %>
<%@ page import="com.Dao.Products" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<style type="text/css">
body,td,th {
	
}
body {
	
	background-image: url(../image/1.jpg);
}
</style>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GoodsList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  		List<Goods> list = (List<Goods>) request.getAttribute("list");
   %>
   
   <form method="get" action="/NFVD_delivery/servlet/AddGoods">
   <table width="941" height="62" border="1" bgcolor="#FFFF99" align="center">
  <caption style="width: 606px; ">
    进货管理系统
  </caption>
  <tr>
  <td><input type="button" value="返回" onclick="window.location.href='admini/admini.jsp';"/></td>
  </tr>
  <tr>
    <td height="56" align="center">序号</td>
    <td align="center">商品编号</td>
    <td align="center">商品名称</td>
    <td align="center">进价</td>
    <td align="center">售出价格</td>
    <td align="center">总数量</td>
    <td align="center">剩余数量</td>
    <td align="center">删除记录</td>
    <td align="center">修改记录</td>
  </tr>
  <%
  	for (int i = 0; list != null && i < list.size(); i++) {
  	
  				Goods t=list.get(i);
  				int goods_id=t.getGoodsId();
  				String goods_name=t.getGoodsName();
  				int goods_number=t.getGoodsNumber();
  				float goods_bid=t.getGoodsBid();
  				float goods_sell=t.getGoodsSell();
  				float goods_sum=t.getGoodsSum();
  				float goods_remain=t.getGoodsRemain();
  
   %>
   
           
  <tr>
  <form>
  	<td align="center"><%=goods_id%></td>
  	<td align="center"><%=goods_number%></td>
  	<td align="center"><%=goods_name%></td>
  	<td align="center"><%=goods_bid%></td>
  	<td align="center"><%=goods_sell%></td>
  	<td align="center"><%=goods_sum%></td>
  	<td align="center"><%=goods_remain%></td>
  	<td align="center">
  		<a href="/NFVD_delivery/servlet/DeleteGoods?GOODS_ID=<%=goods_id%>">删除</a></td>
  		
  	<td align="center">
  		<a href="/NFVD_delivery/servlet/UpdateGoods?GOODS_ID=<%=goods_id%>">修改</a></td>
  </tr>
  
  <%} %>
</table>
</form>
  </body>
</html>
