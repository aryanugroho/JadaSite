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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ShippingMethod generated by hbm2java
 */
@Entity
@Table(name = "shipping_method")
public class ShippingMethod implements java.io.Serializable {

	private static final long serialVersionUID = -6406462949382640008L;
	private Long shippingMethodId;
	private int seqNum;
	private char published;
	private String recUpdateBy;
	private Date recUpdateDatetime;
	private String recCreateBy;
	private Date recCreateDatetime;
	private String siteId;
	private ShippingMethodLanguage shippingMethodLanguage;
	private Set<ShippingMethodRegion> shippingMethodRegions = new HashSet<ShippingMethodRegion>(
			0);
	private Set<ShippingMethodLanguage> shippingMethodLanguages = new HashSet<ShippingMethodLanguage>(
			0);
	private Site site;

	public ShippingMethod() {
	}

	public ShippingMethod(int seqNum, char published, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime,
			String siteId, ShippingMethodLanguage shippingMethodLanguage,
			Site site) {
		this.seqNum = seqNum;
		this.published = published;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.siteId = siteId;
		this.shippingMethodLanguage = shippingMethodLanguage;
		this.site = site;
	}

	public ShippingMethod(int seqNum, char published, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime,
			String siteId, ShippingMethodLanguage shippingMethodLanguage,
			Set<ShippingMethodRegion> shippingMethodRegions,
			Set<ShippingMethodLanguage> shippingMethodLanguages, Site site) {
		this.seqNum = seqNum;
		this.published = published;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.siteId = siteId;
		this.shippingMethodLanguage = shippingMethodLanguage;
		this.shippingMethodRegions = shippingMethodRegions;
		this.shippingMethodLanguages = shippingMethodLanguages;
		this.site = site;
	}

	@Id
	@GeneratedValue
	@Column(name = "shipping_method_id", nullable = false)
	public Long getShippingMethodId() {
		return this.shippingMethodId;
	}

	public void setShippingMethodId(Long shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	@Column(name = "seq_num", nullable = false)
	public int getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
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

	@Column(name = "site_id", nullable = false, insertable = false, updatable = false, length = 20)
	public String getSiteId() {
		return this.siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipping_method_lang_id", nullable = false)
	public ShippingMethodLanguage getShippingMethodLanguage() {
		return this.shippingMethodLanguage;
	}

	public void setShippingMethodLanguage(
			ShippingMethodLanguage shippingMethodLanguage) {
		this.shippingMethodLanguage = shippingMethodLanguage;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "shipping_method_id", updatable = false)
	public Set<ShippingMethodRegion> getShippingMethodRegions() {
		return this.shippingMethodRegions;
	}

	public void setShippingMethodRegions(
			Set<ShippingMethodRegion> shippingMethodRegions) {
		this.shippingMethodRegions = shippingMethodRegions;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipping_method_id", updatable = false)
	public Set<ShippingMethodLanguage> getShippingMethodLanguages() {
		return this.shippingMethodLanguages;
	}

	public void setShippingMethodLanguages(
			Set<ShippingMethodLanguage> shippingMethodLanguages) {
		this.shippingMethodLanguages = shippingMethodLanguages;
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
