package com.example.demo.dao;

import com.example.demo.dto.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
}
