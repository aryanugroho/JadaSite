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

package com.jada.content.data;

public class ShoppingCartSummaryInfo {
	ItemInfo cartItems[];
	String itemCount;
	String priceSubTotal;
	public String getItemCount() {
		return itemCount;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
	public String getPriceSubTotal() {
		return priceSubTotal;
	}
	public void setPriceSubTotal(String priceSubTotal) {
		this.priceSubTotal = priceSubTotal;
	}
	public ItemInfo[] getCartItems() {
		return cartItems;
	}
	public void setCartItems(ItemInfo[] cartItems) {
		this.cartItems = cartItems;
	}
}
