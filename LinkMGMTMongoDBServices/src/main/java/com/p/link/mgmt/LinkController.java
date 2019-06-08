package com.p.link.mgmt;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.p.link.mgmt.models.Link;
import com.p.link.mgmt.repositories.LinksRepository;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {
  @Autowired
  private LinksRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Link> getAllLinki() {
    return repository.findAll();
  }
  
  @RequestMapping(value = "/count", method = RequestMethod.GET)
  public long getCount() {
    return repository.count();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Link getPetById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Link Link) {
    Link.set_id(id);
    Link.setLastModified(new Date());
    repository.save(Link);
  }
  
  @RequestMapping(value = "/{id}/markRead", method = RequestMethod.PUT)
  public void markRead(@PathVariable("id") String id, @Valid @RequestBody Link Link) {
    Link.set_id(id);
    Link.setLastRead(new Date());
    Link.addReadHistory(new Date());
    repository.save(Link);
  }
  
  @RequestMapping(value = "/{id}/addTag", method = RequestMethod.PUT)
  public void addTag(@PathVariable("id") String id,@PathVariable("tag") String tag, @Valid @RequestBody Link Link) {
    Link.set_id(id);
    Link.setLastModified(new Date());
    Link.addTag(tag);
    repository.save(Link);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Link createPet(@Valid @RequestBody Link Link) {
    Link.set_id(ObjectId.get().toHexString());
    Link.setCreatedDate(new Date());
    repository.save(Link);
    return Link;
  }
  
  @RequestMapping(value = "/multi", method = RequestMethod.POST)
  public List<Link> createPet(@Valid @RequestBody List<Link> Linkilist) {
	  for(Link Link:Linkilist){
		  Link.set_id(ObjectId.get().toHexString());
		  Link.setCreatedDate(new Date());
		    repository.save(Link);
	  }
    
    return Linkilist;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}