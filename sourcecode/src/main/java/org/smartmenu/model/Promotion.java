package org.smartmenu.model;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity("Promotion")
public class Promotion
{
	@Id
	private String  objectId;
	private Integer promotion_ID; 
	private String promotion_text_EN; 
	private String promotion_text_AR; 
	private Integer Promotion_price; 
	private String Promotion_status; 
	private String Promotion_time; 
	
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Integer getPromotion_ID() {
		return promotion_ID;
	}
	public void setPromotion_ID(Integer promotion_ID) {
		this.promotion_ID = promotion_ID;
	}
	public String getPromotion_text_EN() {
		return promotion_text_EN;
	}
	public void setPromotion_text_EN(String promotion_text_EN) {
		this.promotion_text_EN = promotion_text_EN;
	}
	public String getPromotion_text_AR() {
		return promotion_text_AR;
	}
	public void setPromotion_text_AR(String promotion_text_AR) {
		this.promotion_text_AR = promotion_text_AR;
	}
//	public Hashtable<String, Integer> getItems() {
//		return items;
//	}
//	public void setItems(Hashtable<String, Integer> items) {
//		this.items = items;
//	}
	public Integer getPromotion_price() {
		return Promotion_price;
	}
	public void setPromotion_price(Integer promotion_price) {
		Promotion_price = promotion_price;
	}
	public String getPromotion_status() {
		return Promotion_status;
	}
	public void setPromotion_status(String promotion_status) {
		Promotion_status = promotion_status;
	}
	public String getPromotion_time() {
		return Promotion_time;
	}
	public void setPromotion_time(String promotion_time) {
		Promotion_time = promotion_time;
	}

	 
	
	
}
