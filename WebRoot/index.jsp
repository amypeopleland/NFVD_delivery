<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style type="text/css">
.body {
	font-size: x-large;
}
</style>
<html>
<head>
<base href="<%=basePath%>">

<title>NFVD DELIVERY COMMUNITY</title>



</head>

<body >
<form method="get" action="/NFVD_delivery/servlet/LoginRequest">
<table width="700" border="0" align="center">

  <tr >
   <td colspan="2"><div align="center"><span class="body" ><u>NFVD DEVELIEVERY COMMUITY</u></span></div></td>
  </tr>
  <tr>
    <td width="296" width="184" ><div align="right">用户名：</div></td>
    <td width="398" width="184" >
      <label for="textfield"></label>
      <input type="text" name="name" />
      </td>
  </tr>
  <tr width="184" >
    <td><div align="right" >密码：</div></td>
    <td>
      <label for="textfield2"></label>
      <input type="password" name="pwd"  />
    </td>
  </tr>
  <tr width="184" >
    <td colspan="2"><table width="700" border="0">
      <tr>
        <td width="295">
          <div align="center">
         	 没有账号？
            <a href="add.jsp?id=1">注册一个</a>
          </div>
          </td>
        <td width="398">
          <div align="center">
            <input type="submit" name="login" id="submit" value="登陆" />
          </div>
       </td>
      </tr>
    </table></td>
  </tr>
  
</table>
 </form>
</body>
</html>
