package com.openinno.dal.services;

import com.openinno.dal.repositories.MessageRepository;
import com.openinno.domain.interfaces.CRUD;
import com.openinno.domain.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements CRUD<Message,Long> {

    @Qualifier("MessageRepository")
    @Autowired
    private MessageRepository repository;

    @Override
    public Message create(Message entity) {
        return repository.save(entity);
    }

    @Override
    public Message read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<Message> readAll() {
        return repository.findAll();
    }

    @Override
    public Message update(Message entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
