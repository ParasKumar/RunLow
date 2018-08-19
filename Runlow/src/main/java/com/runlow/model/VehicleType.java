package com.runlow.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicle_type database table.
 * 
 */
@Entity
@Table(name="vehicle_type")
@NamedQuery(name="VehicleType.findAll", query="SELECT v FROM VehicleType v")
public class VehicleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="base_rate", nullable=false)
	private double baseRate;

	@Column(nullable=false)
	private Integer capacity;

	@Column(name="fare_per_km", nullable=false)
	private double farePerKm;

	@Column(name="icon_url", nullable=false)
	private String iconUrl;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(nullable=false)
	private String type;

	@Column(name="waiting_time_rate_per_minute", nullable=false)
	private double waitingTimeRatePerMinute;

	//bi-directional many-to-one association to Driver
	@OneToMany(mappedBy="vehicleType")
	private List<Driver> drivers;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="vehicleType")
	private List<Vehicle> vehicles;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="vehicleType")
	private List<Booking> bookings;

	public VehicleType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getBaseRate() {
		return this.baseRate;
	}

	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public double getFarePerKm() {
		return this.farePerKm;
	}

	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWaitingTimeRatePerMinute() {
		return this.waitingTimeRatePerMinute;
	}

	public void setWaitingTimeRatePerMinute(double waitingTimeRatePerMinute) {
		this.waitingTimeRatePerMinute = waitingTimeRatePerMinute;
	}

	public List<Driver> getDrivers() {
		return this.drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public Driver addDriver(Driver driver) {
		getDrivers().add(driver);
		driver.setVehicleType(this);

		return driver;
	}

	public Driver removeDriver(Driver driver) {
		getDrivers().remove(driver);
		driver.setVehicleType(null);

		return driver;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setVehicleType(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setVehicleType(null);

		return vehicle;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setVehicleType(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setVehicleType(null);

		return booking;
	}

}