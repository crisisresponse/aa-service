package org.reciprocity.aaservice.repository.siteconfig;

import org.reciprocity.aaservice.repository.siteconfig.AvailableService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceConfigRepository extends JpaRepository<AvailableService, Long> {
}
