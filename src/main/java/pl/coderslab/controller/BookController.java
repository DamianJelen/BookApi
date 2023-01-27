package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pojo.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService bookService;

    @Autowired
    public BookController(MockBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.delBook(bookId);
    }

    @PutMapping("")
    public void modifyBook(@RequestBody Book mBook) {
        bookService.modBook(mBook);
    }
}
