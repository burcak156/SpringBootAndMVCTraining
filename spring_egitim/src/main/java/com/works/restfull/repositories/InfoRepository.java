package com.works.restfull.repositories;

import com.works.restfull.entities.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Integer> {

}