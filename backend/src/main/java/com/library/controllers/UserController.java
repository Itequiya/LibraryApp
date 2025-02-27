package com.library.controllers;
package com.library.controllers;
import com.library.model.Book;
import com.library.model.Library;
import com.library.service.LibraryService;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    public Book getBookByTitle(@RequestParam("title") String title){
        return userService.getUser(title);
    }

    @PostMapping("/AddUser")
    public Book AddBook(@RequestBody Book book){
        return userService.AddUser(book);
    }
    @DeleteMapping("/deleteUser")
    public void deleteBook(@RequestParam String title){
        userService.DeleteUser(title);
    }
}
