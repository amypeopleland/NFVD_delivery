<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
body {
	background-image: url(../image/13035.jpg);
}
.body {
	font-size: x-large;
}
</style>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FindGoodsByID.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
   <table width="510"   align="center" border="0"  bgcolor="#FFFF99">
  <caption  bgcolor="#FFFF99">
    <div align="center"><span style=" color: 0000;"><br>请输入需要查找的商品id号</span></div><br>
  </caption>
  <tr>
    <td width="500" align="center"><div align="center" class="body">序号</div></td>
  </tr>
  <tr>
    <td align="center">
    <form method="get" action="/NFVD_delivery/servlet/UpdateGoods">
      <label for="GOODS_ID"></label>
      <input type="text" name="GOODS_ID" id="GOODS_ID" />
      <input type="submit" name="提交" value="查找" >
    </form></td>
  </tr>
 <!--  <input name="" type="image" src="../0339694554c742e00000158fc017fd1.png" /> -->
  
  <td><input type="button" name="提交" value="返回" onclick="window.location.href='admini/admini.jsp';" ></td>
</table>
  </body>
</html>
