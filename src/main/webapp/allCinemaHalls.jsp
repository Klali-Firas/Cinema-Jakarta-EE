<%@include file="header.jsp"%>
<%@ page import="firas.l2dis2.cinema8jee.Entity.CinemaHall" %>
<%@ page import="java.util.List" %>


<div class="w-100 .page-height mt-5 d-flex justify-content-center align-items-center">

    <div class="card border-info mb-3 w-75">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h1 class="d-inline-block">Cinema Halls</h1><a href="addCinemaHall"
                                                           class="btn btn-outline-info d-inline-block">Add Cinema Hall</a></div>
        <table class="text-center table table-hover table-bordered card-body">
            <thead class="table-info">
            <tr>
                <th>Hall ID</th>
                <th>Hall Name</th>
                <th>Hall Capacity</th>
                <th>Reservation Status</th>
                <th colspan="2">Action</th>
                <!-- Add more columns as needed -->
            </tr>
            </thead>
            <tbody>
            <%
                // Assuming you have a List<CinemaHall> called cinemaHalls
                List<CinemaHall> cinemaHalls = (List<CinemaHall>) request.getAttribute("cinemaHalls");
                if (cinemaHalls != null) {
                    for (CinemaHall cinemaHall : cinemaHalls) {
            %>
            <tr>
                <td><%= cinemaHall.getHallId() %>
                </td>
                <td><%= cinemaHall.getHallName() %>
                </td>
                <td><%= cinemaHall.getCapacity() %>
                </td>
                <td><%=cinemaHall.isReservationStatus() ? "Reserved" : "Not reserved"%>
                </td>
                <td><a style="color: yellow" href="updateCinemaHall?hallId=<%= cinemaHall.getHallId() %>">
                    <i class="fa-solid fa-file-pen"></i></a></td>

                <td><a style="color:red" href="deleteCinemaHall?hallId=<%= cinemaHall.getHallId() %>"><i
                        class="fa-solid fa-trash-can"></i></a></td>
                <!-- Add more data as needed -->
            </tr>
            </tbody>
            <%
                    }
                }
            %>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
