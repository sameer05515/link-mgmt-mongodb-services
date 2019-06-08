package com.p.link.mgmt;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.p.link.mgmt.models.LinkGroup;
import com.p.link.mgmt.repositories.LinkGroupsRepository;

@RestController
@RequestMapping("/linkgroups")
public class LinkGroupController {
	@Autowired
	private LinkGroupsRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<LinkGroup> getAllLinki() {
		return repository.findAll();
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public long getCount() {
		return repository.count();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public LinkGroup getPetById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody LinkGroup LinkGroup) {
		LinkGroup.set_id(id);
		LinkGroup.setLastModified(new Date());
		repository.save(LinkGroup);
	}

	//  @RequestMapping(value = "/{id}/markRead", method = RequestMethod.PUT)
	//  public void markRead(@PathVariable("id") String id, @Valid @RequestBody LinkGroup LinkGroup) {
	//    LinkGroup.set_id(id);
	//    LinkGroup.setLastRead(new Date());
	//    LinkGroup.addReadHistory(new Date());
	//    repository.save(LinkGroup);
	//  }

	  @RequestMapping(value = "/{id}/addLink", method = RequestMethod.PUT)
	  public void addLink(@PathVariable("id") String id,@PathVariable("linkId") String linkId, @Valid @RequestBody LinkGroup LinkGroup) {
	    LinkGroup.set_id(id);
	    LinkGroup.setLastModified(new Date());
	    LinkGroup.addLink(linkId);
	    repository.save(LinkGroup);
	  }

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public LinkGroup createPet(@Valid @RequestBody LinkGroup LinkGroup) {
		LinkGroup.set_id(ObjectId.get().toHexString());
		LinkGroup.setCreatedDate(new Date());
		repository.save(LinkGroup);
		return LinkGroup;
	}

	@RequestMapping(value = "/multi", method = RequestMethod.POST)
	public List<LinkGroup> createPet(@Valid @RequestBody List<LinkGroup> Linkilist) {
		for(LinkGroup LinkGroup:Linkilist){
			LinkGroup.set_id(ObjectId.get().toHexString());
			LinkGroup.setCreatedDate(new Date());
			repository.save(LinkGroup);
		}

		return Linkilist;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}