package com.runlow.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@Table(name="booking")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="approximate_ammount", nullable=false)
	private double approximateAmmount;

	@Column(name="approximate_time", nullable=false)
	private Time approximateTime;

	@Temporal(TemporalType.DATE)
	@Column(name="booking_date", nullable=false)
	private Date bookingDate;

	@Column(name="cancel_reason", nullable=false)
	private String cancelReason;

	@Column(name="client_cancel_request_datetime", nullable=false)
	private Timestamp clientCancelRequestDatetime;

	@Column(name="client_request_created_datetime", nullable=false)
	private Timestamp clientRequestCreatedDatetime;

	@Column(nullable=false)
	private String comment;

	@Column(name="driver_accepted_datetime", nullable=false)
	private Timestamp driverAcceptedDatetime;

	@Column(name="driver_arrived_datetime", nullable=false)
	private Timestamp driverArrivedDatetime;

	@Column(name="driver_arriving_datetime", nullable=false)
	private Timestamp driverArrivingDatetime;

	@Column(name="driver_rejected_datetime", nullable=false)
	private Timestamp driverRejectedDatetime;

	@Column(name="drop_off_gps_location", nullable=false)
	private String dropOffGpsLocation;

	@Column(name="drop_off_location", nullable=false)
	private String dropOffLocation;

	@Column(name="drop_off_time", nullable=false)
	private Timestamp dropOffTime;

	@Column(name="estimated_distance", nullable=false, precision=65, scale=2)
	private BigDecimal estimatedDistance;

	@Column(name="final_ammount", nullable=false)
	private double finalAmmount;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(name="passenger_accepted_date_time", nullable=false)
	private Integer passengerAcceptedDateTime;

	@Column(name="passenger_id", nullable=false)
	private Integer passengerId;

	@Column(name="pickup_location", nullable=false)
	private String pickupLocation;

	@Column(name="pickup_time", nullable=false)
	private Timestamp pickupTime;

	@Column(nullable=false)
	private double price;

	@Column(name="ride_completed_datetime", nullable=false)
	private Timestamp rideCompletedDatetime;

	@Column(name="ride_started_datetime", nullable=false)
	private Timestamp rideStartedDatetime;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="driver_user_id", nullable=false)
	private User driverUser;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="passenger_user_id", nullable=false)
	private User passengerUsers;

	//bi-directional many-to-one association to VehicleType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicle_type_id", nullable=false)
	private VehicleType vehicleType;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicle_id", nullable=false)
	private Vehicle vehicle;

	//bi-directional many-to-one association to BookingType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_type_id", nullable=false)
	private BookingType bookingType;

	//bi-directional many-to-one association to Package
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="package_id", nullable=false)
	private Package bookingPackage;

	//bi-directional many-to-one association to BookingStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_status_id", nullable=false)
	private BookingStatus bookingStatus;

	//bi-directional many-to-one association to PromoCodeType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="promo_code_type_id", nullable=false)
	private PromoCodeType promoCodeType;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="booking")
	private List<Rating> ratings;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="booking")
	private List<Transaction> transactions;

	public Booking() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getApproximateAmmount() {
		return this.approximateAmmount;
	}

	public void setApproximateAmmount(double approximateAmmount) {
		this.approximateAmmount = approximateAmmount;
	}

	public Time getApproximateTime() {
		return this.approximateTime;
	}

	public void setApproximateTime(Time approximateTime) {
		this.approximateTime = approximateTime;
	}

	public Date getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Timestamp getClientCancelRequestDatetime() {
		return this.clientCancelRequestDatetime;
	}

	public void setClientCancelRequestDatetime(Timestamp clientCancelRequestDatetime) {
		this.clientCancelRequestDatetime = clientCancelRequestDatetime;
	}

	public Timestamp getClientRequestCreatedDatetime() {
		return this.clientRequestCreatedDatetime;
	}

	public void setClientRequestCreatedDatetime(Timestamp clientRequestCreatedDatetime) {
		this.clientRequestCreatedDatetime = clientRequestCreatedDatetime;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDriverAcceptedDatetime() {
		return this.driverAcceptedDatetime;
	}

	public void setDriverAcceptedDatetime(Timestamp driverAcceptedDatetime) {
		this.driverAcceptedDatetime = driverAcceptedDatetime;
	}

	public Timestamp getDriverArrivedDatetime() {
		return this.driverArrivedDatetime;
	}

	public void setDriverArrivedDatetime(Timestamp driverArrivedDatetime) {
		this.driverArrivedDatetime = driverArrivedDatetime;
	}

	public Timestamp getDriverArrivingDatetime() {
		return this.driverArrivingDatetime;
	}

	public void setDriverArrivingDatetime(Timestamp driverArrivingDatetime) {
		this.driverArrivingDatetime = driverArrivingDatetime;
	}

	public Timestamp getDriverRejectedDatetime() {
		return this.driverRejectedDatetime;
	}

	public void setDriverRejectedDatetime(Timestamp driverRejectedDatetime) {
		this.driverRejectedDatetime = driverRejectedDatetime;
	}

	public String getDropOffGpsLocation() {
		return this.dropOffGpsLocation;
	}

	public void setDropOffGpsLocation(String dropOffGpsLocation) {
		this.dropOffGpsLocation = dropOffGpsLocation;
	}

	public String getDropOffLocation() {
		return this.dropOffLocation;
	}

	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public Timestamp getDropOffTime() {
		return this.dropOffTime;
	}

	public void setDropOffTime(Timestamp dropOffTime) {
		this.dropOffTime = dropOffTime;
	}

	public BigDecimal getEstimatedDistance() {
		return this.estimatedDistance;
	}

	public void setEstimatedDistance(BigDecimal estimatedDistance) {
		this.estimatedDistance = estimatedDistance;
	}

	public double getFinalAmmount() {
		return this.finalAmmount;
	}

	public void setFinalAmmount(double finalAmmount) {
		this.finalAmmount = finalAmmount;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Integer getPassengerAcceptedDateTime() {
		return this.passengerAcceptedDateTime;
	}

	public void setPassengerAcceptedDateTime(Integer passengerAcceptedDateTime) {
		this.passengerAcceptedDateTime = passengerAcceptedDateTime;
	}

	public Integer getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPickupLocation() {
		return this.pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Timestamp getPickupTime() {
		return this.pickupTime;
	}

	public void setPickupTime(Timestamp pickupTime) {
		this.pickupTime = pickupTime;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getRideCompletedDatetime() {
		return this.rideCompletedDatetime;
	}

	public void setRideCompletedDatetime(Timestamp rideCompletedDatetime) {
		this.rideCompletedDatetime = rideCompletedDatetime;
	}

	public Timestamp getRideStartedDatetime() {
		return this.rideStartedDatetime;
	}

	public void setRideStartedDatetime(Timestamp rideStartedDatetime) {
		this.rideStartedDatetime = rideStartedDatetime;
	}

	public User getDriverUser() {
		return this.driverUser;
	}

	public void setDriverUser(User driverUser) {
		this.driverUser = driverUser;
	}

	public User getPassengerUsers() {
		return this.passengerUsers;
	}

	public void setPassengerUsers(User passenger) {
		this.passengerUsers = passenger;
	}

	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public BookingType getBookingType() {
		return this.bookingType;
	}

	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
	}

	public Package getPackage() {
		return this.bookingPackage;
	}

	public void setPackage(Package bookingPackage) {
		this.bookingPackage = bookingPackage;
	}

	public BookingStatus getBookingStatus() {
		return this.bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public PromoCodeType getPromoCodeType() {
		return this.promoCodeType;
	}

	public void setPromoCodeType(PromoCodeType promoCodeType) {
		this.promoCodeType = promoCodeType;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setBooking(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setBooking(null);

		return rating;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setBooking(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setBooking(null);

		return transaction;
	}

}