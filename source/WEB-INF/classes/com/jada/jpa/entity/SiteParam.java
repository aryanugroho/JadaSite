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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SiteParam generated by hbm2java
 */
@Entity
@Table(name = "site_param")
public class SiteParam implements java.io.Serializable {

	private static final long serialVersionUID = -6148779318828406765L;
	private Long siteParamId;
	private String siteParamName;
	private String siteParamValue;
	private String recUpdateBy;
	private Date recUpdateDatetime;
	private String recCreateBy;
	private Date recCreateDatetime;

	public SiteParam() {
	}

	public SiteParam(String siteParamName, String siteParamValue,
			String recUpdateBy, Date recUpdateDatetime, String recCreateBy,
			Date recCreateDatetime) {
		this.siteParamName = siteParamName;
		this.siteParamValue = siteParamValue;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
	}

	@Id
	@GeneratedValue
	@Column(name = "site_param_id", nullable = false)
	public Long getSiteParamId() {
		return this.siteParamId;
	}

	public void setSiteParamId(Long siteParamId) {
		this.siteParamId = siteParamId;
	}

	@Column(name = "site_param_name", nullable = false, length = 60)
	public String getSiteParamName() {
		return this.siteParamName;
	}

	public void setSiteParamName(String siteParamName) {
		this.siteParamName = siteParamName;
	}

	@Column(name = "site_param_value", nullable = false, length = 100000000)
	public String getSiteParamValue() {
		return this.siteParamValue;
	}

	public void setSiteParamValue(String siteParamValue) {
		this.siteParamValue = siteParamValue;
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

}
