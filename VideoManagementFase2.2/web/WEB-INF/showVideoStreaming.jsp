<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headTitle.jsp" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.plyr.io/3.5.3/plyr.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
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

            <% String title = (String) request.getAttribute("title");%>
            <h2 class="text-center text-success"><%= title%></h2>

            <jsp:include page="playbackVideo.jsp" />

            <p style="text-align: center; margin-top: 5px;" class="text-info">Reproductions Number: <%= request.getAttribute("reproductionsNumber")%></p>

            <div style="text-align: center; margin-top: 20px;">
                <a href="videoList" class="btn btn-primary" >Back to Video List</a>
            </div>

            <script src="https://cdn.plyr.io/3.5.3/plyr.js"></script>
            <script src="https://cdn.plyr.io/3.5.3/plyr.polyfilled.js"></script>
            <script>
                const player = new Plyr('#player');
            </script>
    </body>
</html>
