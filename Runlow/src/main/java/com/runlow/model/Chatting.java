package com.runlow.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the chatting database table.
 * 
 */
@Entity
@Table(name="chatting")
@NamedQuery(name="Chatting.findAll", query="SELECT c FROM Chatting c")
public class Chatting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(nullable=false)
	private String message;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="source_user_id", nullable=false)
	private User driver;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="destination_user_id", nullable=false)
	private User passenger;

	public Chatting() {
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

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getDriver() {
		return this.driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public User getPassenger() {
		return this.passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}

}