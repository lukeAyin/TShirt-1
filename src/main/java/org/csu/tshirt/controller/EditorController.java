package org.csu.tshirt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditorController {
    @GetMapping("/editor")
    public String viewEditor(){
        return "editor";
    }


}
