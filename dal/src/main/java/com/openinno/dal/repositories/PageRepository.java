package com.openinno.dal.repositories;

import com.openinno.domain.models.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("PageRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "pages")
public interface PageRepository extends PagingAndSortingRepository<Page, Long> {
}
