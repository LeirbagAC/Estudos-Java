package com.gabriel.SpringBootWeb1;

import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("Home");
        return "index";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num, int num2) {
        System.out.println("in add");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");

        int result = num + num2;
        mv.addObject("result", result);

        System.out.println(result);
        return mv;
    }

    @RequestMapping("addAlien")
    public String addAlien(Alien alien) { //@ModelAtributte opcional
        return "result";
    }

//    }
//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session) {
//        System.out.println("in add");
//
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        session.setAttribute("result", result);
//
//        System.out.println(result);
//        return "result.jsp";
//    }

}