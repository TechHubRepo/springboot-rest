package com.techhub.demo.springbootrest.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * The ValidationTestDao
 * 
 * @author ramniwash
 */
public class ValidationTestDao {

	@NotNull(message = "id must be null")
	private String id;

	@NotNull(message = "name Must not null")
	@Pattern(message = "name is Invalid", regexp = "[A-Z][a-zA-Z ]+")
	private String name;

	@NotBlank(message = "email Must not blank")
	@Email(message = "invalid email")
	private String email;

	@NotNull(message = "mobileNumber is required")
	@Min(value = 1000000000,message = "Mobile number must be of 10 digits")
	@Digits(integer = 10, message = "Mobile number must be of 10 digits", fraction = 0)
	private BigDecimal mobileNumber;

	@Negative(message = "numberA must be Negative")
	private int numberA;

	@Positive(message = "numberB must be Positive")
	private int numberB;

	@Min(value = 50, message = "Minimum value can be 50")
	@Max(value = 100, message = "Maximum value can be 100")
	private int numberC;

	@NotNull(message = "dateA is required")
	@PastOrPresent(message = "dateA must be past or present date")
	private Date dateA;

	@NotNull(message = "dateB is required")
	@FutureOrPresent(message = "dateB must be future or present date")
	private java.util.Date dateB;

	@NotNull(message = "localDate is required")
	@Future(message = "localDate must be future date")
	private LocalDate localDate;

	@NotNull(message = "localDateTime is required")
	@Past(message = "localDateTime must be past date")
	private LocalDateTime localDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigDecimal mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getNumberA() {
		return numberA;
	}

	public void setNumberA(int numberA) {
		this.numberA = numberA;
	}

	public int getNumberB() {
		return numberB;
	}

	public void setNumberB(int numberB) {
		this.numberB = numberB;
	}

	public int getNumberC() {
		return numberC;
	}

	public void setNumberC(int numberC) {
		this.numberC = numberC;
	}

	public Date getDateA() {
		return dateA;
	}

	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}

	public java.util.Date getDateB() {
		return dateB;
	}

	public void setDateB(java.util.Date dateB) {
		this.dateB = dateB;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
}
