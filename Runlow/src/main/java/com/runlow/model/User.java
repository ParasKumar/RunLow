package com.runlow.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.runlow.enums.SocialMediaTypeEnum;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;
    
    private Boolean isSocialMedia;
    private long socialMediaId;
    @Enumerated(EnumType.STRING)
    @Column(name="social_media_type", columnDefinition = "ENUM('GOOGLE', 'FACEBOOK')")
    private SocialMediaTypeEnum socialMediaType;    

	@Column(nullable=true)
    private Boolean active;

    @Column(name="company_name", nullable=true)
    private String companyName;

    @Column(name="current_balance", nullable=true)
    private double currentBalance;

    @Column(name="current_booking_id", nullable=true)
    private Integer currentBookingId;

    @Column(name="current_latitude", nullable=true)
    private String currentLatitude;

    @Column(name="current_longitue", nullable=true)
    private String currentLongitue;

    @Column(name="current_place", nullable=true)
    private String currentPlace;

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth", nullable=true)
    private Date dateOfBirth;

    @Column(name="delivery_online", nullable=true)
    private String deliveryOnline;

    @Column(name="device_token", nullable=true)
    private String deviceToken;

    @Column(name="driving_licece_number", nullable=true)
    private String drivingLiceceNumber;

    @Column(unique=true, nullable=false)
    private String email;

    public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Temporal(TemporalType.DATE)
    @Column(name="expiry_date", nullable=true)
    private Date expiryDate;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(nullable=true)
    private String gender;

    @Column(name="image_url", nullable=true)
    private String imageUrl;

    @Temporal(TemporalType.DATE)
    @Column(name="last_modified_date", nullable=true)
    private Date lastModifiedDate;

    @Column(name="last_name", nullable=true)
    private String lastName;

    @Column(name="last_updated", nullable=true)
    private Timestamp lastUpdated;

    @Column(name="mobile_number", nullable=true,unique=true)
    private String mobileNumber;

    @Column(nullable=false)
    private String password;

    @Column(name="transport_online", nullable=true)
    private String transportOnline;
    
    //this variable holds role id and is non persistable.
    @Transient
    public int roleId;
    
    //bi-directional many-to-one association to Role
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    //bi-directional one-to-one association to Driver
    @OneToOne(mappedBy="user", fetch=FetchType.LAZY)
    private Driver driver;

    //bi-directional many-to-one association to Transaction
    @OneToMany(mappedBy="sourceUser")
    private List<Transaction> sourceTransactions;
    
    //bi-directional many-to-one association to Transaction
    @OneToMany(mappedBy="destinationUser")
    private List<Transaction> destinationTransactions;

    //bi-directional many-to-one association to Vehicle
    @OneToMany(mappedBy="driverUser")
    private List<Vehicle> driverVehicles;

    //bi-directional many-to-one association to Vehicle
    @OneToMany(mappedBy="ownerUser")
    private List<Vehicle> ownerVehicles;

    //bi-directional many-to-one association to Booking
    @OneToMany(mappedBy="driverUser")
    private List<Booking> driverBookings;

    //bi-directional many-to-one association to Booking
    @OneToMany(mappedBy="passengerUsers")
    private List<Booking> passengerBookings;

    //bi-directional many-to-one association to Rating
    @OneToMany(mappedBy="driverUser")
    private List<Rating> driverRatings;

    //bi-directional many-to-one association to Rating
    @OneToMany(mappedBy="passengerUser")
    private List<Rating> passengerRatings;

    //bi-directional many-to-one association to driverChattings
    @OneToMany(mappedBy="driver")
    private List<Chatting> driverChattings;

    //bi-directional many-to-one association to Chatting
    @OneToMany(mappedBy="passenger")
    private List<Chatting> passengerChattings;

    //bi-directional many-to-one association to DriverType
    /*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="driver_type_id", nullable=false)
    private DriverType driverType;*/

    public User() {
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

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCurrentBalance() {
        return this.currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Integer getCurrentBookingId() {
        return this.currentBookingId;
    }

    public void setCurrentBookingId(Integer currentBookingId) {
        this.currentBookingId = currentBookingId;
    }

    public String getCurrentLatitude() {
        return this.currentLatitude;
    }

    public void setCurrentLatitude(String currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public String getCurrentLongitue() {
        return this.currentLongitue;
    }

    public void setCurrentLongitue(String currentLongitue) {
        this.currentLongitue = currentLongitue;
    }

    public String getCurrentPlace() {
        return this.currentPlace;
    }

    public void setCurrentPlace(String currentPlace) {
        this.currentPlace = currentPlace;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDeliveryOnline() {
        return this.deliveryOnline;
    }

    public void setDeliveryOnline(String deliveryOnline) {
        this.deliveryOnline = deliveryOnline;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDrivingLiceceNumber() {
        return this.drivingLiceceNumber;
    }

    public void setDrivingLiceceNumber(String drivingLiceceNumber) {
        this.drivingLiceceNumber = drivingLiceceNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTransportOnline() {
        return this.transportOnline;
    }

    public void setTransportOnline(String transportOnline) {
        this.transportOnline = transportOnline;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Transaction> getSourceTransactions() {
        return this.sourceTransactions;
    }

    public void setSourceTransactions(List<Transaction> sourceTransactions) {
        this.sourceTransactions = sourceTransactions;
    }

    public Transaction addSourceTransaction(Transaction sourceTransaction) {
        getSourceTransactions().add(sourceTransaction);
        sourceTransaction.setDriver(this);

        return sourceTransaction;
    }

    public Transaction removeSourceTransaction(Transaction sourceTransaction) {
        getSourceTransactions().remove(sourceTransaction);
        sourceTransaction.setDriver(null);

        return sourceTransaction;
    }

    public List<Vehicle> getDriverVehicles() {
        return this.driverVehicles;
    }

    public void setDriverVehicles(List<Vehicle> driverVehicles) {
        this.driverVehicles = driverVehicles;
    }

    public Vehicle addDriverVehicle(Vehicle driverVehicle) {
        getDriverVehicles().add(driverVehicle);
        driverVehicle.setDriverUser(this);

        return driverVehicle;
    }

    public Vehicle removeDriverVehicle(Vehicle driverVehicle) {
        getDriverVehicles().remove(driverVehicle);
        driverVehicle.setDriverUser(null);

        return driverVehicle;
    }

    public List<Vehicle> getOwnerVehicles() {
        return this.ownerVehicles;
    }

    public void setOwnerVehicles(List<Vehicle> ownerVehicles) {
        this.ownerVehicles = ownerVehicles;
    }

    public Vehicle addOwnerUser(Vehicle ownerVehicles) {
        getOwnerVehicles().add(ownerVehicles);
        ownerVehicles.setOwnerUser(this);

        return ownerVehicles;
    }

    public Vehicle removeOwnerVehicles(Vehicle ownerVehicle) {
        getOwnerVehicles().remove(ownerVehicle);
        ownerVehicle.setOwnerUser(null);

        return ownerVehicle;
    }

    public List<Transaction> getDestinationTransactions() {
        return this.destinationTransactions;
    }

    public void setDestinationTransactions(List<Transaction> destinationTransactions) {
        this.destinationTransactions = destinationTransactions;
    }

    public Transaction addDestinationTransaction(Transaction destinationTransaction) {
        getDestinationTransactions().add(destinationTransaction);
        destinationTransaction.setDestinationUser(this);

        return destinationTransaction;
    }

    public Transaction removeDestinationTransaction(Transaction destinationTransaction) {
        getDestinationTransactions().remove(destinationTransaction);
        destinationTransaction.setDestinationUser(null);

        return destinationTransaction;
    }

    public List<Booking> getDriverBookings() {
        return this.driverBookings;
    }

    public void setDriverBookings(List<Booking> driverBookings) {
        this.driverBookings = driverBookings;
    }

    public Booking addDriverBookings(Booking driverBooking) {
        getDriverBookings().add(driverBooking);
        driverBooking.setDriverUser(this);

        return driverBooking;
    }

    public Booking removeDriverBookings(Booking driverBooking) {
        getDriverBookings().remove(driverBookings);
        driverBooking.setDriverUser(null);

        return driverBooking;
    }

    public List<Booking> getPassengerBookings() {
        return this.passengerBookings;
    }

    public void setPassengerBookings(List<Booking> passengerBookings) {
        this.passengerBookings = passengerBookings;
    }

    public Booking addPassengerBooking(Booking passengerBooking) {
        getPassengerBookings().add(passengerBooking);
        passengerBooking.setPassengerUsers(this);

        return passengerBooking;
    }

    public Booking removePassengerBooking(Booking passengerBooking) {
        getPassengerBookings().remove(passengerBooking);
        passengerBooking.setPassengerUsers(null);

        return passengerBooking;
    }

    public List<Rating> getDriverRatings() {
        return this.driverRatings;
    }

    public void setDriverRatings(List<Rating> driverRatings) {
        this.driverRatings = driverRatings;
    }

    public Rating addDriverRating(Rating driverRating) {
        getDriverRatings().add(driverRating);
        driverRating.setDriverUser(this);

        return driverRating;
    }

    public Rating removeDriverRating(Rating driverRating) {
        getDriverRatings().remove(driverRating);
        driverRating.setDriverUser(null);

        return driverRating;
    }

    public List<Rating> getPassengerRatings() {
        return this.passengerRatings;
    }

    public void setPassengerRatings(List<Rating> passengerRatings) {
        this.passengerRatings = passengerRatings;
    }

    public Rating addPassengerRating(Rating passengerRating) {
        getPassengerRatings().add(passengerRating);
        passengerRating.setPassengerUser(this);

        return passengerRating;
    }

    public Rating removePassengerRating(Rating passengerRating) {
        getPassengerRatings().remove(passengerRating);
        passengerRating.setPassengerUser(null);

        return passengerRating;
    }

    public List<Chatting> getDriverChattings() {
        return this.driverChattings;
    }

    public void setDriverChattings(List<Chatting> driverChattings) {
        this.driverChattings = driverChattings;
    }

    public Chatting addDriverChatting(Chatting driverChatting) {
        getDriverChattings().add(driverChatting);
        driverChatting.setDriver(this);

        return driverChatting;
    }

    public Chatting removeDriverChatting(Chatting driverChatting) {
        getDriverChattings().remove(driverChatting);
        driverChatting.setDriver(null);

        return driverChatting;
    }

    public List<Chatting> getPassengerChattings() {
        return this.passengerChattings;
    }

    public void setPassengerChattings(List<Chatting> passengerChattings) {
        this.passengerChattings = passengerChattings;
    }

    public Chatting addPassengerChatting(Chatting passengerChatting) {
        getPassengerChattings().add(passengerChatting);
        passengerChatting.setPassenger(this);

        return passengerChatting;
    }

    public Chatting removePassengerChatting(Chatting passengerChatting) {
        getPassengerChattings().remove(passengerChatting);
        passengerChatting.setPassenger(null);

        return passengerChatting;
    }
    
    public Boolean getIsSocialMedia() {
		return isSocialMedia;
	}

	public void setIsSocialMedia(Boolean isSocialMedia) {
		this.isSocialMedia = isSocialMedia;
	}

	public long getSocialMediaId() {
		return socialMediaId;
	}

	public void setSocialMediaId(long socialMediaId) {
		this.socialMediaId = socialMediaId;
	}

	public SocialMediaTypeEnum getSocialMediaType() {
		return socialMediaType;
	}

	public void setSocialMediaType(SocialMediaTypeEnum socialMediaType) {
		this.socialMediaType = socialMediaType;
	}

    /*public DriverType getDriverType() {
        return this.driverType;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }*/

}