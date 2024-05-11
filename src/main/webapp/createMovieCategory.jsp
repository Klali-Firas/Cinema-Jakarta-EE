<%@include file="header.jsp"%>
<div class="container">
    <div class="card w-50 border-success">
        <div class="card-header">
            <h2 class="mb-4">Add Movie Category</h2>
        </div>
        <form class="card-body" method="post" action="addMovieCategory">
            <fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="categoryLabel" type="text" class="form-control" id="categoryLabel"
                               placeholder="e.g., Action">
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
