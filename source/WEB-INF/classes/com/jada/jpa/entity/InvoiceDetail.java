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

/**
 * InvoiceDetail generated by hbm2java
 */
@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail implements java.io.Serializable {

	private static final long serialVersionUID = -4642947451186872514L;
	private Long invoiceDetailId;
	private Integer seqNum;
	private Integer itemInvoiceQty;
	private Float itemInvoiceAmount;
	private String recUpdateBy;
	private Date recUpdateDatetime;
	private String recCreateBy;
	private Date recCreateDatetime;
	private Set<InvoiceDetailTax> invoiceDetailTaxes = new HashSet<InvoiceDetailTax>(
			0);
	private InvoiceHeader invoiceHeader;
	private OrderItemDetail orderItemDetail;

	public InvoiceDetail() {
	}

	public InvoiceDetail(Integer seqNum, Integer itemInvoiceQty,
			Float itemInvoiceAmount, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime) {
		this.seqNum = seqNum;
		this.itemInvoiceQty = itemInvoiceQty;
		this.itemInvoiceAmount = itemInvoiceAmount;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
	}

	public InvoiceDetail(Integer seqNum, Integer itemInvoiceQty,
			Float itemInvoiceAmount, String recUpdateBy,
			Date recUpdateDatetime, String recCreateBy, Date recCreateDatetime,
			Set<InvoiceDetailTax> invoiceDetailTaxes,
			InvoiceHeader invoiceHeader, OrderItemDetail orderItemDetail) {
		this.seqNum = seqNum;
		this.itemInvoiceQty = itemInvoiceQty;
		this.itemInvoiceAmount = itemInvoiceAmount;
		this.recUpdateBy = recUpdateBy;
		this.recUpdateDatetime = recUpdateDatetime;
		this.recCreateBy = recCreateBy;
		this.recCreateDatetime = recCreateDatetime;
		this.invoiceDetailTaxes = invoiceDetailTaxes;
		this.invoiceHeader = invoiceHeader;
		this.orderItemDetail = orderItemDetail;
	}

	@Id
	@GeneratedValue
	@Column(name = "invoice_detail_id", nullable = false)
	public Long getInvoiceDetailId() {
		return this.invoiceDetailId;
	}

	public void setInvoiceDetailId(Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}

	@Column(name = "seq_num", nullable = false)
	public Integer getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	@Column(name = "item_invoice_qty", nullable = false)
	public Integer getItemInvoiceQty() {
		return this.itemInvoiceQty;
	}

	public void setItemInvoiceQty(Integer itemInvoiceQty) {
		this.itemInvoiceQty = itemInvoiceQty;
	}

	@Column(name = "item_invoice_amount", nullable = false)
	public Float getItemInvoiceAmount() {
		return this.itemInvoiceAmount;
	}

	public void setItemInvoiceAmount(Float itemInvoiceAmount) {
		this.itemInvoiceAmount = itemInvoiceAmount;
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

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_detail_id", updatable = false)
	public Set<InvoiceDetailTax> getInvoiceDetailTaxes() {
		return this.invoiceDetailTaxes;
	}

	public void setInvoiceDetailTaxes(Set<InvoiceDetailTax> invoiceDetailTaxes) {
		this.invoiceDetailTaxes = invoiceDetailTaxes;
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
	@JoinColumn(name = "order_item_detail_id")
	public OrderItemDetail getOrderItemDetail() {
		return this.orderItemDetail;
	}

	public void setOrderItemDetail(OrderItemDetail orderItemDetail) {
		this.orderItemDetail = orderItemDetail;
	}

}
