package com.rentalsforshare.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "motels")
public class Motel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The student id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String description;
	private BigDecimal price;
	private String city;
	private String ward;
	private String street;
	private String address;
	private String latitude;
	private String longitude;
	private Boolean available;
	private String avatar;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
	@JoinColumn(name = "categoryId")
	@JsonIgnore
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;

	@OneToMany(targetEntity = ImageMotel.class, mappedBy = "motel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ImageMotel> imageMotels;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<ImageMotel> getImageMotels() {
		return imageMotels;
	}

	public void setImageMotels(Set<ImageMotel> imageMotels) {
		this.imageMotels = imageMotels;
	}

}
