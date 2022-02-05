package pe.example.customers.api.request;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CustomerRequest implements Serializable
{

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	private Double amountSell;
	public Double getAmountSell() {
		return amountSell;
	}
	public void setAmountSell(Double amountSell) {
		this.amountSell = amountSell;
	}

	private int registerUserId;
	public int getRegisterUserId() {
		return registerUserId;
	}
	public void setRegisterUserId(int registerUserId) {
		this.registerUserId = registerUserId;
	}

	private String registerUserFullname;
	public String getRegisterUserFullname() {
		return registerUserFullname;
	}
	public void setRegisterUserFullname(String registerUserFullname) {
		this.registerUserFullname = registerUserFullname;
	}

	private Date registerDatetime;
	public Date getRegisterDatetime() {
		return registerDatetime;
	}
	public void setRegisterDatetime(Date registerDatetime) {
		this.registerDatetime = registerDatetime;
	}

	private Boolean active;
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

}