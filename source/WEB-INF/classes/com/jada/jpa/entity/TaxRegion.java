/*
 * Copyright 2007-2010 JadaSite.

 * This file is part of JadaSite.
 
 * JadaSite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * JadaSite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with JadaSite.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jada.jpa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TaxRegion generated by hbm2java
 */
@Entity
@Table(name = "tax_region")
public class TaxRegion implements java.io.Serializable {

	private static final long serialVersionUID = -8195327546529162429L;
	private Long taxRegionId;
	private String taxRegionDesc;
	private char published;
	private String recUpdateBy;
	private Date recUpdateDatetime;
	private String recCreateBy;
	private Date recCreateDatetime;
	private Set<Country> countries = new HashSet<Country>(0);
	private Set<State> states = new HashSet<State>(0);
	private Set<TaxRegionZip> zipCodes = new HashSet<TaxRegionZip>(0);
	private Set<TaxRegionProduct> productClasses = new HashSet<TaxRegionProduct>(
			0);
	private ProductClass shippingProductClass;
	private Site site;

	public TaxRegion() {
	}

	public TaxRegion(String taxRegionDesc, char published, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime) {
		this.taxRegionDesc = taxRegionDesc;
		this.published = published;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
	}

	public TaxRegion(String taxRegionDesc, char published, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime,
			Set<Country> countries, Set<State> states,
			Set<TaxRegionZip> zipCodes, Set<TaxRegionProduct> productClasses,
			ProductClass shippingProductClass, Site site) {
		this.taxRegionDesc = taxRegionDesc;
		this.published = published;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.countries = countries;
		this.states = states;
		this.zipCodes = zipCodes;
		this.productClasses = productClasses;
		this.shippingProductClass = shippingProductClass;
		this.site = site;
	}

	@Id
	@GeneratedValue
	@Column(name = "taxRegionId", nullable = false)
	public Long getTaxRegionId() {
		return this.taxRegionId;
	}

	public void setTaxRegionId(Long taxRegionId) {
		this.taxRegionId = taxRegionId;
	}

	@Column(name = "taxRegionDesc", nullable = false, length = 40)
	public String getTaxRegionDesc() {
		return this.taxRegionDesc;
	}

	public void setTaxRegionDesc(String taxRegionDesc) {
		this.taxRegionDesc = taxRegionDesc;
	}

	@Column(name = "published", nullable = false, length = 1)
	public char getPublished() {
		return this.published;
	}

	public void setPublished(char published) {
		this.published = published;
	}

	@Column(name = "rec_update_by", nullable = false, length = 20)
	public String getRecUpdateBy() {
		return this.recUpdateBy;
	}

	public void setRecUpdateBy(String recUpdateBy) {
		this.recUpdateBy = recUpdateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rec_update_datetime", nullable = false)
	public Date getRecUpdateDatetime() {
		return this.recUpdateDatetime;
	}

	public void setRecUpdateDatetime(Date recUpdateDatetime) {
		this.recUpdateDatetime = recUpdateDatetime;
	}

	@Column(name = "rec_create_by", nullable = false, length = 20)
	public String getRecCreateBy() {
		return this.recCreateBy;
	}

	public void setRecCreateBy(String recCreateBy) {
		this.recCreateBy = recCreateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rec_create_datetime", nullable = false)
	public Date getRecCreateDatetime() {
		return this.recCreateDatetime;
	}

	public void setRecCreateDatetime(Date recCreateDatetime) {
		this.recCreateDatetime = recCreateDatetime;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@OrderBy(value="countryId")
	@JoinTable(name = "tax_region_country", joinColumns = { @JoinColumn(name = "tax_region_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "country_id", nullable = false, updatable = false) })
	public Set<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@OrderBy(value="stateId")
	@JoinTable(name = "tax_region_state", joinColumns = { @JoinColumn(name = "tax_region_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "state_id", nullable = false, updatable = false) })
	public Set<State> getStates() {
		return this.states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy(value="taxRegionZipId")
	@JoinColumn(name = "tax_region_id", updatable = false)
	public Set<TaxRegionZip> getZipCodes() {
		return this.zipCodes;
	}

	public void setZipCodes(Set<TaxRegionZip> zipCodes) {
		this.zipCodes = zipCodes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy(value="taxRegionProductId")
	@JoinColumn(name = "tax_region_id", updatable = false)
	public Set<TaxRegionProduct> getProductClasses() {
		return this.productClasses;
	}

	public void setProductClasses(Set<TaxRegionProduct> productClasses) {
		this.productClasses = productClasses;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_class_id")
	public ProductClass getShippingProductClass() {
		return this.shippingProductClass;
	}

	public void setShippingProductClass(ProductClass shippingProductClass) {
		this.shippingProductClass = shippingProductClass;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id")
	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
