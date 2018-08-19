package com.runlow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the driver_type database table.
 * 
 */
@Entity
@Table(name="driver_type")
@NamedQuery(name="DriverType.findAll", query="SELECT d FROM DriverType d")
public class DriverType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="driver_type_name", nullable=false)
	private String driverTypeName;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	//bi-directional many-to-one association to User
	/*@OneToMany(mappedBy="driverType")
	private List<User> users;*/

	public DriverType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDriverTypeName() {
		return this.driverTypeName;
	}

	public void setDriverTypeName(String driverTypeName) {
		this.driverTypeName = driverTypeName;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/*public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	/*public User addUser(User user) {
		getUsers().add(user);
		user.setDriverType(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setDriverType(null);

		return user;
	}*/

}