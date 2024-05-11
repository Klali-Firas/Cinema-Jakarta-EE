<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="header.jsp"%>
<div class="container">
    <div class="card w-75 border-success">
        <div class="card-header">
            <h2 class="mb-4">Add Movie</h2>
        </div>
        <form class="card-body" method="post" action="addMovie">
            <fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="movieName" type="text" class="form-control" id="movieName"
                               placeholder="">
                        <label for="movieName">Movie Name</label>
                        <small id="MovieNameHelper" class="form-text text-muted">Your movie name goes here
                            !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="cover" type="text" class="form-control" id="cover"
                               placeholder="">
                        <label for="movieName">Cover</label>
                        <small id="MovieCoverHelper" class="form-text text-muted">Your movie cover link goes here
                            !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="releaseDate" type="date" class="form-control" id="releaseDate"
                               placeholder="">
                        <label for="releaseDate">Release Date</label>
                        <small id="ReleaseDateHelper" class="form-text text-muted">Your movie release date goes here
                            !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <% ArrayList<MovieCategory> categories = (ArrayList<MovieCategory>) request.getAttribute("categories");%>
                        <select id="categoryId" name="categoryId" class="form-control">
                            <% for (MovieCategory movie : categories) { %>
                            <option value="<%=movie.getCategorieId()%>"><%=movie.getLabel()%></option>
                            <% } %>
                        </select>
                        <label for="categoryId">Category</label>
                        <small id="categoryIdHelper" class="form-text text-muted">Your movie name goes here
                            !</small>
                    </div>
                </fieldset>

                <button type="submit" class="btn btn-outline-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>