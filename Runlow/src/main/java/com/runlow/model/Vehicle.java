package com.runlow.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@Table(name="vehicle")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Boolean active;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(name="license_plate_number", nullable=false)
	private String licensePlateNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="manufacture_year", nullable=false)
	private Date manufactureYear;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="driver_user_id", nullable=false)
	private User driverUser;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_user_id", nullable=false)
	private User ownerUser;

	//bi-directional many-to-one association to VehicleType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicle_type_id", nullable=false)
	private VehicleType vehicleType;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="vehicle")
	private List<Booking> bookings;

	public Vehicle() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLicensePlateNumber() {
		return this.licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public Date getManufactureYear() {
		return this.manufactureYear;
	}

	public void setManufactureYear(Date manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public User getDriverUser() {
		return this.driverUser;
	}

	public void setDriverUser(User driverUser) {
		this.driverUser = driverUser;
	}

	public User getOwnerUser() {
		return this.ownerUser;
	}

	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}

	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setVehicle(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setVehicle(null);

		return booking;
	}

}