package com.api.model.excursion;

import com.api.model.account.Account;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Account user;

    @ManyToOne(optional = false)
    private TourDate tourDate;

    private boolean confirmed = false;

    public Booking() {
    }

    public Booking(Long id, Account user, TourDate tourDate, boolean confirmed) {
        this.id = id;
        this.user = user;
        this.tourDate = tourDate;
        this.confirmed = confirmed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public TourDate getTourDate() {
        return tourDate;
    }

    public void setTourDate(TourDate tourDate) {
        this.tourDate = tourDate;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
