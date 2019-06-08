package com.p.link.mgmt.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "linkscollection")
public class Link {

	@Id
	private String _id;
	private String url;
	private String linkDescription;
	private Date createdDate;
	private Date lastModified;
	private Date lastRead;
	
	private List<String> tags;
	
	private List<Date> readHistory;

	public void addReadHistory(Date date) {
		if (date == null) {
			return;
		}
		readHistory.add(date);
	}
	
	public void addTag(String tag) {
		
		if (tag == null || tag.trim().equals("")) {
			return;
		}
		tags.add(tag);
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getLastRead() {
		return lastRead;
	}

	public void setLastRead(Date lastRead) {
		this.lastRead = lastRead;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link [_id=");
		builder.append(_id);
		builder.append(", url=");
		builder.append(url);
		builder.append(", linkDescription=");
		builder.append(linkDescription);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModified=");
		builder.append(lastModified);
		builder.append(", lastRead=");
		builder.append(lastRead);
		builder.append(", tags=");
		builder.append(tags);
		builder.append("]");
		return builder.toString();
	}

	public List<Date> getReadHistory() {
		return readHistory;
	}

	public void setReadHistory(List<Date> readHistory) {
		this.readHistory = readHistory;
	}
	
	
	
	
	
}
