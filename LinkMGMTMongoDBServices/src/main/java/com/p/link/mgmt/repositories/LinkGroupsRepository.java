package com.p.link.mgmt.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.p.link.mgmt.models.LinkGroup;
import com.p.link.mgmt.models.Link;

public interface LinkGroupsRepository extends MongoRepository<LinkGroup, String> {
  LinkGroup findBy_id(ObjectId _id);
}