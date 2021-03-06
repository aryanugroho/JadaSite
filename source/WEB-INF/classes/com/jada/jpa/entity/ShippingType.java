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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * ShippingType generated by hbm2java
 */
@Entity
@Table(name = "shipping_type", uniqueConstraints = @UniqueConstraint(columnNames = {
		"shipping_type_name", "site_id" }))
public class ShippingType implements java.io.Serializable {

	private static final long serialVersionUID = -408072618239216616L;
	private Long shippingTypeId;
	private String shippingTypeName;
	private char systemRecord;
	private String recUpdateBy;
	private Date recUpdateDatetime;
	private String recCreateBy;
	private Date recCreateDatetime;
	private String siteId;
	private Set<ShippingMethodRegionType> shippingMethodRegionTypes = new HashSet<ShippingMethodRegionType>(
			0);
	private Site site;

	public ShippingType() {
	}

	public ShippingType(String shippingTypeName, char systemRecord,
			String recUpdateBy, Date recUpdateDatetime, String recCreateBy,
			Date recCreateDatetime, String siteId, Site site) {
		this.shippingTypeName = shippingTypeName;
		this.systemRecord = systemRecord;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.siteId = siteId;
		this.site = site;
	}

	public ShippingType(String shippingTypeName, char systemRecord,
			String recUpdateBy, Date recUpdateDatetime, String recCreateBy,
			Date recCreateDatetime, String siteId,
			Set<ShippingMethodRegionType> shippingMethodRegionTypes, Site site) {
		this.shippingTypeName = shippingTypeName;
		this.systemRecord = systemRecord;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.siteId = siteId;
		this.shippingMethodRegionTypes = shippingMethodRegionTypes;
		this.site = site;
	}

	@Id
	@GeneratedValue
	@Column(name = "shipping_type_id", nullable = false)
	public Long getShippingTypeId() {
		return this.shippingTypeId;
	}

	public void setShippingTypeId(Long shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
	}

	@Column(name = "shipping_type_name", nullable = false, length = 40)
	public String getShippingTypeName() {
		return this.shippingTypeName;
	}

	public void setShippingTypeName(String shippingTypeName) {
		this.shippingTypeName = shippingTypeName;
	}

	@Column(name = "system_record", nullable = false, length = 1)
	public char getSystemRecord() {
		return this.systemRecord;
	}

	public void setSystemRecord(char systemRecord) {
		this.systemRecord = systemRecord;
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

	@Column(name = "site_id", nullable = false, insertable = false, updatable = false, length = 20)
	public String getSiteId() {
		return this.siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shippingType")
	public Set<ShippingMethodRegionType> getShippingMethodRegionTypes() {
		return this.shippingMethodRegionTypes;
	}

	public void setShippingMethodRegionTypes(
			Set<ShippingMethodRegionType> shippingMethodRegionTypes) {
		this.shippingMethodRegionTypes = shippingMethodRegionTypes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
