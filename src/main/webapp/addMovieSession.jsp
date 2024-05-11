<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.Movie" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.CinemaHall" %>
<%@include file="header.jsp"%>
<div class="container">
    <div class="card w-75 border-success">
        <div class="card-header">
            <h2 class="mb-4">Add Movie</h2>
        </div>
        <form class="card-body" method="post" action="addMovieSession">
            <fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <% ArrayList<Movie> movies = (ArrayList<Movie>) request.getAttribute("movies");
                        Integer movieId = (Integer) request.getAttribute("movieId");
                        %>

                        <select id="movieId" name="movieId" class="form-control">
                            <% for (Movie movie : movies) { %>
                            <option value="<%=movie.getMovieId()%>" <%=(movieId != null && movieId == (movie.getMovieId())) ? "selected":""%>><%=movie.getMovieName()%></option>
                            <% } %>
                        </select>
                        <label for="movieId">Movie</label>
                        <small id="movieIdHelper" class="form-text text-muted">Select movie to add session
                            !</small>
                    </div>
                </fieldset>

                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="date" type="datetime-local" class="form-control" id="date"
                               placeholder="">
                        <label for="date">Session Date</label>
                        <small id="dateHelper" class="form-text text-muted">Session date goes here
                            !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <% ArrayList<CinemaHall> cinemaHalls = (ArrayList<CinemaHall>) request.getAttribute("cinemaHalls");%>
                        <select id="hallId" name="hallId" class="form-control">
                            <% for (CinemaHall cinemaHall : cinemaHalls) { %>
                            <option value="<%=cinemaHall.getHallId()%>"><%=cinemaHall.getHallName()%></option>
                            <% } %>
                        </select>
                        <label for="hallId">Hall</label>
                        <small id="hallIdHelper" class="form-text text-muted">Your hall name goes here
                            !</small>
                    </div>
                </fieldset>

                <button type="submit" class="btn btn-outline-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>