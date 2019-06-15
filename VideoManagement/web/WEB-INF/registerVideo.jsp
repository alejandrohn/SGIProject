
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="headTitle.jsp" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

        <style>
            body {
                padding-top: 20px;
                padding-bottom: 20px;
            }

            .navbar {
                margin-bottom: 20px;
            }
        </style>
    </head>

    <body>

        <div class="container">

            <jsp:include page="header.jsp" />
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">     
                <%
                    Boolean errorInInsertVideo = (Boolean) request.getAttribute("errorInsertVideo");
                    String classPanel = errorInInsertVideo ? "panel-danger" : "panel-warning";
                    String messageError = errorInInsertVideo ? "Error in register video" : "Register Video";
                %>
                <div class="panel <%= classPanel%>" >
                    <div class="panel-heading">
                        <div class="panel-title">
                            <%= messageError%>
                        </div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#"></a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                        <form action="registerVideo" method="post" id="registerVideoform" class="form-horizontal" role="form">

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control"   name="title" placeholder="Title">                                      
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control"  name="autor" placeholder="Autor">                                       
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                <input type="date" class="form-control" id="exampleInputEmail1" name="createdDate" placeholder="Created date">                                       
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <input id='h' name='hour' type='number' min='0' max='24' placeholder="hour">
                                <label for='h' style="margin-right: 10px;">h</label>
                                <input id='m' name='minute' type='number' min='0' max='59'placeholder="minutes">
                                <label for='m' style="margin-right: 10px;">m</label>
                                <input id='s' name='seconds' type='number' min='0' max='59' placeholder="seconds">
                                <label for='s'>s</label>
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="" name="format" placeholder="Format">                                       
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="number" class="form-control" id="" name="repoductionNumber" placeholder="Reproduction Number">                                       
                            </div>
                            <textarea class="form-control" rows="3" name="description" placeholder="Description"></textarea>
                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                    <button type="submit" class="btn btn-warning">Register Video</button>
                                </div>
                            </div>
                        </form>  


                    </div>                     
                </div>  
            </div>

        </div> <!-- /container -->
        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    </body>
</html>





</body>
</html>
