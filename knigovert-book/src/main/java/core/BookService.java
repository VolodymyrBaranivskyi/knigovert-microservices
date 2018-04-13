package core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private static BookRepository bookRepository;
    private static final int BOOKS_PER_PAGE = 3;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public static List<Book> findAllBooks(int page) {
        Page<Book> booksPerPage = bookRepository.findAll(
                PageRequest.of(page, BOOKS_PER_PAGE));
        return booksPerPage.getContent();
    }

    public static Book findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public static List<Book> findBooksByGenre(Genre genre, int page) {
        Page<Book> booksPerPage = bookRepository.findByGenre(genre, PageRequest.of(page, BOOKS_PER_PAGE));
        return booksPerPage.getContent();
    }

    public static Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public static Book updateBook(Long id, Book updatedBook) {
        Book book = bookRepository.findById(id);
        Optional.ofNullable(updatedBook.getAuthorName()).ifPresent(book::setAuthorName);
        Optional.ofNullable(updatedBook.getAuthorSurname()).ifPresent(book::setAuthorSurname);
        Optional.ofNullable(updatedBook.getGenre()).ifPresent(book::setGenre);
        Optional.ofNullable(updatedBook.getPublicationYear()).ifPresent(book::setPublicationYear);
        Optional.ofNullable(updatedBook.getRate()).ifPresent(book::setRate);
        Optional.ofNullable(updatedBook.getSummary()).ifPresent(book::setSummary);
        Optional.ofNullable(updatedBook.getTitle()).ifPresent(book::setTitle);
        return bookRepository.save(book);
    }
}
