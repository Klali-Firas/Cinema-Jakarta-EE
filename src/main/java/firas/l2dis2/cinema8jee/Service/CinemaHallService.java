package firas.l2dis2.cinema8jee.Service;

import firas.l2dis2.cinema8jee.Entity.CinemaHall;
import firas.l2dis2.cinema8jee.dao.DaoCinemaHall;

import java.util.ArrayList;

public class CinemaHallService {
    private final DaoCinemaHall daoCinemaHall;

    public CinemaHallService(DaoCinemaHall daoCinemaHall) {
        this.daoCinemaHall = daoCinemaHall;
    }

    public void createCinemaHall(CinemaHall cinemaHall) {
        daoCinemaHall.addCinemaHall(cinemaHall);
    }

    public void modifyCinemaHall(CinemaHall cinemaHall) {
        daoCinemaHall.updateCinemaHall(cinemaHall);
    }

    public void removeCinemaHall(CinemaHall cinemaHall) {
        daoCinemaHall.deleteCinemaHall(cinemaHall);
    }

    public CinemaHall getCinemaHall(int hallId) {
        return daoCinemaHall.getCinemaHall(hallId);
    }

    public ArrayList<CinemaHall> getAllCinemaHalls() {
        return new ArrayList<>(daoCinemaHall.getAllCinemaHalls());
    }
}
