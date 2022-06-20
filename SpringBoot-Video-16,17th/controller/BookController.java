package milliwatt.phuc.crudbook.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import milliwatt.phuc.crudbook.dto.BookRequest;
import milliwatt.phuc.crudbook.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String,Book> books;
    //ConcurrentHashMap tăng tính đồng bộ trong dự án
    public BookController(){
        books = new ConcurrentHashMap<>();
        books.put("0X-13", new Book("0X-13","Gone with the wind","Cuong",1945));
        books.put("0X-14", new Book("0X-14","Chi dau","Nam Khong Thap",1960));
        books.put("0X-15", new Book("0X-15","Tat den","Tat To",1960));
    }

    @GetMapping
    public List<Book> getBooks(){
        return books.values().stream().toList();
    }

    @PostMapping
    public Book createNewBook(@RequestBody BookRequest bookRequest){
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid,bookRequest.title(),bookRequest.author(),bookRequest.year());
        books.put(uuid,newBook);
        return newBook;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") String id){
        return books.get(id);
    }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable("id") String id, @RequestBody BookRequest bookRequest){
        Book updateBook = new Book(id,bookRequest.title(),bookRequest.author(),bookRequest.year());
        //books.put(id,updateBook); ưu điểm là tạo danh sach mới nếu id k có
        books.replace(id, updateBook);

        return updateBook;
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable("id") String id){
        Book removeBook = books.remove(id);
        return removeBook;
    }

}
