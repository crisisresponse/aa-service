package org.reciprocity.aaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceConfigRepository extends JpaRepository<AvailableService, Long> {
}
