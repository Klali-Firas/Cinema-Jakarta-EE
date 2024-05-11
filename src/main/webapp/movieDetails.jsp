<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.Movie" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieSession" %>
<%@include file="header.jsp" %>
<div class="container">
    <div class="card w-75 border-success">
        <% Movie movie = (Movie) request.getAttribute("movie");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (movie != null) { %>
        <div class="card-header d-flex justify-content-between align-items-center">
            <h1 class="d-inline-block">Movie</h1>
            <div class="input-group w-auto rounded-pill ">
                <a href="editMovie?movieId=<%= movie.getMovieId() %>"
                   class="btn btn-outline-info d-inline-block">Edit Movie</a>
                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">Delete
                    Movie
                </button>
            </div>
        </div>
        <%--        Delete Modal--%>
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteModalLabel">Confirm Delete</h5>
                        <button type="button" class="btn-outline-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete this movie?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Cancel</button>
                        <form action="deleteMovie">
                            <input type="hidden" name="movieId" value="<%= movie.getMovieId() %>">
                            <button type="submit" class="btn btn-outline-danger">Confirm Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row p-5 g-3">

            <%-- Checking if 'movie' object is not null --%>

            <div class="col-12 col-md-6">
                <div>
                    <img src="<%= movie.getCover() %>" alt="<%= movie.getMovieName() %>" class="d-block w-100 rounded">
                </div>
            </div>
            <div class="col-12 col-md-6">
                <div class="p-4 details-card">
                    <h1><%= movie.getMovieName() %>
                    </h1>
                    <h6>Category: <span class="fw-bold"><%= movie.getCategory().getLabel() %></span></h6>
                    <h6><%= "Release Date: " + sdf.format(movie.getReleaseDate()) %>
                    </h6>
                    <%--                    <h6>Tags:</h6>--%>

                    <%--                    <div class="details-card p-2 mt-2">--%>
                    <%--                        &lt;%&ndash; Assuming 'sessions' is an ArrayList<MovieSession> in 'movie' object &ndash;%&gt;--%>
                    <%--                        <% for (MovieSession session : movie.getSessions()) { %>--%>
                    <%--                        <h2><%= "session " + session.getSessionId() %></h2>--%>
                    <%--                        <p><%= "Date Debut: " + sdf.format(session.getSessionDate()) %></p>--%>
                    <%--                        &lt;%&ndash; You can access hall details using session.getHall() &ndash;%&gt;--%>
                    <%--                        <p><%= "Hall: " + session.getHall().getHallName() %></p>--%>
                    <%--                        &lt;%&ndash; Add more session details as needed &ndash;%&gt;--%>
                    <%--                        <div class="w-100 text-end">--%>
                    <%--                            &lt;%&ndash; Add your button here &ndash;%&gt;--%>
                    <%--                            &lt;%&ndash; You can use onclick attribute to call a JavaScript function &ndash;%&gt;--%>
                    <%--                            &lt;%&ndash; For example: onclick="toggleCandidatPopUp('<%= session.getSessionId() %>')" &ndash;%&gt;--%>
                    <%--                        </div>--%>
                    <%--                        <% } %>--%>
                    <%--                    </div>--%>
                </div>
            </div>
            <% } else { %>
            <%-- Handle case when 'movie' object is null --%>
            <div class="col-12">
                <p>No film details available.</p>
            </div>
            <% } %>
        </div>

    </div>
</div>
<%@include file="footer.jsp" %>
