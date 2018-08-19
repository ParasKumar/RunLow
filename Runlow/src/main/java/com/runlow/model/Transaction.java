package com.runlow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@Table(name="transaction")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private double amount;

	@Column(name="amount_in_words", nullable=false)
	private String amountInWords;

	@Temporal(TemporalType.DATE)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="source_user_id", nullable=false)
	private User sourceUser;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="destination_user_id", nullable=false)
	private User destinationUser;

	//bi-directional many-to-one association to TransactionType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transaction_type_id", nullable=false)
	private TransactionType transactionType;

	//bi-directional many-to-one association to PaymentStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_status_id", nullable=false)
	private PaymentStatus paymentStatus;

	//bi-directional many-to-one association to PaymentType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_type_id", nullable=false)
	private PaymentType paymentType;

	//bi-directional many-to-one association to Booking
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id", nullable=false)
	private Booking booking;

	public Transaction() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAmountInWords() {
		return this.amountInWords;
	}

	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public User getdriver() {
		return this.sourceUser;
	}

	public void setDriver(User sourceUser) {
		this.sourceUser = sourceUser;
	}

	public User getDestinationUser() {
		return this.destinationUser;
	}

	public void setDestinationUser(User destinationUser) {
		this.destinationUser = destinationUser;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public PaymentStatus getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentType getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}