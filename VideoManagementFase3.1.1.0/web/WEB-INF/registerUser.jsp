<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <jsp:include page="headTitle.jsp" />
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
    </head>
    <body>
        <div class="container">  
            <%  String classPanel = "panel-primary";

                String signUp = "";
                Boolean errorInCreateUser = (Boolean) request.getAttribute("errorInCreateUser");
                Boolean errorInPasswordUser = (Boolean) request.getAttribute("errorInPasswordUser");
                Boolean errorInEmptyValues = (Boolean) request.getAttribute("errorInEmptyValues");
                if (errorInCreateUser || errorInPasswordUser || errorInEmptyValues) {
                    classPanel = "panel-danger";
                } else {
                    signUp = "Sign up";
                
                }

                String messageErrorEmailorUsername = "";
                String messageErrorPassword = "";
                String messageErrorEmptyValues = "";

                if (errorInCreateUser) {
                    messageErrorEmailorUsername = "Username or email repeated";
                }

                if (errorInPasswordUser) {
                    messageErrorPassword = "Password must be the same";
                }

                if (errorInEmptyValues) {
                    messageErrorEmptyValues = "Empty fields";
                }
            %>
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel <%= classPanel%>" >
                    <div class="panel-heading">
                        <div class="panel-title">

                            <%= messageErrorEmailorUsername%>
                            <%= messageErrorPassword%>
                            <%= messageErrorEmptyValues%>
                            <%= signUp%>


                        </div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#"></a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                        <form action="registerUser" method="post" id="registerform" class="form-horizontal" role="form">

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="ematextil" class="form-control"   name="firstName" placeholder="Name">                                      
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control"  name="surname" placeholder="Surname">                                       
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon">@</span>
                                <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Email">                                       
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="" name="userName" placeholder="User Name">                                       
                            </div>


                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-confirmPassword" type="password" class="form-control" name="confirmPassword" placeholder="Confirm password">
                            </div>
                            <div class="input-group">
                                <div class="checkbox">
                                    <label>
                                        <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                    </label>
                                </div>
                            </div>
                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                    <button type="submit" class="btn btn-primary">Register User</button>
                                    <a href="loginUser">Sign In</a>
                                </div>
                            </div>
                        </form>     
                    </div>                     
                </div>  
            </div>

        </div>
    </body>
</html>
