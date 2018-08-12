<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Products" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpdateProductVSArea.jsp' starting page</title>
    
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
   Products te=(Products)request.getAttribute("p");
    %>
    <form method="get" action="/NFVD_delivery/servlet/UpdateProducts">
  <table width="200" border="1" bgcolor="#FFFF99">
  <caption>
    商品表
  </caption>
  <tr>
    <td align="center">商品编号</td>
    <td align="center">商品名称</td>
    <td align="center">商品产地编号</td>
    <td align="center">商品产地名称</td>
    
  </tr>
  <tr>
    <td align="center"><input type="text" name="GOODS_number" value="<%=te.getGoodsNumber() %>" ></td>
    <td align="center"><input type="text" name="GOODS_name" value="<%=te.getGoodsName() %>" ></td>
    <td align="center"><input type="text" name="GOODS_AreaNum" value="<%=te.getGoodAreaNum() %>" ></td>
    <td align="center"><input type="text" name="GOODS_AreaName" value="<%=te.getGoodArea() %>" ></td>
     <td align="center"><input type="submit" name="提交" value="确认修改"  ></td>
    
     <%
    	int flag=2;
    	session.setAttribute("flag", flag);
     %>
  </tr>
  <td><input type="button" name="提交" value="返回" onclick="window.location.href='admini/admini.jsp';" ></td>
  
  
</table>
</form>
  </body>
</html>
