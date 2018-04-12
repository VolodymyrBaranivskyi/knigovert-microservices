package core;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shera on 29.03.2018.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String authorName;
    @Column(nullable = false)
    private String authorSurname;
    private String summary;
    private Integer publicationYear;
    private Double rate;
    @ElementCollection
    private List<Long> usersId;
    private Genre genre;

    protected Book(){}

    public Book(String title, String authorName, String authorSurname,
                String summary, Integer publicationYear, Double rate,
                List<Long> usersId, Genre genre) {

        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.summary = summary;
        this.publicationYear = publicationYear;
        this.rate = rate;
        this.usersId = usersId;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<Long> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<Long> usersId) {
        this.usersId = usersId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{ "
                + "title: "+ title
                + ", author: " + authorSurname +" " + authorName +" }";
    }
}
