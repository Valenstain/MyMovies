package com.valenstain.movies.dao;

import com.valenstain.movies.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesDAOImpl implements CatalogDAO<Category> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    public void update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Category updatedCat = session.merge(category);
        category.setId(updatedCat.getId());
    }

    @Override
    public void deleteBuId(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createMutationQuery("delete from Category where id = :id").setParameter("id", id).executeUpdate();
    }
}
