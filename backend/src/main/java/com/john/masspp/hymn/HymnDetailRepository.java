package com.john.masspp.hymn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HymnDetailRepository extends JpaRepository<HymnDetail, Long> {
}
