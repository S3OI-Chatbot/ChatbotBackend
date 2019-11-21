package com.openinno.dal.repositories;

import com.openinno.domain.models.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("MessageRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "messages")
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
}
