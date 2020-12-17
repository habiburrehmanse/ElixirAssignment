package com.elixir.springboot.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tbl_access_logs", schema = "public", catalog = "elixir_db")

public class Access_Logs {
@Id
@GeneratedValue
@Column(name="id")
	private long id;

	@Column(name="url")
	private String url;
	@Column(name="datetime")
	private Date datatime;
	@Column(name="requesttype")
	private String requesttype;

	@Column(name = "resourceurl")
	private String resourceurl;
	@Column(name="status")
	private int status;

	public String getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}

	public String getResourceurl() {
		return resourceurl;
	}

	public void setResourceurl(String resourceurl) {
		this.resourceurl = resourceurl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Access_Logs() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Access_Logs(long id, String url, Date datatime, String requesttype, String resourceurl, int status) {
		this.id = id;
		this.url = url;
		this.datatime = datatime;
		this.requesttype = requesttype;
		this.resourceurl = resourceurl;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Access_Logs{" +
				"id=" + id +
				", url='" + url + '\'' +
				", datatime=" + datatime +
				", requesttype='" + requesttype + '\'' +
				", resourceurl='" + resourceurl + '\'' +
				", status=" + status +
				'}';
	}

	public Date getDatatime() {
		return datatime;
	}

	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}
}
