package com.library.controllers;
import com.library.model.Copy;
import com.library.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("copy/")
public class CopyController {
    @Autowired
    private CopyService copyService;

    @PostMapping("/addCopy")
    public Copy addCopy(@RequestBody Copy copy){
        return copyService.addCopy(copy);
    }
    @PatchMapping ("/changeStatus")
    public void changeStatus (@RequestParam("copyId") Long copyId, @RequestParam  ("statusCopyId") Long statusCopyId){
        copyService.changeStatus(copyId, statusCopyId);
    }
}
