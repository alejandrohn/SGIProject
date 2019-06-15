<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="headTitle.jsp" />

        <!-- Bootstrap core CSS -->
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
            <h2>Ficheros XML estáticos para probar encriptar y desencriptar</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">File Name</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>didlFilm1.xml</td>
                        
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>test.xml</td>
                        
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>test1.xml</td>
                        
                    </tr>
                </tbody>
            </table>

            <form class="form" method="post" action="encrypt">
                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
                    <input type="text" class="form-control"   name="docXMLToEncript" placeholder="doc xml">                                      
                </div>
                <input  class ="btn btn-primary" type="submit" value="Encriptar"/>
            </form>
            

            <form style="margin-top:20px;" class="form" method="get" action="encrypt">
                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
                    <input type="text" class="form-control"   name="docXMLToDesencript" placeholder="doc xml">                                      
                </div>
                <input  class ="btn btn-warning" type="submit" value="Desencriptar"/>
            </form>



        </div> <!-- /container -->


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    </body>
</html>
