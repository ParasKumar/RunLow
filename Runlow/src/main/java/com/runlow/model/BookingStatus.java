package com.runlow.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.runlow.enums.BookingStatusEnum;


/**
 * The persistent class for the booking_status database table.
 * 
 */
@Entity
@Table(name="booking_status")
@NamedQuery(name="BookingStatus.findAll", query="SELECT b FROM BookingStatus b")
public class BookingStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="last_modified_date", nullable=false)
	private Integer lastModifiedDate;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private com.runlow.enums.BookingStatusEnum status;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="bookingStatus")
	private List<Booking> bookings;

	public BookingStatus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Integer lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public BookingStatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(BookingStatusEnum status) {
		this.status = status;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setBookingStatus(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setBookingStatus(null);

		return booking;
	}

}