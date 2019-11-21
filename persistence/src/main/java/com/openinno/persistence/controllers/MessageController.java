package com.openinno.persistence.controllers;

import com.openinno.domain.interfaces.RESTCRUD;
import com.openinno.domain.models.Message;
import com.openinno.logic.handlers.MessageHandler;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/messages")
public class MessageController implements RESTCRUD<Message,Long> {

    @Setter
    private MessageHandler handler;

    public MessageController() {
    }

    @Autowired
    public MessageController(MessageHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity create(Message entity) {
        return new ResponseEntity<>(handler.create(entity), HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(Long id) {
        return new ResponseEntity<>(handler.read(id), HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity readAll() {
        return new ResponseEntity<>(handler.readAll(), HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(Message entity) {
        return new ResponseEntity<>(handler.update(entity), HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(Long id) {
        return new ResponseEntity<>(handler.delete(id), HttpStatus.valueOf(200));
    }

    @RequestMapping(value = "/classify",method = RequestMethod.POST)
    public ResponseEntity classify(@RequestBody Message entity) {
        return new ResponseEntity<>(handler.classify(entity), HttpStatus.valueOf(200));
    }
}
