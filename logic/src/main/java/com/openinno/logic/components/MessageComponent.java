package com.openinno.logic.components;

import com.openinno.dal.services.MessageService;
import com.openinno.dal.services.PageService;
import com.openinno.domain.interfaces.CRUD;
import com.openinno.domain.models.Message;
import com.openinno.domain.models.Page;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MessageComponent implements CRUD<Message,Long> {

    @Setter
    private MessageService messageService;

    @Setter
    private PageService pageService;

    public MessageComponent() {
    }

    @Autowired
    public MessageComponent(MessageService messageService, PageService pageService) {
        this.messageService = messageService;
        this.pageService = pageService;
    }

    @Override
    public Message create(Message entity) {
        return messageService.create(entity);
    }

    @Override
    public Message read(Long id) {
        return messageService.read(id);
    }

    @Override
    public Iterable<Message> readAll() {
        return messageService.readAll();
    }

    @Override
    public Message update(Message entity) {
        return messageService.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return messageService.delete(id);
    }

    public Page classify(Message entity) {
        Iterable<Page> Ipages = pageService.readAll();
        List<Page> Lpages = new ArrayList<>();

        Ipages.iterator().forEachRemaining(Lpages::add);

        for (Page p: Lpages) {
            if (entity.getMessage().contains(p.getSubject())) return p;
        }

        return Lpages.get(new Random().nextInt(Lpages.size()));
    }
}
