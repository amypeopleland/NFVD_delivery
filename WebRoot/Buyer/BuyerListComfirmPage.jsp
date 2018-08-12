<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Goods" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
#form1 div {
	font-size: larger;
}
body {
	background-image: url(../image/1.jpg);
}
</style>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BuyerListComfirmPage.jsp' starting page</title>
    
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
  <form method="get" action="/NFVD_delivery/servlet/Buyadd" name="form1">
  <table width="200" border="1" style="width: 1119px; ">
  <caption  bgcolor="#FFFF99">
    WELCOME TO NFVD DEVELIEVERY COMMUNITY
  </caption>
  <tr bgcolor="#FFFF99">
    <td>商品编号</td>
    <td>商品名称</td>
    <td>商品产地</td>
    <td>商品价格</td>
    <td>剩余数量</td>
    <td>选择数量</td>
    <td>应付款</td>
    <td>购买</td>
  </tr>
  <tr  bgcolor="#FFFF99">
  <%Goods te=new Goods();
   te=(Goods)request.getAttribute("g");%>
    <td><input type="text" name="goods_number" value="<%=te.getGoodsNumber() %>" ></td>
    <td><input type="text" name="goods_name" value="<%=te.getGoodsName() %>" ></td>
    <td><input type="text" name="goods_areaName" value="<%=te.getGoodsAreaName() %>" ></td>
    <td><input type="text" name="goods_sell" value="<%=te.getGoodsSell() %>" ></td>
    <td><input type="text" name="goods_remain" value="<%=te.getGoodsRemain() %>" ></td>
     <td>
     <table>
     <tr>
    <td><input type=button value="+" onClick="setValue1(1);"></td>
    <td><input type=text name="amount" value=0></td>
	<td><input type=button value="-" onClick="setValue_1(-1);"></td><tr></table></form></td>
    <td><input type="text" name="sum" value="0" ></td>
    <td><input type="submit" name="提交" value="确认购买"  ></td>
    <td><input type="button" name="提交" value="返回" onclick="window.location.href='Buyer/BuyerList.jsp';" ></td>
   
  </tr>
</table>
</form>
   <script language="javascript">
   function setValue1(i)
	{


		if(parseInt(document.form1.amount.value)<=(parseInt(document.form1.goods_remain.value)-1))
  			document.form1.amount.value=parseInt(document.form1.amount.value)+i;
  		//alert(document.form1.amount.value);
  		var num=parseFloat(document.form1.amount.value);
  		var price=parseFloat(document.form1.goods_sell.value);
  		var sum=num*price;
  		document.form1.sum.value=sum;
	}   
	 function setValue_1(i)
	{


		if(parseInt(document.form1.amount.value)>=1)
  			document.form1.amount.value=parseInt(document.form1.amount.value)+i;
  		//alert(document.form1.amount.value);
  		var num=parseFloat(document.form1.amount.value);
  		var price=parseFloat(document.form1.goods_sell.value);
  		var sum=num*price;
  		document.form1.sum.value=sum;
	}   
   </script>
  </body>
</html>
