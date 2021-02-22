package org.launchcode.hellospringtemplate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {

// Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

@GetMapping("goodbye")
@ResponseBody
public String goodbye() {
    return "Goodbye, Spring!";
}

// Handles requests of the form /hello?name=LaunchCode
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
public String helloWithQueryParam(@RequestParam String name, Model model) {
    String greeting = "Hello, " + name + "!";
    //first attribute has to match name given to template variable
    //second attribute has to match up with local variable
    model.addAttribute("greeting", greeting);
    return "hello";
}

// Handles requests of the form /hello/LaunchCode
@GetMapping("hello/{name}")
public String helloWithPathParam(@PathVariable String name, Model model) {
    String greeting = "Hello, " + name + "!";
    model.addAttribute("greeting", greeting);
    return "hello";
}


@GetMapping("form")
public String helloForm() {
    return "form";
        }

@GetMapping("hello-names")
public String helloNames(Model model){
    List<String> names = new ArrayList<>();
    names.add("Java");
    names.add("LaunchCode");
    names.add("Python");
    model.addAttribute("names", names);
    return "hello-list";
}



    }
