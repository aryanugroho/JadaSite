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

package com.jada.admin.inventory;

import java.util.Vector;

public class ShipHeaderDisplayForm {
	private String shipHeaderId;
	private String shipNum;
	private boolean updateInventory;
	private String shipStatus;
	private String shipDate;
	private String itemOrderQty;
	private String itemInvoiceQty;
	private String itemCreditQty;
	private String itemShipQty;
	private String inputShipQty;
	private PaymentTranDisplayForm paymentTran;
	private PaymentTranDisplayForm voidPaymentTran;
	private Vector<?> orderTrackings;
	public String getShipHeaderId() {
		return shipHeaderId;
	}
	public void setShipHeaderId(String shipHeaderId) {
		this.shipHeaderId = shipHeaderId;
	}
	public String getShipNum() {
		return shipNum;
	}
	public void setShipNum(String shipNum) {
		this.shipNum = shipNum;
	}
	public String getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getItemOrderQty() {
		return itemOrderQty;
	}
	public void setItemOrderQty(String itemOrderQty) {
		this.itemOrderQty = itemOrderQty;
	}
	public String getItemInvoiceQty() {
		return itemInvoiceQty;
	}
	public void setItemInvoiceQty(String itemInvoiceQty) {
		this.itemInvoiceQty = itemInvoiceQty;
	}
	public String getItemCreditQty() {
		return itemCreditQty;
	}
	public void setItemCreditQty(String itemCreditQty) {
		this.itemCreditQty = itemCreditQty;
	}
	public String getItemShipQty() {
		return itemShipQty;
	}
	public void setItemShipQty(String itemShipQty) {
		this.itemShipQty = itemShipQty;
	}
	public String getInputShipQty() {
		return inputShipQty;
	}
	public void setInputShipQty(String inputShipQty) {
		this.inputShipQty = inputShipQty;
	}
	public PaymentTranDisplayForm getPaymentTran() {
		return paymentTran;
	}
	public void setPaymentTran(PaymentTranDisplayForm paymentTran) {
		this.paymentTran = paymentTran;
	}
	public PaymentTranDisplayForm getVoidPaymentTran() {
		return voidPaymentTran;
	}
	public void setVoidPaymentTran(PaymentTranDisplayForm voidPaymentTran) {
		this.voidPaymentTran = voidPaymentTran;
	}
	public Vector<?> getOrderTrackings() {
		return orderTrackings;
	}
	public void setOrderTrackings(Vector<?> orderTrackings) {
		this.orderTrackings = orderTrackings;
	}
	public boolean isUpdateInventory() {
		return updateInventory;
	}
	public void setUpdateInventory(boolean updateInventory) {
		this.updateInventory = updateInventory;
	}
}
