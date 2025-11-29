package org.example.hexlet;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.fileRenderer(new JavalinJte());
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> ctx.render("index.jte"));
        app.start(7070);
    }
}