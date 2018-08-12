<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
body,td,th {
	color: #000;
}
body {
	background-color: #FFF;
	background-image: url(../image/gggg.jpg);
}
</style>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddProductsAreaNameList.jsp' starting page</title>
    
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
   <form method="get" action="/NFVD_delivery/servlet/AddGoodsName">
     <table width="200" border="1" bgcolor="#FFFF99" align="center">
  <caption>
    商品表
  </caption>
   <%
    	int flag=3;
    	session.setAttribute("flag", flag);
     %>
  <tr>
   
    <td align="center">商品产地编号</td>
    <td align="center">商品产地名称</td>
     <td align="center"></td>
  </tr>
  <tr>
  
   
     <td align="center"><input type="text" name="GOODS_AreaNum"></td>
    <td align="center"><input type="text" name="GOODS_AreaName"></td>
     <td align="center"><input type="submit" name="提交" value="提交"></td>
    <td><input type="button" name="提交" value="返回" onclick="window.location.href='admini/admini.jsp';" ></td>
  </tr>
</table>
 </form>
  </body>
</html>
