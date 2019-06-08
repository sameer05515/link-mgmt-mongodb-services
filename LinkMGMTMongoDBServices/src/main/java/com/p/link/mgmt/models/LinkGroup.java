package com.p.link.mgmt.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "linkgroupscollection")
public class LinkGroup {

	@Id
	private String _id;
	private String name;
	private String groupDescription;
	private Date createdDate;
	private Date lastModified;
	
	List<String> relatedLinks;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
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

	public List<String> getRelatedLinks() {
		return relatedLinks;
	}

	public void setRelatedLinks(List<String> relatedLinks) {
		this.relatedLinks = relatedLinks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkGroup [_id=");
		builder.append(_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", groupDescription=");
		builder.append(groupDescription);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", lastModified=");
		builder.append(lastModified);
		builder.append(", relatedLinks=");
		builder.append(relatedLinks);
		builder.append("]");
		return builder.toString();
	}

	public void addLink(String linkId) {
		if (linkId == null || linkId.trim().equals("")) {
			return;
		}
		relatedLinks.add(linkId);
		
	}
	
	
}
