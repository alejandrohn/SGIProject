<nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Video Management</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                             <li class="active"><a href="welcomePage">Home</a></li>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Contact</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Video <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="registerVideo">Register Video</a></li>
                                    <li><a href="videoList">Video List</a></li>
                                    <li><a href="encrypt">Cipher XML document</a></li>
                                    <li><a href="encryptDigitalContent">Cipher digital content</a></li>
                                    
                                    
<!--                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>-->
                                </ul>
                            </li>
                        </ul> 
                        <ul class="nav navbar-nav navbar-right">
                            <!--                            <li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>-->
                            <li> <a href="#"  >
                                    <span class="glyphicon glyphicon-user"></span> 
                                    <strong><%= session.getAttribute("userName")%></strong>
                                </a></li>
                            <li><a href="logOutUser">Sign Up</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>
