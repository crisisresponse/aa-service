package org.reciprocity.aaservice.repository.member;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PeopleRepository extends CrudRepository<People, UUID>  {


    List<People> findAllByPrimaryContact(People person);
}
