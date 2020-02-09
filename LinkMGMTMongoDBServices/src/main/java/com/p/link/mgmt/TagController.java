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

import com.p.link.mgmt.models.Tag;
import com.p.link.mgmt.repositories.TagRepository;

@RestController
@RequestMapping("/tags")
public class TagController {
  @Autowired
  private TagRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Tag> getAllTagi() {
    return repository.findAll();
  }
  
  @RequestMapping(value = "/count", method = RequestMethod.GET)
  public long getCount() {
    return repository.count();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Tag getPetById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
//  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//  public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Tag Tag) {
//    Tag.set_id(id);
//    Tag.setLastModified(new Date());
//    repository.save(Tag);
//  }
  
//  @RequestMapping(value = "/{id}/markRead", method = RequestMethod.PUT)
//  public void markRead(@PathVariable("id") String id, @Valid @RequestBody Tag Tag) {
//    Tag.set_id(id);
//    Tag.setLastRead(new Date());
//    Tag.addReadHistory(new Date());
//    repository.save(Tag);
//  }
//  
//  @RequestMapping(value = "/{id}/addTag", method = RequestMethod.PUT)
//  public void addTag(@PathVariable("id") String id,@PathVariable("tag") String tag, @Valid @RequestBody Tag Tag) {
//    Tag.set_id(id);
//    Tag.setLastModified(new Date());
//    Tag.addTag(tag);
//    repository.save(Tag);
//  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Tag createPet(@Valid @RequestBody Tag Tag) {
    Tag.set_id(ObjectId.get().toHexString());
    Tag.setCreatedDate(new Date());
    repository.save(Tag);
    return Tag;
  }
  
  @RequestMapping(value = "/multi", method = RequestMethod.POST)
  public List<Tag> createPet(@Valid @RequestBody List<Tag> Tagilist) {
	  for(Tag Tag:Tagilist){
		  Tag.set_id(ObjectId.get().toHexString());
		  Tag.setCreatedDate(new Date());
		    repository.save(Tag);
	  }
    
    return Tagilist;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}