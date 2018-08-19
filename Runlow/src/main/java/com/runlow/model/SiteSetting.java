package com.runlow.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.runlow.constants.CommonConstants;

@Entity
@Table(name="site_setting")
public class SiteSetting {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@Column(name="scan_radious_in_meter", columnDefinition="Decimal(10,2) default '4.00'", nullable=true)
	private double scanRadiusInMeter;
	
	@Column(name="rate_per_km", nullable=true)
	private double ratePerKilometer;
	
	@Column(name="wating_rate_per_minute", nullable=true)
	private double waitingRatePerMinute;
	
	@Column(name="max_pre_booking_time", nullable=true)
	private BigInteger maxPreBookingTime;
	
	@Column(name="min_pre_booking_time", nullable=true)
	private double minPrebookingTime;
	
	@Column(name="max_time_before_response_from_driver", nullable=true)
	private int maxTimeBeforeResponseFromDriver;
	
	@Column(name="max_cancel_count_before_response_from_driver", nullable=true)
	private int maxCancelCountBeforeResponseFromDriver;
	
	@Column(name="driver_location_update_frequency_in_second", columnDefinition="Decimal(10,2) default '5.00'", nullable=true)
	private double driverLocationUpdateFrequencyInSecond;
	
	@Column(name="download_url", nullable=true, columnDefinition="varchar(255) default ' "+ CommonConstants.DRIVER_FILE_DOWNLOAD_URL +" '")
	private String downloadUrl; // put default value in setter as CommonConstants.DOWNLOAD_UR.
	
	@Column(name="site_name", nullable=true)
	private String siteName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getScanRadiusInMeter() {
		return scanRadiusInMeter;
	}

	public void setScanRadiusInMeter(double scanRadiusInMeter) {
		this.scanRadiusInMeter = scanRadiusInMeter;
	}

	public double getRatePerKilometer() {
		return ratePerKilometer;
	}

	public void setRatePerKilometer(double ratePerKilometer) {
		this.ratePerKilometer = ratePerKilometer;
	}

	public double getWaitingRatePerMinute() {
		return waitingRatePerMinute;
	}

	public void setWaitingRatePerMinute(double waitingRatePerMinute) {
		this.waitingRatePerMinute = waitingRatePerMinute;
	}

	public BigInteger getMaxPreBookingTime() {
		return maxPreBookingTime;
	}

	public void setMaxPreBookingTime(BigInteger maxPreBookingTime) {
		this.maxPreBookingTime = maxPreBookingTime;
	}

	public double getMinPrebookingTime() {
		return minPrebookingTime;
	}

	public void setMinPrebookingTime(double minPrebookingTime) {
		this.minPrebookingTime = minPrebookingTime;
	}

	public int getMaxTimeBeforeResponseFromDriver() {
		return maxTimeBeforeResponseFromDriver;
	}

	public void setMaxTimeBeforeResponseFromDriver(int maxTimeBeforeResponseFromDriver) {
		this.maxTimeBeforeResponseFromDriver = maxTimeBeforeResponseFromDriver;
	}

	public int getMaxCancelCountBeforeResponseFromDriver() {
		return maxCancelCountBeforeResponseFromDriver;
	}

	public void setMaxCancelCountBeforeResponseFromDriver(int maxCancelCountBeforeResponseFromDriver) {
		this.maxCancelCountBeforeResponseFromDriver = maxCancelCountBeforeResponseFromDriver;
	}

	public double getDriverLocationUpdateFrequencyInSecond() {
		return driverLocationUpdateFrequencyInSecond;
	}

	public void setDriverLocationUpdateFrequencyInSecond(double driverLocationUpdateFrequencyInSecond) {
		this.driverLocationUpdateFrequencyInSecond = driverLocationUpdateFrequencyInSecond;
	}

	public String getDownloadUrl() {
		return downloadUrl == null ? CommonConstants.DRIVER_FILE_DOWNLOAD_URL : downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = CommonConstants.DRIVER_FILE_DOWNLOAD_URL;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
}
