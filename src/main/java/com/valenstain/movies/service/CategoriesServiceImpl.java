package com.valenstain.movies.service;

import com.valenstain.movies.dao.CatalogDAO;
import com.valenstain.movies.entity.Category;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CatalogService<Category> {

    @Resource(name="categoriesDAOImpl")
    private CatalogDAO<Category> catalogDAO;

    @Override
    @Transactional
    public List<Category> getAll() {
        return catalogDAO.getAll();
    }

    @Override
    @Transactional
    public Category getById(int id) {
        return catalogDAO.getById(id);
    }

    @Override
    @Transactional
    public void update(Category category) {
        catalogDAO.update(category);
    }

    @Override
    @Transactional
    public void deleteBuId(int id) {
        catalogDAO.deleteBuId(id);
    }
}
