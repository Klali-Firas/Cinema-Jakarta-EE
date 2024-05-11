<%@ page import="firas.l2dis2.cinema8jee.Entity.Movie" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="header.jsp"%>
<div class="container">
    <div class="card w-75 border-success">
        <div class="card-header">
            <h2 class="mb-4">Edit Movie</h2>
        </div>
        <form class="card-body" method="post" action="editMovie">
            <fieldset>
                <% Movie movie = (Movie) request.getAttribute("movie"); %>
                <input type="hidden" name="movieId" value="<%= movie.getMovieId() %>">
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="movieName" type="text" class="form-control" id="movieName"
                               placeholder="" value="<%= movie.getMovieName() %>">
                        <label for="movieName">Movie Name</label>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="cover" type="text" class="form-control" id="cover"
                               placeholder="" value="<%= movie.getCover() %>">
                        <label for="cover">Cover</label>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="releaseDate" type="date" class="form-control" id="releaseDate"
                               placeholder="" value="<%= movie.getReleaseDate() %>">
                        <label for="releaseDate">Release Date</label>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <% ArrayList<MovieCategory> categories = (ArrayList<MovieCategory>) request.getAttribute("categories");%>
                        <select id="categoryId" name="categoryId" class="form-control">
                            <% for (MovieCategory category : categories) { %>
                            <option value="<%=category.getCategorieId()%>" <%= category.getCategorieId() == movie.getCategory().getCategorieId() ? "selected" : "" %>><%=category.getLabel()%></option>
                            <% } %>
                        </select>
                        <label for="categoryId">Category</label>
                    </div>
                </fieldset>

                <button type="submit" class="btn btn-outline-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>