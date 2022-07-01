package com.revature.controller;
import com.revature.model.Gremlin;
import com.revature.service.GremlinService;
import io.javalin.http.Handler;


public class GremlinController {

    GremlinService gremlinService = new GremlinService();

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
