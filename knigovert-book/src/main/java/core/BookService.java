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

@Service
public class BookService {

    private static BookRepository bookRepository;
    private static final int BOOKS_PER_PAGE = 3;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
        populateDB();
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

    public void populateDB()
    {
        bookRepository.save(new Book("FirstBook","authorName","authorSurname",
                "Bestseller", 2018, 5.0, Genre.SCIFI));
        bookRepository.save(new Book("SecondBook","authorName","authorSurname",
                "Bestseller", 2018, 5.0, Genre.FANTASY));
        bookRepository.save(new Book("ThirdBook","authorName","authorSurname",
                "Bestseller", 2018, 5.0, Genre.SCIFI));
        bookRepository.save(new Book("FourthBook","authorName","authorSurname",
                "Bestseller", 2018, 5.0, Genre.SCIFI));

    }

}
