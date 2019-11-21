package com.openinno.logic.handlers;

import com.openinno.dal.services.MessageService;
import com.openinno.domain.interfaces.CRUD;
import com.openinno.domain.models.Message;
import com.openinno.domain.models.Page;
import com.openinno.logic.components.MessageComponent;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler implements CRUD<Message,Long> {
    @Setter
    private MessageComponent component;

    @Setter
    private MessageService service;

    public MessageHandler() {
    }

    @Autowired
    public MessageHandler(MessageComponent component, MessageService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Message create(Message entity) {
        return service.create(entity);
    }

    @Override
    public Message read(Long id) {
        return service.read(id);
    }

    @Override
    public Iterable<Message> readAll() {
        return service.readAll();
    }

    @Override
    public Message update(Message entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }

    public Page classify(Message entity) {
        return component.classify(entity);
    }
}
