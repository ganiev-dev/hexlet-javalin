package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070);

//        var app = Javalin.create(config -> {
//            config.bundledPlugins.enableDevLogging();
//            config.fileRenderer(new JavalinJte());
//        }).before(ctx -> ctx.contentType("text/html; charset=UTF-8"));



        app.get("/courses", ctx -> {
            var courses = List.of(new Course("Программирование", "Основы программирования на Java"),
                    new Course("Маркетинг", "Основы цифрового маркетинга"),
                    new Course("Кулинария", "Основы кулинарного искусства"),
                    new Course("Иностранные языки", "Основы английского языка"),
                    new Course("Финансы", "Основы личных финансов"),
                    new Course("Фотография", "Основы цифровой фотографии"),
                    new Course("Психология", "Основы общей психологии"),
                    new Course("Дизайн", "Основы веб-дизайна"),
                    new Course("Фитнес", "Основы функционального тренинга"),
                    new Course("Бизнес", "Основы предпринимательства"));
                    var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.start(7070);
    }
}