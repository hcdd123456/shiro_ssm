<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap登录</title>
</head>

<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />

<body>

<a style="display:block;width:200px;height:42px;line-height:42px;font-size:18px;text-align:center;margin:40px auto;font-weight:800;" href="#" class="tbox">点击弹出</a>

<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <h4 class="modal-title" align="center">登录框</h4>
                <br/>
                <form id ="form" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/login" method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-offset-2 col-sm-2 control-label">账号</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control"
                                   name="username" id="name" placeholder="请输您的入账号" check-type="required" required-message="账号不能为空！" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-offset-2 col-sm-2 control-label">密码</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control"
                                   name="password"id="password" placeholder="请输入您的密码" check-type="required" required-message="密码不能为空！" >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-5">
                            <button id="submitBtn" type="submit" class="btn btn-default btn-block btn-primary">登录</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-5">
                            <a href="regist.jsp">注册</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
        <!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    $(function(){

        $(".tbox").click(function(){
            $('#myModal').modal('show') //显示模态框
        })

    });
</script>
<script type="text/javascript">
    $(function(){
        $('#form').validation();//自定义form表单的id
    })
</script>
</body>
</html>