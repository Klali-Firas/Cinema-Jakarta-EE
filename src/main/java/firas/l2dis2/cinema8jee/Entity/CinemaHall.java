package firas.l2dis2.cinema8jee.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "cinema_hall")
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.SEQUENCE
    @Column(name = "hall_id")
    private Integer hallId;

    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "reservation_status")
    private boolean reservationStatus;

    public CinemaHall(Integer hallId, String hallName, int capacity, boolean reservationStatus) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.capacity = capacity;
        this.reservationStatus = reservationStatus;
    }

    public CinemaHall() {

    }

    // Getter and Setter methods for the class fields
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    // Main method for testing

}
