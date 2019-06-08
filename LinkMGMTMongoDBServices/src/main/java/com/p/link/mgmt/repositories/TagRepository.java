package com.p.link.mgmt.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.p.link.mgmt.models.Tag;

public interface TagRepository extends MongoRepository<Tag, String> {
  Tag findBy_id(ObjectId _id);
}