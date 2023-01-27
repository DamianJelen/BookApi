package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.pojo.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MockBookService {
    private List<Book> books;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming"));
        books.add(new Book(4L, "978-83-246-8184-6", "Spring w akcji", "Willie Wheeler, Joshua White", "Helion", "programming"));
        books.add(new Book(5L, "978-83-283-5606-1", "Spring w akcji. Wydanie V", "Craig Walls", "Helion", "programming"));
        books.add(new Book(6L, "9780130819338", "Java. Efektywne programowanie", "Bloch Joshua ", "Helion", "programming"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(Long idBook) {
        return books.stream().filter(book -> book.getId() == idBook)
                .findFirst().orElse(null);
    }

    public void addBook(Book book) {
        int lastPosBook = books.size() - 1;
        book.setId(books.get(lastPosBook).getId() + 1);
        books.add(book);
    }

    public void modBook(Book mBook) {
        for(Book book : books) {
            if(book.getId() == mBook.getId()) {
                book.setIsbn(mBook.getIsbn());
                book.setTitle(mBook.getTitle());
                book.setAuthor(mBook.getAuthor());
                book.setPublisher(mBook.getPublisher());
                book.setType(mBook.getType());
            }
        }
    }

    public void delBook(Long idBook) {
        books = books.stream().filter(book -> book.getId() != idBook)
                .collect(Collectors.toList());
    }
}
