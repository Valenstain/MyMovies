package com.valenstain.movies.controllers;

import com.valenstain.movies.entity.Category;
import com.valenstain.movies.entity.Movie;
import com.valenstain.movies.service.CatalogService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Catalog {

    @Resource(name = "categoriesServiceImpl")
    private CatalogService<Category> catalogService;
    @Resource(name = "moviesServiceImpl")
    private CatalogService<Movie> movieService;

    private void attrPage(Model model, String title) {
        model.addAttribute("categories", catalogService.getAll());
        model.addAttribute("title", title);
    }

    private void contentModel(Model model, int id) {

        model.addAttribute("catId", id);

        String title = "All movies";
        List<Movie> movies = movieService.getAll();

        if (id > 0) {
            Category category = catalogService.getById(id);
            title = category.getName();
            movies = category.getMovies();
        }

        attrPage(model, title);
        model.addAttribute("movies",  movies);
        model.addAttribute("countMovies", movies.size());
    }

    @GetMapping("/")
    public String index(Model model) {
        contentModel(model, 0);
        return "index";
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable("id") int id, Model model) {
        contentModel(model, id);
        return "index";
    }

    @GetMapping("/movie/add/{id}")
    public String addMovie(Model model, @PathVariable("id") int id) {
        attrPage(model, "Add new movie");
        Movie newMovie = new Movie();
        newMovie.setCategory((id > 0 ) ? catalogService.getById(id) : new Category());
        model.addAttribute("movie", newMovie);
        return "movie";
    }

    @GetMapping("/movie/{id}")
    public String editMovie(Model model, @PathVariable("id") int id) {
        Movie movie = movieService.getById(id);
        model.addAttribute("movie",  movie);
        attrPage(model, "Edit movie: " + movie.getName());
        return "movie";
    }

    @GetMapping("/delete-movie/{id}")
    public String deleteMovie(Model model, @PathVariable("id") int id) {
        movieService.deleteBuId(id);
        return "redirect:/";
    }

    @PostMapping("/movie/save")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            attrPage(model, (movie.getId() > 0) ? "Edit movie: " + movie.getName() : "Add new movie");
            return "movie";
        }

        movieService.update(movie);
        return "redirect:/category/" + movie.getCategory().getId();
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        attrPage(model, "Add new category");
        model.addAttribute("category", new Category());
        return "category";
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(Model model, @PathVariable("id") int id) {
        Category category = catalogService.getById(id);
        model.addAttribute("category", category);
        attrPage(model, "Edit category: " + category.getName());
        return "category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(Model model, @PathVariable("id") int id) {
        catalogService.deleteBuId(id);
        return "redirect:/";
    }

    @PostMapping("/category/save")
    public String saveCategory(Model model, @Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            attrPage(model, (category.getId() > 0) ? "Edit category: " + category.getName() : "Add new category");
            return "category";
        }

        catalogService.update(category);
        return "redirect:/category/" + category.getId();
    }
}
