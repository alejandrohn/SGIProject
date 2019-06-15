<%@page import="java.util.List"%>
<%@page import="controllers.Video"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="headTitle.jsp" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

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
        <script src="js/utilsVideoSearch.js"></script>
    </head>
    <body>
        <div class="container">

            <jsp:include page="header.jsp" />
            <jsp:include page="searchForm.jsp" />

            <% if (!(request.getAttribute("selectedVideos") == null)) { %>
            <div class="table-responsive" style="margin-top:20px;">
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                        <tr class="info">
                            <th scope="col">Title</th>
                            <th scope="col">Autor</th>
                            <th scope="col">Date</th>
                            <th scope="col">Duration</th>
                            <th scope="col">Reproduction</th>
                            <th scope="col">Description</th>
                            <th scope="col">Format</th>
                        </tr>
                    </thead> 
                   <tbody>

                        <% for (controllers.Video video : (List<controllers.Video>) request.getAttribute("selectedVideos")) {
                        %>
                        <tr>
                            <td><%= video.getTitle()%></td>
                            <td><%= video.getAutor()%></td>
                            <td><%= Date.valueOf(video.getCreatedDate().toString().split("T")[0])%></td>
                            <td><%= video.getDuration().ToString()%></td>
                            <td><%= video.getReproductionNumber()%></td>
                            <td><%= video.getDescription()%></td>
                            <td><%= video.getFormat()%></td>
                        </tr>
                        <%}
                        %>
                    </tbody>
                </table>
            </div> 
            <% } else { %>
            <h2 style="text-align: center">No search has been performed</h2>
            <%}
            %>


        </div>           
    </body>
</html>
