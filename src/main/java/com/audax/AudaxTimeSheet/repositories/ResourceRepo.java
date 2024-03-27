package com.audax.AudaxTimeSheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audax.AudaxTimeSheet.entities.Resource;

@Repository
public interface ResourceRepo extends JpaRepository<Resource,Long>{

}
