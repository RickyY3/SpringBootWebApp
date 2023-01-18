package com.example.webApp.bootstrap;

import com.example.webApp.domain.Author;
import com.example.webApp.domain.Book;
import com.example.webApp.domain.Publisher;
import com.example.webApp.repo.AuthorRepo;
import com.example.webApp.repo.BookRepo;
import com.example.webApp.repo.PublisherRepo;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher();
        publisher1.setName("Guru");
        publisher1.setCity("Las Vegas City");
        publisher1.setState("Las Vegas");

        publisherRepo.save(publisher1);

        Author ricky = new Author("Ricky", "You");
        Book book = new Book("Isle of dogs", "112112");
        ricky.getBooks().add(book);
        book.getAuthors().add(ricky);
        publisher1.getBooks().add(book);
        book.setPublisher(publisher1);

        authorRepo.save(ricky);
        bookRepo.save(book);

        publisherRepo.save(publisher1);

        Author dick = new Author("Dick", "King");
        Book book2 = new Book("Psychopath", "122122");
        dick.getBooks().add(book2);
        book2.getAuthors().add(dick);
        publisher1.getBooks().add(book2);
        book2.setPublisher(publisher1);

        authorRepo.save(dick);
        bookRepo.save(book2);

        publisherRepo.save(publisher1);

        System.out.println("Number of Publishers: " + publisherRepo.count());
        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publisher Number of Books: " + publisherRepo.findByName("Guru").getBooks().size());
    }
}
