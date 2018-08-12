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
	color: #000;
}
body {
	background-color: #FFF;
	
}
</style>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BuyerList.jsp' starting page</title>
    
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
   
    <table width="200" border="1" style="height: 208px; width: 823px; " bgcolor="#FFFF99">
  <caption>
    WELCOME TO NFVD DEVELIEVERY COMMUNITY
  </caption>
  <tr>
    <td align="center">货单号</td>
    <td align="center">商品名称</td>
    <td align="center">商品产地</td>
    <td align="center">商品价格</td>
    <td align="center">剩余数量</td>
    <td align="center">购买</td>
    <td align="center"><a href="<%=basePath%>servlet/Sender_check?flag=1">查看送货状态</td>
  </tr>
  <%
  	for (int i = 0; list != null && i < list.size(); i++) {
  	
  				Goods t=list.get(i);
  				String goods_name=t.getGoodsName();
  				//int goods_number=t.getGoodsNumber();
  				int goods_number=t.getGoodsId();
  				float goods_sell=t.getGoodsSell();
  				float goods_remain=t.getGoodsRemain();
  				String goods_areaName=t.getGoodsAreaName();
  
   %>
   
           
  <tr>
  <form>
  	<td align="center" name="goods_number"><%=goods_number%></td>
  	
  	<td align="center" name="goods_name"><%=goods_name%></td>
  	<td align="center" name="goods_areaName"><%=goods_areaName%></td>
  	<td align="center" name="goods_sell"><%=goods_sell%></td>
  	<td align="center" name="goods_remain"><%=goods_remain%></td>
  	<td align="center" ><a href="<%=basePath%>servlet/BuyerListComfirmPage?goods_number=<%=goods_number%>">购买</a></td>
  	
  	</form>
  </tr>
  <%} %>
  <td><input type="button" name="提交" value="退出登录" onclick="window.location.href='index.jsp';" ></td>
</table>
  </body>
</html>
