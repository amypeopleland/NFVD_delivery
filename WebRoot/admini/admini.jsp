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
	background-image: url(../image/21508.jpg);
}
</style>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admini.jsp' starting page</title>
  
	

  </head>
  
  <body>
  <table width="1000" border="0" align="center">
  <tr>
    <td width="188" herf=""><input type="button" value="返回" onclick="window.location.href='index.jsp';"/></td>
    <td width="796" align="center"><h1><strong></strong>管理员操作系统</h1></td>
  </tr>
  <tr  >
    <td height="219" colspan="2" align="justify" ><ul id="MenuBar1" class="MenuBarHorizontal">
      <li ><a class="MenuBarItemSubmenu">进货</a>
        <ul>
        <%
        	int flag;
        	flag=1;//1 for Products
         %>
          <li><a href="<%=basePath%>servlet/ProductsNameList?flag=1"><% %>商品表</a></li>
          	<ul>
          		<li><a href="ProductsName/AddProductsNameList.jsp?flag=1">增加商品</a></li>
          		<!-- <li><a href="#">修改商品表</a></li> -->
          	</ul>
          <li><a href="<%=basePath%>servlet/ProductsNameList?flag=2">查看商品产地对照表</a></li>
          	<ul>
          		<li><a href="ProductVSArea/AddProductVSArea.jsp?flag=2">增加商品产地对照表</a></li>
          	</ul>
          <li><a href="<%=basePath%>servlet/ProductsNameList?flag=3">查看产地表</a></li>
          	<ul>
          		<li><a href="ProductArea/AddProductsAreaNameList.jsp?flag=3">增加产地表</a></li>
          	</ul>
					
</ul>
      </li>
      <li><a href="<%=basePath%>servlet/ListGoods" class="MenuBarItemSubmenu">库存</a>
        <ul>
          <li><a href="<%=basePath%>servlet/ProductsNameList?flag=4">增加货物</a></li>
          <li><a href="<%=basePath%>servlet/ListGoods">删除库存</a></li>
          <li><a href="admini/FindGoodsByID.jsp">修改库存</a></li>
          <li><a href="admini/FindGoodsByID.jsp">查询库存</a></li>
</ul>
      </li>
      <li><a class="MenuBarItemSubmenu" href="#">查看交易</a>
        <ul>
          <li><a href="#">查看交易</a>            </li>
</ul>
      </li>
      <li><a href="#" class="MenuBarItemSubmenu">管理会员</a>
        <ul>
          <li><a href="#">增加会员</a></li>
          <li><a href="#">删除会员</a></li>
          <li><a href="#">修改会员</a></li>
          <li><a href="#">查询会员</a></li>
        </ul>
      </li>
    </ul></td>
  </tr>
</table>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
</script>
  <!-- <table width="1000" border="0">
  	<tr>
    	<td width="188">返回</td>
    	<td width="796" align="center"><h1><strong></strong>管理员操作系统</h1></td>
  </tr>
  
  <tr>
  	<td height="219" colspan="2" align="center">
  	
  	</td>
  </tr>
  </table> -->
    <%-- 
      <%
    String admini_name=(String)session.getAttribute("admini_name");
     %>
     <%=admini_name %> --%>
  </body>
</html>
