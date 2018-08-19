package com.runlow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.runlow.enums.RatingSource;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@Table(name="rating")
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(name="rated_from", nullable=false)
	@Enumerated(EnumType.STRING)
	private RatingSource ratedFrom;

	@Column(name="rating_comment", nullable=false)
	private String ratingComment;

	@Column(name="rating_value", nullable=false)
	private double ratingValue;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="driver_user_id", nullable=false)
	private User driverUser;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="passenger_user_id", nullable=false)
	private User passengerUser;

	//bi-directional many-to-one association to Booking
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id", nullable=false)
	private Booking booking;

	public Rating() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public RatingSource getRatedFrom() {
		return this.ratedFrom;
	}

	public void setRatedFrom(RatingSource ratedFrom) {
		this.ratedFrom = ratedFrom;
	}

	public String getRatingComment() {
		return this.ratingComment;
	}

	public void setRatingComment(String ratingComment) {
		this.ratingComment = ratingComment;
	}

	public double getRatingValue() {
		return this.ratingValue;
	}

	public void setRatingValue(double ratingValue) {
		this.ratingValue = ratingValue;
	}

	public User getDriverUser() {
		return this.driverUser;
	}

	public void setDriverUser(User driverUser) {
		this.driverUser = driverUser;
	}

	public User getPassengerUser() {
		return this.passengerUser;
	}

	public void setPassengerUser(User passengerUser) {
		this.passengerUser = passengerUser;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}