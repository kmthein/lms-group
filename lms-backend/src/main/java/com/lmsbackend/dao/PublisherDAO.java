package com.lmsbackend.dao;

import com.lmsbackend.entity.Publisher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublisherDAO {
    public void save(Publisher publisher);

    public List<Publisher> getPublisher();

    public Publisher getPublisherById(int id);

    public void updatePublisher(Publisher publisher);

    public void deletePublisher(int id);
}
