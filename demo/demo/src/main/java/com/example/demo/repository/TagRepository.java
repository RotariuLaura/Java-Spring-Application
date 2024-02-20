package com.example.demo.repository;


import com.example.demo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
