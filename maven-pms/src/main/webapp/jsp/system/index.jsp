<%--
  Created by IntelliJ IDEA.
  User: guich
  Date: 2017/9/6
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/jsp/common/common.jsp"/>
    <head>
        <title>自助服务管理平台</title>
        <meta name="description" content="自助服务管理平台">
        <%--<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="index">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="icon" type="image/png" href="${ctx}/jsp/common/assets/i/app-icon72x72@2x.png">
        <link rel="apple-touch-icon-precomposed" href="${ctx}/jsp/common/assets/i/app-icon72x72@2x.png">
        <meta name="apple-mobile-web-app-title" content="Amaze UI" />
        <script src="${ctx}/jsp/common/assets/js/echarts.min.js"></script>
        <link rel="stylesheet" href="${ctx}/jsp/common/assets/css/amazeui.min.css" />
        <link rel="stylesheet" href="${ctx}/jsp/common/assets/css/amazeui.datatables.min.css" />
        <link rel="stylesheet" href="${ctx}/jsp/common/assets/css/app.css">
        <script src="${ctx}/jsp/common/assets/js/jquery.min.js"></script>--%>
        <jsp:include page="/jsp/common/headSetting.jsp"/>
    </head>

    <style>
        .am-tabs-nav li {
            position: relative;
            z-index: 1;
        }

        .am-tabs-nav .am-icon-close {
            position: absolute;
            top: 0;
            right: 10px;
            color: #888;
            cursor: pointer;
            z-index: 100;
        }

        .am-tabs-nav .am-icon-close:hover {
            color: #333;
        }

        .am-tabs-nav .am-icon-close ~ a {
            padding-right: 25px!important;
        }

        iframe {
            display: block;
            width: 100%;

            min-height: 500px;
        }
    </style>

    <body data-type="index" >
        <script src="${ctx}/jsp/common/assets/js/theme.js"></script>
        <jsp:include page="/jsp/common/header.jsp"/>
        <div class="am-g tpl-g">

            <!-- 侧边导航栏 -->
            <div class="left-sidebar" style="top: 80px;padding-top: 0px; ">
                <ul class="sidebar-nav topNav"></ul>
            </div>

            <div class="tpl-content-wrapper">
                <div class="am-tabs" data-am-tabs="{noSwipe: 1}" id="content-tabs">
                    <ul class="am-tabs-nav am-nav am-nav-tabs">
                        <li class="am-active my-tab"><a href="javascript: void(0)">首页</a></li>
                    </ul>
                    <div class="am-tabs-bd" style="border: 0px solid;">
                        <div class="am-tab-panel am-active">
                            <jsp:include page="/jsp/common/content.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="am-modal am-modal-loading am-modal-no-btn loading-flow " tabindex="-1" id="my-modal-loading">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">正在载入...</div>
                <div class="am-modal-bd">
                    <span class="am-icon-spinner am-icon-spin"></span>
                </div>
            </div>
        </div>
        <script src="${ctx}/jsp/common/assets/js/amazeui.min.js"></script>
        <script src="${ctx}/jsp/common/assets/js/amazeui.datatables.min.js"></script>
        <script src="${ctx}/jsp/common/assets/js/dataTables.responsive.min.js"></script>

        <script type="text/javascript">
            var menuList = '${menuList}';
            menuList = menuList ? JSON.parse(menuList) : [];
        </script>
        <script src="${ctx}/jsp/common/assets/js/menu.js?time=19"></script>
    </body>

</html>
