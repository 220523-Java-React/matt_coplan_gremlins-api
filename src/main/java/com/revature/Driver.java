package com.revature;

import com.revature.controller.GremlinController;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        GremlinController gremlinController = new GremlinController();

        Javalin app = Javalin.create().start(8080);

        app.get("/",  ctx -> ctx.result("Welcome to Gremlin app!"));

        app.get("/gremlins", gremlinController.getAllGremlins);
        app.post("/gremlins", gremlinController.createNewGremlin);
    }
}
