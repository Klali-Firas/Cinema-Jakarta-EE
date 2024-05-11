<%@include file="header.jsp"%>
<div class="container">
    <div class="card w-50 border-success">
        <div class="card-header">
            <h2 class="mb-4">Add Cinema Hall</h2>
        </div>
        <form class="card-body" method="post" action="addCinemaHall">
            <fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="hallName" type="text" class="form-control" id="hallName"
                               placeholder="ex..Hannibal">
                        <label for="hallName">Hall Name</label>
                        <small id="HallNameHelper" class="form-text text-muted">Your hall name should inspire people
                            !</small>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="form-floating mb-3">
                        <input name="capacity" type="number" class="form-control" id="capacity" placeholder="ex.. 500">
                        <label for="capacity">Capacity</label>
                        <small id="capacityHelp" class="form-text text-muted">How many people can this hall hold
                            ?</small>
                    </div>
                </fieldset>
                <button type="submit" class="btn btn-outline-success">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
<%@include file="footer.jsp"%>