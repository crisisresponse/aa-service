package org.reciprocity.aaservice.repository.siteconfig;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ServiceConfigRepository extends JpaRepository<Services, Long> {


    Services findAllByCategoryEndsWithAndAndModifiedDate(String category, LocalDate modifiedDate);
}
