package com.runlow.model;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.runlow.enums.DeliveryStatus;
import com.runlow.enums.DriverTypeEnum;
import com.runlow.enums.TransportStatus;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
@Table(name="driver")
@NamedQuery(name="Driver.findAll", query="SELECT d FROM Driver d")
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="accept_new_booking", nullable=true)
	private Boolean acceptNewBooking;

	@Column(name="bank_book_copy", nullable=true)
	private String bankBookCopy;

	@Column(name="billing_proof", nullable=true)
	private String billingProof;

	@Column(name="delivery_status", nullable=true)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;

	@Column(name="driver_photo", nullable=true)
	private String driverPhoto;

	@Column(name="driver_type", nullable=true)
	@Enumerated(EnumType.STRING)
	private DriverTypeEnum driverType;

	@Column(name="driving_lecense_front", nullable=true)
	private String drivingLecenseFront;

	@Column(name="driving_license_back", nullable=true)
	private String drivingLicenseBack;

	@Column(name="hiring_insurance", nullable=true)
	private Boolean hiringInsurance;

	@Column(name="insurance_certificate", nullable=true)
	private String insuranceCertificate;

	@Column(name="national_id_back", nullable=true)
	private String nationalIdBack;

	@Column(name="national_id_front", nullable=true)
	private String nationalIdFront;

	@Column(name="no_objection_letter", nullable=true)
	private String noObjectionLetter;

	@Column(name="number_of_seats", nullable=true)
	private Integer numberOfSeats;

	@Column(name="revenue_license", nullable=true)
	private String revenueLicense;

	@Column(name="transport_status", nullable=true)
	@Enumerated(EnumType.STRING)
	private TransportStatus transportStatus;

	@Column(name="vehicle_image", nullable=true)
	private String vehicleImage;

	@Column(name="vehicle_registration_certificate", nullable=true)
	private String vehicleRegistrationCertificate;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to VehicleType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicle_type_id", nullable=true)
	private VehicleType vehicleType;

	public Driver() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAcceptNewBooking() {
		return this.acceptNewBooking;
	}

	public void setAcceptNewBooking(Boolean acceptNewBooking) {
		this.acceptNewBooking = acceptNewBooking;
	}

	public String getBankBookCopy() {
		return this.bankBookCopy;
	}

	public void setBankBookCopy(String bankBookCopy) {
		this.bankBookCopy = bankBookCopy;
	}

	public String getBillingProof() {
		return this.billingProof;
	}

	public void setBillingProof(String billingProof) {
		this.billingProof = billingProof;
	}

	public DeliveryStatus getDeliveryStatus() {
		return this.deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDriverPhoto() {
		return this.driverPhoto;
	}

	public void setDriverPhoto(String driverPhoto) {
		this.driverPhoto = driverPhoto;
	}

	public DriverTypeEnum getDriverType() {
		return this.driverType;
	}

	public void setDriverType(DriverTypeEnum driverType) {
		this.driverType = driverType;
	}

	public String getDrivingLecenseFront() {
		return this.drivingLecenseFront;
	}

	public void setDrivingLecenseFront(String drivingLecenseFront) {
		this.drivingLecenseFront = drivingLecenseFront;
	}

	public String getDrivingLicenseBack() {
		return this.drivingLicenseBack;
	}

	public void setDrivingLicenseBack(String drivingLicenseBack) {
		this.drivingLicenseBack = drivingLicenseBack;
	}

	public Boolean getHiringInsurance() {
		return this.hiringInsurance;
	}

	public void setHiringInsurance(Boolean hiringInsurance) {
		this.hiringInsurance = hiringInsurance;
	}

	public String getInsuranceCertificate() {
		return this.insuranceCertificate;
	}

	public void setInsuranceCertificate(String insuranceCertificate) {
		this.insuranceCertificate = insuranceCertificate;
	}

	public String getNationalIdBack() {
		return this.nationalIdBack;
	}

	public void setNationalIdBack(String nationalIdBack) {
		this.nationalIdBack = nationalIdBack;
	}

	public String getNationalIdFront() {
		return this.nationalIdFront;
	}

	public void setNationalIdFront(String nationalIdFront) {
		this.nationalIdFront = nationalIdFront;
	}

	public String getNoObjectionLetter() {
		return this.noObjectionLetter;
	}

	public void setNoObjectionLetter(String noObjectionLetter) {
		this.noObjectionLetter = noObjectionLetter;
	}

	public Integer getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getRevenueLicense() {
		return this.revenueLicense;
	}

	public void setRevenueLicense(String revenueLicense) {
		this.revenueLicense = revenueLicense;
	}

	public TransportStatus getTransportStatus() {
		return this.transportStatus;
	}

	public void setTransportStatus(TransportStatus transportStatus) {
		this.transportStatus = transportStatus;
	}

	public String getVehicleImage() {
		return this.vehicleImage;
	}

	public void setVehicleImage(String vehicleImage) {
		this.vehicleImage = vehicleImage;
	}

	public String getVehicleRegistrationCertificate() {
		return this.vehicleRegistrationCertificate;
	}

	public void setVehicleRegistrationCertificate(String vehicleRegistrationCertificate) {
		this.vehicleRegistrationCertificate = vehicleRegistrationCertificate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

}