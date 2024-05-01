package firas.l2dis2.cinema8jee.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MovieSession")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer sessionId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "session_date")
    private Date sessionDate;
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "hall_id")
    private CinemaHall hall;

    public MovieSession() {
    }

    public MovieSession(Integer sessionId, Date sessionDate, Movie movie, CinemaHall hall) {
        this.sessionId = sessionId;
        this.sessionDate = sessionDate;
        this.movie = movie;
        this.hall = hall;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public void setHall(CinemaHall hall) {
        this.hall = hall;
    }
    // getters and setters
}