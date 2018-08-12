<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Buy" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SendPage.jsp' starting page</title>
    
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
  		List<Buy> list = (List<Buy>) request.getAttribute("d");
   %>
  <table width="200" border="0" style="height: 208px; width: 823px; " bgcolor="#FFFF99" align="center">
  <caption>
    快递送达状态通知单
  </caption>
  <tr>
    <td align="center">订单编号</td>
    <td align="center">商品编号</td>
    <td align="center">商品名称</td>
    <td align="center">商品产地</td>
    <td align="center">商品购买数量</td>
    <td align="center">送达状态</td>
    <td align="center">开始送达</td>
    <td align="center">签收</td>
  </tr>
  <%
  	for (int i = 0; list != null && i < list.size(); i++) {
  	
  				Buy t=list.get(i);
  				int sellNumber=t.getSellNumber();
  				String goods_name=t.getGoodsName();
  				int goods_number=t.getGoodsNumber();
  				int sold_sum=t.getGoodsSellSum();
  				String goods_areaName=t.getGoodsAreaName();
  				String Status_=t.getStatus_();
  
   %>
   
           
  <tr>
  <form>
    <td align="center" name="sell_Number"><%=sellNumber%></td>
  	<td align="center" name="goods_number"><%=goods_number%></td>
  	
  	<td align="center" name="goods_name"><%=goods_name%></td>
  	<td align="center" name="goods_areaName"><%=goods_areaName%></td>
  	<td align="center" name="goods_sell"><%=sold_sum%></td>
  	<td align="center" name="goods_remain"><%=Status_%></td>
  	<td align="center" ><a href="<%=basePath%>servlet/BuyChangeStatus?sta=0&sell_Number=<%=sellNumber%>">开始配送</a></td>
  	<td align="center" ><a href="<%=basePath%>servlet/BuyChangeStatus?sta=1&sell_Number=<%=sellNumber%>">已经签收</a></td>
  	</form>
  </tr>
  <%} %>
  <td><input type="button" name="提交" value="退出登录" onclick="window.location.href='index.jsp';" ></td>
</table>
  </body>
</html>
