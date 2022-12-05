package ru.dautov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
//        if (action.equals("multiplication")) {
//            model.addAttribute("result", a*b);
//            return "first/calc";
//        } else if (action.equals("addition")) {
//            model.addAttribute("result", a+b);
//            return "first/calc";
//        } else if (action.equals("subtraction")) {
//            model.addAttribute("result", a-b);
//            return "first/calc";
//        } else if (action.equals("division")) {
//            double res= a/(double)b;
//            model.addAttribute("result", res);
//            return "first/calc";
//        } else {
//            return action;
//        }

        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double)b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result);
        return "first/calc";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {

//        System.out.println(name + " " + surname);
        model.addAttribute("message", name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
