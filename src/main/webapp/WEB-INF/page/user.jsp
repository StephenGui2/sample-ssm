<%--
  Created by IntelliJ IDEA.
  User: junda.gui
  Date: 2018-12-16
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<script></script>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/AdminLTE.css">
    <script src="/js/jquery-2.2.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <title>用户管理</title>
</head>
<body>


<div class="box-header with-border" style="text-align: center;">
    <h3 class="box-title">用户管理</h3>
</div>

<div class="box-body">

    <!-- 数据表格 -->
    <div class="table-box" style="width: 60%;margin-left: 20%;">
        <div class="float-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary " title="新建" id="addUser" onclick="addModel()"><i
                            class="fa fa-file-o"></i> 新建
                    </button>
                    <button type="button" class="btn btn-primary " title="刷新" onclick="window.location.reload();"><i
                            class="fa fa-refresh"></i> 刷新
                    </button>
                </div>
            </div>
        </div>
        <!--数据列表-->
        <table id="dataList2" class="table table-bordered table-striped table-hover dataTable">
            <thead>
            <tr class="table-info">
                <th class="sorting_asc">用户编号</th>
                <th class="sorting">用户名</th>
                <th class="sorting">性别</th>
                <th class="sorting">年龄</th>
                <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td id="userId">${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.sex}</td>
                    <td>${user.age}</td>
                    <td class="text-center">
                        <button type="button" class="btn bg-olive btn-sm" onclick="showModel(this)">详情</button>
                        <button type="button" class="btn bg-olive btn-sm" onclick="modifyModel(this)">修改</button>
                        <button type="button" class="btn bg-olive btn-sm" onclick="deleteModel(this)"> 删除</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!--数据列表/-->


    </div>
    <!-- 数据表格 /-->


</div>


<div class="modal" id="deleteModel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">确定要删除吗？</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteUser()">确定</button>
            </div>
        </div>
    </div>
</div>


<div class="modal" id="modifyModel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">用户信息修改</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <table class="table text-blue">
                        <tr>
                            <td>
                                <label>用户编号：</label>
                            </td>
                            <td>
                                <input id="modify_userId" class="form-control" type="text" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>用户名：</label>
                            </td>
                            <td>
                                <input id="modify_name" class="form-control" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>性别：</label>
                            </td>
                            <td>
                                <select id="modify_sex" class="form-control">
                                    <option>男</option>
                                    <option>女</option>
                                </select>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <label>年龄：</label>
                            </td>
                            <td>
                                <input id="modify_age" class="form-control" type="text">
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <label>状态：</label>
                            </td>
                            <td>
                                <select id="modify_status" class="form-control">
                                    <option>使用</option>
                                    <option>注销</option>
                                </select>
                            <td>
                        </tr>
                    </table>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="modifyUser()">修改</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="showModel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">用户详情</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <table class="table text-blue">
                        <tr>
                            <td>
                                <label>用户编号：</label>
                            </td>
                            <td>
                                <input id="show_userId" class="form-control" type="text" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>用户名：</label>
                            </td>
                            <td>
                                <input id="show_name" class="form-control" type="text" readonly/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>性别：</label>
                            </td>
                            <td>
                                <input id="show_sex" class="form-control" type="text" readonly/>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <label>年龄：</label>
                            </td>
                            <td>
                                <input id="show_age" class="form-control" type="text" readonly/>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <label>状态：</label>
                            </td>
                            <td>
                                <input id="show_status" class="form-control" type="text" readonly/>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <label>创建时间：</label>
                            </td>
                            <td>
                                <input id="show_create_time" class="form-control" type="text" readonly/>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <label>更新时间：</label>
                            </td>
                            <td>
                                <input id="show_update_time" class="form-control" type="text" readonly/>
                            <td>
                        </tr>
                    </table>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<div class="modal" id="addModel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">新建用户</h4>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <table class="table text-blue">
                        <tr>
                            <td>
                                <label>用户名：</label>
                            </td>
                            <td>
                                <input id="new_name" class="form-control"
                                       name="new_name" type="text" placeholder="请输入用户名"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>性别：</label>
                            </td>
                            <td>
                                <select class="form-control" id="new_sex" name="new_sex">
                                    <option>男</option>
                                    <option>女</option>
                                </select>
                            <td>

                        </tr>
                        <tr>
                            <td>
                                <label>年龄：</label>
                            </td>
                            <td>
                                <input class="form-control" id="new_age" name="new_age" type="text"/>
                            <td>
                        </tr>
                    </table>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="addUser()">确定</button>
            </div>
        </div>
    </div>
</div>


<script>

    function addModel() {
        $("#addModel").modal("toggle");
    }

    function showModel(bt_show) {
        var userId = $(bt_show).parent().parent().children("#userId").html();

        $.ajax({
            url: "/user/find.do",
            type: "GET",
            data: {
                userId: userId
            },
            dataType: "json",
            success: function (resp) {

                if (resp.status == 0) {
                    var user = resp.data;
                    $("#show_userId").val(user.userId);
                    $("#show_name").val(user.name);
                    $("#show_age").val(user.age);
                    $("#show_status").val(user.status == 0 ? "使用" : "注销");
                    $("#show_sex").val(user.sex);
                    $("#show_create_time").val(user.createTime);
                    $("#show_update_time").val(user.updateTime);

                    $("#showModel").modal("toggle");
                } else {
                    alert(resp.message);
                }
            }
        });

    }

    function modifyModel(bt_modify) {
        var userId = $(bt_modify).parent().parent().children("#userId").html();

        $.ajax({
            url: "/user/find.do",
            type: "GET",
            data: {
                userId: userId
            },
            dataType: "json",
            success: function (resp) {

                if (resp.status == 0) {
                    var user = resp.data;

                    $("#modify_userId").val(user.userId);
                    $("#modify_name").val(user.name);
                    $("#modify_age").val(user.age);
                    $("#modify_status").val(user.status == 0 ? "使用" : "注销");
                    $("#modify_sex").val(user.sex);
                    $("#modifyModel").modal("toggle");
                } else {
                    alert(resp.message);
                }
            }
        });

    }

    var chooseId;

    function deleteModel(btn_delte) {
        chooseId = $(btn_delte).parent().parent().children("#userId").html();
        $("#deleteModel").modal("toggle");
    }

    function addUser() {
        $.ajax({
            url: "/user/add.do",
            type: "POST",
            data: {
                newName: $("#new_name").val(),
                newSex: $("#new_sex").val(),
                newAge: $("#new_age").val()
            },
            dataType: "json",
            success: function (resp) {

                if (resp.status == 0) {
                    alert("用户创建成功");

                    window.location.reload();
                } else {
                    alert(resp.message);
                }
            }
        });
    }


    function modifyUser() {
        $.ajax({
            url: "/user/update.do",
            type: "POST",
            data: {
                userId: $("#modify_userId").val(),
                newName: $("#modify_name").val(),
                newAge: $("#modify_age").val(),
                newSex: $("#modify_sex").val(),
                newStatus: $("#modify_status").val() == "使用" ? 0 : 1
            },
            dataType: "json",
            success: function (resp) {

                if (resp.status == 0) {
                    alert("用户修改成功");
                    window.location.reload();
                } else {
                    alert(resp.message);
                }
            }
        });
    }

    function deleteUser() {
        $.ajax({
            url: "/user/delete.do",
            type: "POST",
            data: {
                userId: chooseId
            },
            dataType: "json",
            success: function (resp) {

                if (resp.status == 0) {
                    alert("用户删除成功");
                    window.location.reload();
                } else {
                    alert(resp.message);
                }
            }
        });
    }


</script>
</body>
</html>
