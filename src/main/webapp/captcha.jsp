<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>验证码</title>
    <script type="text/javascript">
        //点击切换验证码
        function changeVerifyCode(img){
            img.src = "Kaptcha?"+Math.floor(Math.random()*100);
        }
    </script>
</head>
<body>

<p>
<form action="result.jsp">
    <table>
        <tr>
            <td>
                &nbsp;
            </td>
            <td>
                <img src="Kaptcha" onclick="changeVerifyCode(this)" style="cursor: pointer;">
            </td>
        </tr>
        <tr>
            <td>
                请输入验证码：
            </td>
            <td>
                <input type="text" name="verifyCode">
            </td>
        </tr>
        <tr>
            <td>
                &nbsp;
            </td>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>


    </table>
</form>
</body>
</html>