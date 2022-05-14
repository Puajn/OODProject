package com.example.accessingdatarest.repository;

import com.example.accessingdatarest.models.Items;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Items,String> {
    Items findByItemID(String ID);
}
