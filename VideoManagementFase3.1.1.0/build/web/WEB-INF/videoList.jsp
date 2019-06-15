<%-- 
    Document   : videoList
    Created on : Mar 19, 2019, 11:37:19 PM
    Author     : alejandro
--%>

<%@page import="java.util.List"%>
<%@page import="models.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <jsp:include page="headTitle.jsp" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
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

            <!-- Main component for a primary marketing message or call to action -->
            <div class="table-responsive">
                <table class="table table-striped table-hover  table-bordered">
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
                        <% for (Video video : (List<Video>) request.getAttribute("vl")) {
                        %>
                        <tr>
                            <td><%= video.title%></td>
                            <td><%= video.autor%></td>
                            <td><%= video.createdDate%></td>
                            <td><%= video.duration%></td>
                            <td><%= video.reproductionNumber%></td>
                            <td><%= video.description%></td>
                            <td><%= video.format%></td>
                        </tr>
                        <%}
                        %>

                    </tbody>
                </table>
            </div> 

        </div>           


    </body>
</html>
