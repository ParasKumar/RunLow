package com.runlow.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the promo_code_type database table.
 * 
 */
@Entity
@Table(name="promo_code_type")
@NamedQuery(name="PromoCodeType.findAll", query="SELECT p FROM PromoCodeType p")
public class PromoCodeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="flat_discount", nullable=false)
	private double flatDiscount;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="offer_end_date", nullable=false)
	private Date offerEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="offer_started_date", nullable=false)
	private Date offerStartedDate;

	@Column(nullable=false)
	private Integer percentile;

	@Column(name="promo_code", nullable=false)
	private String promoCode;

	@Column(nullable=false)
	private Boolean status;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="promoCodeType")
	private List<Booking> bookings;

	public PromoCodeType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getFlatDiscount() {
		return this.flatDiscount;
	}

	public void setFlatDiscount(double flatDiscount) {
		this.flatDiscount = flatDiscount;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getOfferEndDate() {
		return this.offerEndDate;
	}

	public void setOfferEndDate(Date offerEndDate) {
		this.offerEndDate = offerEndDate;
	}

	public Date getOfferStartedDate() {
		return this.offerStartedDate;
	}

	public void setOfferStartedDate(Date offerStartedDate) {
		this.offerStartedDate = offerStartedDate;
	}

	public Integer getPercentile() {
		return this.percentile;
	}

	public void setPercentile(Integer percentile) {
		this.percentile = percentile;
	}

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
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
		booking.setPromoCodeType(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setPromoCodeType(null);

		return booking;
	}

}