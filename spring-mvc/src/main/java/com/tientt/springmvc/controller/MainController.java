package com.tientt.springmvc.controller;

import com.tientt.springmvc.entity.Registration;
import com.tientt.springmvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    public static String INVALID_PAGE = "invalid";
    public static String SEARCH_PAGE = "search";
    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        Registration user = registrationService.checkLogin(username, password);
        String url = "invalid";
        if (user != null) {
            HttpSession session = request.getSession();
            response.setHeader("Cache-Control", "no-cache, no-store");
            session.setAttribute("USER", user);
            url = "search";
        }
        System.out.println(url);
        return new RedirectView(url);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView renderSearchPage() {
        return new ModelAndView(SEARCH_PAGE);
    }

    @RequestMapping(value = "/invalid", method = RequestMethod.GET)
    public ModelAndView renderInvalidPage() {
        return new ModelAndView(INVALID_PAGE);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public RedirectView logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new RedirectView("login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register");
    }


}
