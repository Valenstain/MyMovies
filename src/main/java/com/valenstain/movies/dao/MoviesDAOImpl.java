package com.valenstain.movies.dao;

import com.valenstain.movies.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesDAOImpl implements CatalogDAO<Movie> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Movie> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Movie", Movie.class).getResultList();
    }

    @Override
    public Movie getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Movie.class, id);
    }

    @Override
    public void update(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        Movie updatedMovie = session.merge(movie);
        movie.setId(updatedMovie.getId());
    }

    @Override
    public void deleteBuId(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createMutationQuery("delete from Movie where id = :id").setParameter("id", id).executeUpdate();
    }
}
