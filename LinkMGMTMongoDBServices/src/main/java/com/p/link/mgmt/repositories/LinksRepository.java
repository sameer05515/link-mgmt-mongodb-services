package com.p.link.mgmt.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.p.link.mgmt.models.Link;

public interface LinksRepository extends MongoRepository<Link, String> {
  Link findBy_id(ObjectId _id);
}