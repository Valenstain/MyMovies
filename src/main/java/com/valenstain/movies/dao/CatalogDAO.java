package com.valenstain.movies.dao;

import java.util.List;

public interface CatalogDAO<T> {

    public List<T> getAll();

    public T getById(int id);

    public void update(T category);

    public void deleteBuId(int id);

}
