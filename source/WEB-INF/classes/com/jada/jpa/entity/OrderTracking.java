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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrderTracking generated by hbm2java
 */
@Entity
@Table(name = "order_tracking")
public class OrderTracking implements java.io.Serializable {

	private static final long serialVersionUID = -5911797772444810944L;
	private Long orderTrackingId;
	private String orderTrackingCode;
	private String orderTrackingMessage;
	private String orderTrackingInternal;
	private String recUpdateBy;
	private Date recUpdateDatetime;
	private String recCreateBy;
	private Date recCreateDatetime;
	private OrderHeader orderHeader;
	private InvoiceHeader invoiceHeader;
	private CreditHeader creditHeader;
	private ShipHeader shipHeader;

	public OrderTracking() {
	}

	public OrderTracking(String orderTrackingCode, String orderTrackingMessage,
			String orderTrackingInternal, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime) {
		this.orderTrackingCode = orderTrackingCode;
		this.orderTrackingMessage = orderTrackingMessage;
		this.orderTrackingInternal = orderTrackingInternal;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
	}

	public OrderTracking(String orderTrackingCode, String orderTrackingMessage,
			String orderTrackingInternal, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime,
			OrderHeader orderHeader, InvoiceHeader invoiceHeader,
			CreditHeader creditHeader, ShipHeader shipHeader) {
		this.orderTrackingCode = orderTrackingCode;
		this.orderTrackingMessage = orderTrackingMessage;
		this.orderTrackingInternal = orderTrackingInternal;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.orderHeader = orderHeader;
		this.invoiceHeader = invoiceHeader;
		this.creditHeader = creditHeader;
		this.shipHeader = shipHeader;
	}

	@Id
	@GeneratedValue
	@Column(name = "order_tracking_id", nullable = false)
	public Long getOrderTrackingId() {
		return this.orderTrackingId;
	}

	public void setOrderTrackingId(Long orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}

	@Column(name = "order_tracking_code", nullable = false, length = 3)
	public String getOrderTrackingCode() {
		return this.orderTrackingCode;
	}

	public void setOrderTrackingCode(String orderTrackingCode) {
		this.orderTrackingCode = orderTrackingCode;
	}

	@Column(name = "order_tracking_message", nullable = false, length = 255)
	public String getOrderTrackingMessage() {
		return this.orderTrackingMessage;
	}

	public void setOrderTrackingMessage(String orderTrackingMessage) {
		this.orderTrackingMessage = orderTrackingMessage;
	}

	@Column(name = "order_tracking_internal", nullable = false, length = 1)
	public String getOrderTrackingInternal() {
		return this.orderTrackingInternal;
	}

	public void setOrderTrackingInternal(String orderTrackingInternal) {
		this.orderTrackingInternal = orderTrackingInternal;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_header_id")
	public OrderHeader getOrderHeader() {
		return this.orderHeader;
	}

	public void setOrderHeader(OrderHeader orderHeader) {
		this.orderHeader = orderHeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_header_id")
	public InvoiceHeader getInvoiceHeader() {
		return this.invoiceHeader;
	}

	public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_header_id")
	public CreditHeader getCreditHeader() {
		return this.creditHeader;
	}

	public void setCreditHeader(CreditHeader creditHeader) {
		this.creditHeader = creditHeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ship_header_id")
	public ShipHeader getShipHeader() {
		return this.shipHeader;
	}

	public void setShipHeader(ShipHeader shipHeader) {
		this.shipHeader = shipHeader;
	}

}
