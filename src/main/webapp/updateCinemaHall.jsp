<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="firas.l2dis2.cinema8jee.Entity.CinemaHall" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Cinema Hall</title>
    <link rel="stylesheet" href="assets/bootstrap-vapor.css">
    <!-- Add Font Awesome CSS -->
    <link rel="stylesheet" href="assets/fontawesome/css/all.css">
    <style>
        /* Center the form vertically */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            width: 100vw;
        }
        /* Add some styling to the form */

    </style>
</head>
<body>
<div class="container">
    <div class="card w-50 border-success">
        <div class="card-header">
            <h2 class="mb-4">Add Cinema Hall</h2>
        </div>
        <% CinemaHall cinemaHall = (CinemaHall) request.getAttribute("cinemaHall"); %>
        <form class="card-body" method="post" action="updateCinemaHall">
            <fieldset>
                <fieldset>
                    <input type="hidden" name="hallId" value="<%=cinemaHall.getHallId()%>">
                    <div class="form-floating mb-3">
                        <input name="hallName" type="text" class="form-control" id="hallName"value="<%=cinemaHall.getHallName()%>">
                        <label for="hallName">Hall Name</label>
                        <small id="HallNameHelper" class="form-text text-muted">You Hall name should inspire people !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="capacity" type="number" class="form-control" id="capacity" value="<%=cinemaHall.getCapacity()%>">
                        <label for="capacity">Capacity</label>
                        <small id="capacityHelp" class="form-text text-muted">How many people can this hall hold ?</small>
                    </div>
                </fieldset>
                <fieldset>
                <div class="form-check mb-3">
                    <input name="reservationStatus" class="form-check-input" type="checkbox" id="reservationStatus" <%=cinemaHall.isReservationStatus()? "checked":""%>>
                    <label class="form-check-label" for="reservationStatus">
                        Reservation Status
                    </label>
                </div>
                </fieldset>
                <button type="submit" class="btn btn-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
