<%--
  Created by IntelliJ IDEA.
  User: xiaogch
  Date: 17-9-10
  Time: 下午3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/jsp/common/common.jsp"/>
        <title>Title</title>
        <style>
            th {
                text-align: -webkit-center!important;
            }
        </style>
    </head>
    <body>

    <!-- 内容区域 -->
    <%--<div class="tpl-content-wrapper">--%>
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">用户列表</div>
                        </div>
                        <div class="widget-body  am-fr">
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                            <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--<div class="am-u-sm-12 am-u-md-6 am-u-lg-3">--%>
                                <%--<div class="am-form-group tpl-table-list-select">--%>
                                    <%--<select data-am-selected="{btnSize: 'sm'}">--%>
                                        <%--<option value="option1">所有类别</option>--%>
                                        <%--<option value="option2">IT业界</option>--%>
                                        <%--<option value="option3">数码产品</option>--%>
                                        <%--<option value="option3">笔记本电脑</option>--%>
                                        <%--<option value="option3">平板电脑</option>--%>
                                        <%--<option value="option3">只能手机</option>--%>
                                        <%--<option value="option3">超极本</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="am-u-sm-12 am-u-md-12 am-u-lg-3">--%>
                                <%--<div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">--%>
                                    <%--<input type="text" class="am-form-field ">--%>
                                    <%--<span class="am-input-group-btn">--%>
                                        <%--<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>--%>
                                    <%--</span>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="user_table">
                                    <thead>
                                    <tr>
                                        <th key="userName" align="center">用户名</th>
                                        <th key="nickname" align="center">昵称</th>
                                        <th key="phone" align="center">手机号码</th>
                                        <th key="email" align="center">邮箱</th>
                                        <th key="createTime" align="center">创建时间</th>
                                        <th key="opt" formatter="formatOpt" align="center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <%--<tr class="gradeX">--%>
                                            <%--<td>Amaze UI 模式窗口</td>--%>
                                            <%--<td>张鹏飞</td>--%>
                                            <%--<td>2016-09-26</td>--%>
                                            <%--<td>--%>
                                                <%--<div class="tpl-table-black-operation">--%>
                                                    <%--<a href="javascript:;">--%>
                                                        <%--<i class="am-icon-pencil"></i> 编辑--%>
                                                    <%--</a>--%>
                                                    <%--<a href="javascript:;" class="tpl-table-black-operation-del">--%>
                                                        <%--<i class="am-icon-trash"></i> 删除--%>
                                                    <%--</a>--%>
                                                <%--</div>--%>
                                            <%--</td>--%>
                                        <%--</tr>--%>
                                        <%--<tr class="even gradeC">--%>
                                            <%--<td>有适配微信小程序的计划吗</td>--%>
                                            <%--<td>天纵之人</td>--%>
                                            <%--<td>2016-09-26</td>--%>
                                            <%--<td>--%>
                                                <%--<div class="tpl-table-black-operation">--%>
                                                    <%--<a href="javascript:;">--%>
                                                        <%--<i class="am-icon-pencil"></i> 编辑--%>
                                                    <%--</a>--%>
                                                    <%--<a href="javascript:;" class="tpl-table-black-operation-del">--%>
                                                        <%--<i class="am-icon-trash"></i> 删除--%>
                                                    <%--</a>--%>
                                                <%--</div>--%>
                                            <%--</td>--%>
                                        <%--</tr>--%>
                                    </tbody>
                                </table>
                            </div>
                            <div class="am-u-lg-12 am-cf" id="user_table_pagination">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <%--</div>--%>
    <script>
        $(function() {
            var tableData = {
                rows:[
                    {
                        userName:"xiaogch",
                        nickname:"掌柜的",
                        email:"xiaogch@163.com",
                        phone:"15279116224",
                        createTime:"2017-09-10 17:00:00"
                    },
                    {
                        userName:"admin",
                        nickname:"系统管理员",
                        email:"amdin@163.com",
                        phone:"18102256338",
                        createTime:"2017-09-10 17:00:00"
                    },
                    {
                        userName:"yudm",
                        nickname:"于冬梅",
                        email:"yudm@163.com",
                        phone:"18070135625",
                        createTime:"2017-09-10 17:00:00"
                    }],
                pageInfo:{
                    currentPageNo:2,
                    pageSize:10, //每页数量
                    totalPageSize:5,//总页数
                    totalRecordSize:49, //总数
                    recordSize:1 //当前数量private int
                }
            }
            fillTabe("user_table" , tableData);
        });

        function fillTabe(tableId , tableData) {
            if (tableId) {
                $table = $("#" + tableId);
                $ths = $table.find("th");
                $tbody = $table.find("tbody");
                if (tableData.rows && tableData.rows.length > 0) {
                    for (var dataIndex =0 ; dataIndex < tableData.rows.length ; dataIndex ++) {
                        var data = tableData.rows[dataIndex];
                        var tr = $('<tr></tr>');
                        if (dataIndex%2 == 0) {
                            tr.addClass("gradeX");
                        } else {
                            tr.addClass("even").addClass("gradeC");
                        }

                        for (var index = 0 ; index < $ths.length ; index++) {
                            // eval(functionName + '()');
                            var key = $ths.eq(index).attr("key");
                            var formatter = $ths.eq(index).attr("formatter");
                            var value = data[key];
                            var td = $('<td></td>')
                            td.css("text-align" , $ths.eq(index).attr("align"));
                            if (formatter) {
                                var func = eval(formatter);
                                td.html(callFunction(func , [value, data, dataIndex]));
                            } else {
                                td.html(value);
                            }
                            tr.append(td);
//                            console.info("th index=" + index + " key=" + $ths.eq(index).attr("key") + " formatter=" + $ths.eq(index).attr("formatter"))
                        }
                        $tbody.append(tr);
                    }

                }
            }
        }

        function formatOpt(value , data , index) {
            console.info("formatOpt be call value=" + value + " data=" + data.toString() + " index=" + index);
            return'<div class="tpl-table-black-operation"><a href="javascript:;"><i class="am-icon-pencil"></i> 编辑</a><a href="javascript:;" class="tpl-table-black-operation-del"><i class="am-icon-trash"></i> 删除</a></div>';
        }


        function callFunction(func , parameter) {
            return func.apply(this , parameter);
        }

    </script>
    <script src="${ctx}/jsp/common/assets/js/datatabe.js?time=2"/>
    </body>

</html>
