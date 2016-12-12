package org.smartmenu.model;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;




@Entity("DashboardItem")
public class DashboardItem
{
	@Id
	private String objectId;
	private Integer order;
	private String text_AR;
	private String text_EN;
	private String descriptive_URI;
	
	public DashboardItem(){}
	
	public DashboardItem(Integer order, String text_AR, String text_EN,
			String descriptive_URI) 
	{
		super();
		this.order = order;
		this.text_AR = text_AR;
		this.text_EN = text_EN;
		this.descriptive_URI = descriptive_URI;
	}
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getText_AR() {
		return text_AR;
	}

	public void setText_AR(String text_AR) {
		this.text_AR = text_AR;
	}

	public String getText_EN() {
		return text_EN;
	}

	public void setText_EN(String text_EN) {
		this.text_EN = text_EN;
	}

	public String getDescriptive_URI() {
		return descriptive_URI;
	}

	public void setDescriptive_URI(String descriptive_URI) {
		this.descriptive_URI = descriptive_URI;
	}


	
	

	
}
