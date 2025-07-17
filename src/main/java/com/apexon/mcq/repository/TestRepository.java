package com.apexon.mcq.repository;


import com.apexon.mcq.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}


