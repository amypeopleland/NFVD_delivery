<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Products" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
body,td,th {
	color: #000;
}
body {
	background-color: #FFF;
	background-image: url(../image/dddd.jpg);
}
</style>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProductVSAreaList.jsp' starting page</title>
    
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
  		List<Products> list = (List<Products>) request.getAttribute("list");
   %>
  <table width="200" border="1" bgcolor="#FFFF99">
  <caption>
    商品表
  </caption>
  <tr>
    <td align="center">商品编号</td>
    <td align="center">商品名称</td>
    <td align="center">商品产地编号</td>
    <td align="center">商品产地名称</td>
    <td align="center">删除记录</td>
    <td align="center">修改记录</td>
  </tr>
  <%
  //	Priducts t=new Pruducts();
  	for(int i=0;list!=null && i<list.size();i++){
  		Products p=list.get(i);
  		String goods_name=p.getGoodsName();
  		int goods_number=p.getGoodsNumber();
  		int goods_areaNum=p.getGoodAreaNum();
  		String goods_areaName=p.getGoodArea();
  		%>
  		<tr>
    	<td align="center"><%=goods_number %></td>
    	<td align="center"><%=goods_name %></td>
    	<td align="center"><%=goods_areaNum %></td>
    	<td align="center"><%=goods_areaName %></td>
    	<td align="center"><a href="<%=basePath%>servlet/DeleteProducts?GOODS_number=<%=goods_number%>&flag=2">删除</td>
   		<td align="center"><a href="<%=basePath%>servlet/SetProducts?GOODS_number=<%=goods_number%>&flag=2">修改</td>
  		</tr>
  		
  	<%	
  	}
   %>
  <td><input type="button" name="提交" value="返回" onclick="window.location.href='admini/admini.jsp';" ></td>
  
  </body>
</html>
