<%@include file="header.jsp"%>
<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@ page import="java.util.List" %>

<div class="w-100 .page-height mt-5 d-flex justify-content-center align-items-center">

    <div class="card border-info mb-3 w-75">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h1 class="d-inline-block">Movie Categories</h1>
            <a href="addMovieCategory" class="btn btn-outline-info d-inline-block">Add Movie Category</a>
        </div>
        <table class="text-center table table-hover table-bordered card-body">
            <thead class="table-info">
            <tr>
                <th>Category ID</th>
                <th>Category Label</th>
                <th colspan="2">Action</th>
                <!-- Add more columns as needed -->
            </tr>
            </thead>
            <tbody>
            <%
                // Assuming you have a List<MovieCategory> called movieCategories
                List<MovieCategory> movieCategories = (List<MovieCategory>) request.getAttribute("movieCategories");
                if (movieCategories != null) {
                    for (MovieCategory movieCategory : movieCategories) {
            %>
            <tr>
                <td><%= movieCategory.getCategorieId() %></td>
                <td><%= movieCategory.getLabel() %></td>
                <td>
                    <a style="color: yellow" href="updateMovieCategory?categoryId=<%= movieCategory.getCategorieId() %>">
                        <i class="fa-solid fa-file-pen"></i>
                    </a>
                </td>
                <td>
                    <a style="color:red" href="deleteMovieCategory?categoryId=<%= movieCategory.getCategorieId() %>">
                        <i class="fa-solid fa-trash-can"></i>
                    </a>
                </td>
                <!-- Add more data as needed -->
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<%@include file="footer.jsp"%>
