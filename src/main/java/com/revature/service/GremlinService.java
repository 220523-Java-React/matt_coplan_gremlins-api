package com.revature.service;

import com.revature.model.Gremlin;
import com.revature.repository.GremlinRepository;

import java.util.List;

public class GremlinService {

    GremlinRepository gremlinRepository = new GremlinRepository();

    public Gremlin createNewGremlin(Gremlin gremlin) {
        return gremlinRepository.create(gremlin);
    }

    public List<Gremlin> getAllGremlins() {
        return gremlinRepository.getAll();
    }
}
