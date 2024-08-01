package com.valenstain.movies.service;

import com.valenstain.movies.dao.CatalogDAO;
import com.valenstain.movies.entity.Movie;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements CatalogService<Movie> {

    @Resource(name = "moviesDAOImpl")
    private CatalogDAO<Movie> moviesDAO;

    @Override
    @Transactional
    public List<Movie> getAll() {
        return moviesDAO.getAll();
    }

    @Override
    @Transactional
    public Movie getById(int id) {
        return moviesDAO.getById(id);
    }

    @Override
    @Transactional
    public void update(Movie category) {
        moviesDAO.update(category);
    }

    @Override
    @Transactional
    public void deleteBuId(int id) {
        moviesDAO.deleteBuId(id);
    }
}
