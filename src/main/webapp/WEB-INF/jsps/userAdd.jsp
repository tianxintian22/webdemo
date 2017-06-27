<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
        <title>用户编辑</title>
        <link href="<%=request.getContextPath()%>/resources/css/all.css" rel="stylesheet" type="text/css" />
    </head>
    <body style="background: #e1e9eb;">
        <form action="<%= request.getContextPath()%>/users/save" id="mainForm" method="post">
            <div class="right">
                <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">用户管理</a> &gt; 用户编辑</div>
                <div class="rightCont">
                    <p class="g_title fix">用户编辑</p>
                    <table class="tab1">
                        <tbody>
                            <tr>
                                <td width="90" align="right">姓名：</td>
                                <td>
                                    <input type="text" class="allInput" name="user_name" value=""/>
                                </td>
                                
                            </tr>
                            <tr>
                                <td width="90" align="right">年龄：</td>
                                <td>
                                    <input type="text" class="allInput" name="age" value=""/>
                                </td>
                            </tr>
                            <tr>
                                <td width="90" align="right">性别：</td>
                                <td>
                                    <input type="text" class="allInput" name="sex" value=""/>
                                </td>
                            </tr>
                            <tr>
                                <td width="90" align="right">联系方式：</td>
                                <td>
                                    <input type="text" class="allInput" name="mobile" value=""/>
                                </td>
                            </tr>
                            <tr>
                                <td width="90" align="right">邮箱：</td>
                                <td>
                                    <input type="text" class="allInput" name="email" value=""/>
                                </td>
                            </tr>
                            <tr>
                                <td width="90" align="right"></td>
                                <td>
                                    <input type="submit" id="btnPass"  value="提交" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>