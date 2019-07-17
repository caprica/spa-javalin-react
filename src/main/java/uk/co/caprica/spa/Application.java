package uk.co.caprica.spa;

import io.javalin.Javalin;
import uk.co.caprica.spa.controller.UserController;
import uk.co.caprica.spa.controller.VersionController;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
            .get("/api/users", UserController.users)
            .get("/api/users/:username", UserController.user)
            .get("/api/*", ctx -> ctx.status(400))                // Any unmapped API will result in a 400 Bad Request
            .get("version", VersionController.version);

        app.config
            .addStaticFiles("/app")                                     // The ReactJS application
            .addStaticFiles("/")                                        // Other static assets, external to the ReactJS application
            .addSinglePageRoot("/", "/app/index.html");   // Catch-all route for the single-page application

        app.start(8080);
    }

}
