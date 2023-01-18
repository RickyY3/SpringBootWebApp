package com.example.webApp.repo;

import com.example.webApp.domain.Publisher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    public Publisher findByName(String name);
}
