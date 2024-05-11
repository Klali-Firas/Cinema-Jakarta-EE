<%@ page import="firas.l2dis2.cinema8jee.Entity.MovieCategory" %>
<%@include file="header.jsp"%>
<div class="container">
    <div class="card w-50 border-success">
        <div class="card-header">
            <h2 class="mb-4">Update Movie Category</h2>
        </div>
        <% MovieCategory movieCategory = (MovieCategory) request.getAttribute("movieCategory"); %>
        <form class="card-body" method="post" action="updateMovieCategory">
            <fieldset>
                <fieldset>
                    <input type="hidden" name="categoryId" value="<%=movieCategory.getCategorieId()%>">
                    <div class="form-floating mb-3">
                        <input name="categoryLabel" type="text" class="form-control" id="categoryLabel"
                               value="<%=movieCategory.getLabel()%>">
                        <label for="categoryLabel">Category Label</label>
                        <small id="categoryLabelHelper" class="form-text text-muted">Enter the category label</small>
                    </div>
                </fieldset>
                <button type="submit" class="btn btn-outline-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>
