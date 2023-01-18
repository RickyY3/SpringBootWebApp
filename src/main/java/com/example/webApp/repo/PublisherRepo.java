package com.example.webApp.repo;

import com.example.webApp.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    Publisher findByName(String name);
}
