package org.reciprocity.aaservice.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MemberRepository extends CrudRepository<Member, UUID> {
}
