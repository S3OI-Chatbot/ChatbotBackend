package com.openinno.dal.services;

import com.openinno.dal.repositories.PageRepository;
import com.openinno.domain.interfaces.CRUD;
import com.openinno.domain.models.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PageService implements CRUD<Page, Long> {

    @Qualifier("PageRepository")
    @Autowired
    private PageRepository repository;

    @Override
    public Page create(Page entity) {
        return repository.save(entity);
    }

    @Override
    public Page read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Page> readAll() {
        return repository.findAll();
    }

    @Override
    public Page update(Page entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
