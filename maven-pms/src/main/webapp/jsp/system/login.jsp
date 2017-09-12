<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <style>
            .my-form-label {
                display: block;
                width: 8%;
                height: 37px;
                float: left;
                color: #ffffff;
            }

            .my-form-label span {
                height: 37px;
                text-align: center;
                padding-top: 8px;
                padding-bottom: 8px;
                font-size: 1.6rem;
                line-height: 1.2;
            }

            .my-form-input {
                background-color: #96a2b4!important;
                display: block!important;
                width: 90%!important;
                height: 37px!important;
                padding-top: 0px!important;
                padding-bottom: 0px!important;
            }

            .my-footer-default {
                background-color:#282d2f;
            }

            input:-webkit-autofill {
                -webkit-box-shadow: 0 0 0px 1000px white inset;
                -webkit-text-fill-color: #333;
            }

        </style>
    </head>

    <body data-type="login">
        <script src="${ctx}/jsp/common/assets/js/theme.js"></script>
        <div class="am-g tpl-g">
            <!-- 风格切换 -->
            <div class="tpl-skiner">
                <div class="tpl-skiner-toggle am-icon-cog">
                </div>
                <div class="tpl-skiner-content">
                    <div class="tpl-skiner-content-title">
                        选择主题
                    </div>
                    <div class="tpl-skiner-content-bar">
                        <span class="skiner-color skiner-white" data-color="theme-white"></span>
                        <span class="skiner-color skiner-black" data-color="theme-black"></span>
                    </div>
                </div>
            </div>
            <div class="tpl-login">
                <div class="tpl-login-content">
                    <div class="tpl-login-logo"></div>

                    <form class="am-form" action="${ctx}/user/login" method="post">
                        <div class="am-form-group">
                            <label for="userName" class="my-form-label"><span class="am-icon-sm am-icon-user"></span></label>
                            <input type="text" class="my-form-input" id="userName" name="userName" placeholder="请输入账号" />
                        </div>

                        <div class="am-form-group">
                            <label for="password" class="my-form-label"><span class="am-icon-sm am-icon-lock"></span></label>
                            <input type="password" class="my-form-input" id="password" name="password"  placeholder="请输入密码" />
                        </div>

                        <div class="am-form-group tpl-login-remember-me">
                            <input id="remember-me" type="checkbox">
                            <label for="remember-me" >记住密码</label>
                        </div>
                        <div class="am-form-group">
                            <button type="button" onclick="login()" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">登录</button>
                        </div>
                    </form>
                </div>
            </div>
            <footer data-am-widget="footer" class="am-footer am-footer-default my-footer-default" data-am-footer="{  }">
                <div class="am-footer-switch">
                    <span class="am-footer-ysp" data-rel="mobile" data-am-modal="{target: '#am-switch-mode'}">云适配版</span>
                    <span class="am-footer-divider">|</span>
                    <a id="godesktop" data-rel="desktop" class="am-footer-desktop"
                       href="#">电脑版</a>
                </div>
                <div class="am-footer-miscs ">
                    <p>由
                        <a href="http://www.yunshipei.com/" title="诺亚方舟" target="_blank">诺亚方舟</a>提供技术支持</p>
                    <p>CopyRight©2014 AllMobilize Inc.</p>
                    <p>京ICP备13033158</p>
                </div>
            </footer>

            <div class="am-modal am-modal-loading am-modal-no-btn loading-flow " tabindex="-1" id="my-modal-loading">
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">正在载入...</div>
                    <div class="am-modal-bd">
                        <span class="am-icon-spinner am-icon-spin"></span>
                    </div>
                </div>
            </div>
        </div>
        <script src="${ctx}/jsp/common/assets/js/amazeui.min.js"></script>
    </body>
</html>
