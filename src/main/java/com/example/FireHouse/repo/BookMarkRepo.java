package com.example.FireHouse.repo;

import com.example.FireHouse.entity.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BookMarkRepo extends JpaRepository<BookMark, Integer> {
}
