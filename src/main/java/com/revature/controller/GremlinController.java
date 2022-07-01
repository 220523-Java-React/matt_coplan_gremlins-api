package com.revature.controller;

import com.revature.model.Gremlin;
import com.revature.service.GremlinService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;


public class GremlinController {

    private GremlinService gremlinService;

    public Handler createNewGremlin = ctx -> {
        Gremlin gremlin = ctx.bodyAsClass(Gremlin.class);

        // make sure gremlin was created
        try {
            ctx.json(gremlinService.createNewGremlin(gremlin));
        } catch (NullPointerException e) {
            ctx.status(400).result("Could not create the gremlin");
        }
    };

    public Handler getAllGremlins = ctx -> {
        ctx.json(gremlinService.getAllGremlins());
    };
}
