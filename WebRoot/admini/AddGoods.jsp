<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.Dao.Products" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
.body {
	text-align: center;
}
.body {
	font-size: xx-large;
}
body {
	color: 0000;
}
</style>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddGoods.jsp' starting page</title>
    
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
    <div align="center"><span style="text-decoration: underline">
    
   
  <form method="get" action="/NFVD_delivery/servlet/AddGoods">
   <table width="941" height="62" border="1" align="center"  bgcolor="#FFFF99" >
  <caption>
    进货管理系统
  </caption>
  <tr>
    <td height="56" align="center">序号</td>
    <td align="center">商品编号</td>
    <td align="center">商品名称</td>
    <td align="center">进价</td>
    <td align="center">售出价格</td>
    <td align="center">总数量</td>
    <td align="center">剩余数量</td>
  </tr>
  
  <tr>
  	<td height="56" align="center"><input type="text" name="GOODS_ID"></td>
  	<td align="center"><input type="text" name="GOODS_number"></td>
  	<td align="center">
  		<select name="selectName" id="selectAge">
						<%
							//	Priducts t=new Pruducts();
							for (int i = 0; list != null && i < list.size(); i++) {
								Products p = list.get(i);
								String goods_name = p.getGoodsName();
								int goods_number = p.getGoodsNumber();
						%>
						 <option value="2"><%=goods_name%></option>

						<%
							}
						%> 
           
      </select>
  	</td>
    <td align="center"><input type="text" name="GOODS_bid"></td>
    <td align="center"><input type="text" name="GOODS_sell"></td>
    <td align="center"><input type="text" name="GOODS_sum"></td>
    <td align="center"><input type="text" name="GOODS_remain"></td>
  </tr>
  <tr>
  	<td height="56" align="center"></td>
  	<td align="center"></td>
    <td align="center"></td>
    <td align="center"></td>
    <td align="center"></td>
    <td align="right"><input type="submit" name="提交" value="提交"></td>
  </tr>
</table>
</form>
  </body>
  <script type="text/javascript">   
        //获得下拉列表对象   
        oListbox = document.getElementById("selectName");   
        var ListUtil = new Object();   
           
  
        var selectbtn = document.getElementById("selectbtn");   
  
         function getSelAge (){   
        //访问选项   
            alert(oListbox.options[1].firstChild.nodeValue); //显示的内容   
  
            alert(oListbox.options[1].getAttribute("value"));//对应的value   
  
            alert("获得它在集合中的位置== " + oListbox.options[2].index); //获得它在集合中的位置   
  
            alert("获得集合的元素个数长度== " + oListbox.options.length); //获得集合的元素个数长度   
        }   
        </script>
        <td><input type="button" name="提交" value="返回" onclick="window.location.href='admini/admini.jsp';" ></td>
</html>
