<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Goods" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
body,td,th {
	color: #000;
}
body {
	background-color: #FFF;
	background-image: url(../image/21508.jpg);
}
</style>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UpdateGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function msg()
  {
  alert("修改成功！");
  }
</script>
  
  <body>
  <%Goods te=(Goods)request.getAttribute("Goods"); %>
   <table width="941" height="62" border="0"  bgcolor="#FFFF99" align="center">
  <caption>
    进货管理系统
  </caption>
  <tr>
    <td height="56" align="center">序号</td>
    <td align="center">商品编d号</td>
    <td align="center">进价</td>
    <td align="center">售出价格</td>
    <td align="center">总数量</td>
    <td align="center">剩余数量</td>
   
  </tr>
  <tr>
  <form method="get" action="/NFVD_delivery/servlet/SetGoods">
    <td height="56" align="center"><input type="text" name="GOODS_ID" value="<%=te.getGoodsId() %>" ></td>
    <td align="center"><input type="text" name="GOODS_number" value="<%=te.getGoodsNumber() %>"></td>
    <td align="center"><input type="text" name="GOODS_bid" value="<%=te.getGoodsBid() %>"></td>
    <td align="center"><input type="text" name="GOODS_sell" value="<%=te.getGoodsSell()%>"></td>
    <td align="center"><input type="text" name="GOODS_sum" value="<%=te.getGoodsSum()%>"></td>
    <td align="center"><input type="text" name="GOODS_remain" value="<%=te.getGoodsRemain()%>"></td>
    <td align="center"><input type="submit" name="提交" value="确认修改" onclick="msg()" ></td>
    </form>
  </tr>
  
 
  
</table>
  </body>
</html>
