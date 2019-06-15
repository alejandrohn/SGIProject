<%@page import="models.Video"%>

<% Video video = (Video) request.getAttribute("video");%>

<%if (video.format.equals("vimeo") || video.format.equals("youtube")) {
%>
<div id = "player" data-plyr-provider = "<%= video.format%>" data-plyr-embed-id = "<%= video.videoPath%>"> < / div>
    <%} else {%>

    <video id="player" autoplay="autoplay"style="width:100%; height:640px; background-color: #99bf97;" playsinline controls>
        <source src="<%= video.videoPath%>" type="video/<%= video.format%>" />
    </video>
    <% }%>
</div>