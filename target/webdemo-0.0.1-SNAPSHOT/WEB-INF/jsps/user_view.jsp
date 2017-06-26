<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
        <title>用户列表页面</title>
        <link href="<%=request.getContextPath()%>/resources/css/all.css" rel="stylesheet" type="text/css" />
    </head>
    <body style="background: #e1e9eb;">
    <% 
  request.setAttribute("name","hello");
%>
使用EL表达式获取数据：${name}
${username}
编号为1的用户年龄是：${user.age},生日：${user.birthday}
        <form action="" id="mainForm" method="post">
            <div class="right">
                <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">用户管理</a> &gt; 内容列表</div>
                <div class="rightCont">
                    <p class="g_title fix">用户列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="#">删 除</a></p>
                    <table class="tab1">
                        <tbody>
                            <tr>
                                <td width="90" align="right">演示字段1：</td>
                                <td>
                                    <input type="text" class="allInput" value=""/>
                                </td>
                                <td width="90" align="right">演示字段2：</td>
                                <td>
                                    <input type="text" class="allInput" value=""/>
                                </td>
                                <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="zixun fix">
                        <table class="tab2" width="100%">
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" id="all" onclick="#"/></th>
                                    <th>序号</th>
                                    <th>用户ID</th>
                                    <th>用户年龄</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${userList}" var="user" varStatus="status">
                                    <tr>
	                                    <td><input type="checkbox" /></td>
	                                    <td>${status.index + 1}</td>
	                                    <td>${user.id}</td>
	                                    <td>${user.age}</td>
	                                    <td>
	                                        <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
	                                        <a href="#">删除</a>
	                                    </td>
	                                </tr>
                                </c:forEach>
                                
                                <tr style="background-color:#ECF6EE;">
                                    <td><input type="checkbox" /></td>
                                    <td>2</td>
                                    <td>演示值1</td>
                                    <td>演示值2</td>
                                    <td>
                                        <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
                                        <a href="#">删除</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" /></td>
                                    <td>3</td>
                                    <td>演示值1</td>
                                    <td>演示值2</td>
                                    <td>
                                        <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
                                        <a href="#">删除</a>
                                    </td>
                                </tr>
                                <tr style="background-color:#ECF6EE;">
                                    <td><input type="checkbox" /></td>
                                    <td>4</td>
                                    <td>演示值1</td>
                                    <td>演示值2</td>
                                    <td>
                                        <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
                                        <a href="#">删除</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class='page fix'>
                            共 <b>4</b> 条
                            <a href='###' class='first'>首页</a>
                            <a href='###' class='pre'>上一页</a>
                            当前第<span>1/1</span>页
                            <a href='###' class='next'>下一页</a>
                            <a href='###' class='last'>末页</a>
                            跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
                            <a href='###' class='go'>GO</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>