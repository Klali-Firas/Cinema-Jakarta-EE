<%@ page import="firas.l2dis2.cinema8jee.Entity.Movie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@include file="header.jsp"%>


<div class="w-100 mt-4 d-flex justify-content-center align-items-center" >
<%SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy");

    ArrayList<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
ArrayList<MovieCategory> categories = (ArrayList<MovieCategory>) request.getAttribute("categories");
    Movie toEditMovie = (Movie) request.getAttribute("toEditMovie");
%>
    <div class="card border-info mb-3 w-75">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h1 class="d-inline-block">Movies</h1>
            <form class="d-inline-block" action="Movies">
                <div class="input-group">
                    <input type="text" class="form-control" name="movieName" placeholder="Search for a movie">
                    <select id="categoryId" name="categoryId" class="form-control">
                        <option value="0" disabled selected>All Categories</option>
                        <% for (MovieCategory category : categories) { %>
                        <option value="<%=category.getCategorieId()%>" ><%=category.getLabel()%></option>
                        <% } %>
                    </select>
                    <button class="btn btn-outline-info" type="submit"><i class="fa-solid fa-search"></i> Search</button>
                </div>
            </form>
            <a href="addMovie"
                                                           class="btn btn-outline-info d-inline-block">Add New Movie</a></div>
        <div class="row g-3 mb-3 px-3">
            <%

                if (movies != null) {
                    for (Movie movie : movies) {
            %>
            <div class="col-12 col-xl-3 col-md-4 col-sm-6">
                <div class="p-2 details-card h-100" onclick="window.location.href='movieDetails?movieId=<%= movie.getMovieId() %>'" role="button" >
                    <div class="rounded" style="overflow: hidden; display: inline-block;">
                        <img src="<%= movie.getCover() %>" alt="<%= movie.getMovieName() %>" class="w-100 rounded">
                    </div>
                    <h3><%= movie.getMovieName() %></h3>
                    <h6><%= movie.getCategory().getLabel() %></h6>
                    <h6>Release Date: <%= sdf.format(movie.getReleaseDate()) %></h6>
                    <!-- Add more data as needed -->
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>

    </div>
</div>

<%@include file="footer.jsp"%>

<%--<!-- Modal Structure -->--%>
<%--<div class="modal fade" id="editMovieModal" tabindex="-1" aria-labelledby="editMovieModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog modal-dialog-centered">--%>
<%--        <div class="modal-content bg-dark card border-warning">--%>
<%--            <div class="modal-header card-header">--%>
<%--                <h5 class="modal-title" id="editMovieModalLabel">Edit Movie</h5>--%>
<%--                <button type="button" class="btn-outline-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--            </div>--%>
<%--            <div class="modal-body card-body">--%>
<%--                <form method="post" >--%>
<%--                    <input type="hidden" id="movieId" name="movieId" value="<%= toEditMovie.getMovieId() %>">--%>
<%--                    <div class="mb-3">--%>
<%--                        <label for="movieName" class="form-label">Movie Name</label>--%>
<%--                        <input type="text" class="form-control" id="movieName" name="movieName" value="<%= toEditMovie.getMovieName() %>">--%>
<%--                    </div>--%>
<%--                    <div class="mb-3">--%>
<%--                        <label for="releaseDate" class="form-label">Release Date</label>--%>
<%--                        <input type="date" class="form-control" id="releaseDate" name="releaseDate" value="<%= toEditMovie.getReleaseDate()%>">--%>
<%--                    </div>--%>
<%--                    <!-- Add more fields as needed -->--%>
<%--                    <button type="submit" class="btn btn-outline-warning">Save Changes</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>