<form class="form-inline searchPatternForm" style="text-align: center;" action="searchVideo" method="post">
                <label for="searchPatternOptions">Search By:</label>
                <input type="hidden" class="searchPatternOptionSelected" name="searchPatternOptionSelected">

                <%  String selectedOption = (String) request.getAttribute("selectedOption");
                    selectedOption = selectedOption == null ? "0" : selectedOption;
                %>
                <select id="searchPatternOptions" class="form-control">
                    <option value="0" <%= selectedOption.equals("0") ? "selected" : ""%> >Autor</option>
                    <option value="1" <%= selectedOption.equals("1") ? "selected" : ""%>>Title</option>
                    <option value="2" <%= selectedOption.equals("2") ? "selected" : ""%>>Created Date</option>
                </select>
                <div class="form-group">
                    <% String valueSelected = (String) request.getAttribute("searchPattern");%>
                    <input type="text" name="searchPatternValue" value="<%= (valueSelected == null) ? "" : valueSelected%>"
                           class="form-control searchPatternText" id="searchPatternId" placeholder="Pattern">
                </div>

                <button type="submit" class="btn btn-primary" alt="Search">Search</button>
</form> 