<%@ page import="firas.l2dis2.cinema8jee.Entity.CinemaHall" %>

<%@include file="header.jsp"%>
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
                        <input name="hallName" type="text" class="form-control" id="hallName"
                               value="<%=cinemaHall.getHallName()%>">
                        <label for="hallName">Hall Name</label>
                        <small id="HallNameHelper" class="form-text text-muted">You Hall name should inspire people
                            !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="capacity" type="number" class="form-control" id="capacity"
                               value="<%=cinemaHall.getCapacity()%>">
                        <label for="capacity">Capacity</label>
                        <small id="capacityHelp" class="form-text text-muted">How many people can this hall hold
                            ?</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-check mb-3">
                        <input name="reservationStatus" class="form-check-input" type="checkbox"
                               id="reservationStatus" <%=cinemaHall.isReservationStatus()? "checked":""%>>
                        <label class="form-check-label" for="reservationStatus">
                            Reservation Status
                        </label>
                    </div>
                </fieldset>
                <button type="submit" class="btn btn-outline-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>