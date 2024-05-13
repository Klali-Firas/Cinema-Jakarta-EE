<%@include file="header.jsp"%>

<div class="container">
    <div class="row justify-content-center w-100">
        <div class="col-md-6">
            <div class="card border-success">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <% if (session.getAttribute("error") != null) { %>
                        <div class="alert alert-danger text-center" role="alert">
                            <%= session.getAttribute("error") %>
                        </div>
                    <% session.invalidate();} %>
                    <form action="" method="post">
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="email-addon"><i class="fa-solid fa-envelope"></i></span>
                            <input type="email" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="email-addon" name="email" required>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="password-addon"><i class="fa-solid fa-key"></i></span>
                            <input type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="password-addon" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-outline-success">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
