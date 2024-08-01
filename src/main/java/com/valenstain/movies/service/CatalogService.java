package com.valenstain.movies.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogService<T> {

    public List<T> getAll();

    public T getById(int id);

    public void update(T category);

    public void deleteBuId(int id);

}
