
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Cinema</title>
    <link rel="stylesheet" href="assets/bootstrap-vapor.css">
    <link rel="stylesheet" href="assets/fontawesome/css/all.css">
    <script src="assets/bootstrap.bundle.js"></script>

    <style>
        td a {
            text-shadow: 0 0 1px rgba(255, 255, 255, 0.3), 0 0 2px rgba(255, 255, 255, 0.3), 0 0 5px rgba(255, 255, 255, 0.2);

        }
        .page-height{
            min-height: calc(100vh - 56px);
        }
        /* Center the form vertically */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 56px);
            width: 100vw;
        }
        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
        /* Add some styling to the form */
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark w-100" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Cinema</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="CinemaHalls">Halls
                        <span class="visually-hidden">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Movies">Movies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addMovieSession">Add Session</a>
                </li>
            </ul>

        </div>
    </div>
</nav>