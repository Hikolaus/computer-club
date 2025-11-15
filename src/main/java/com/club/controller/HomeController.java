package com.club.controller;

import com.club.service.ComputerService;
import com.club.service.TournamentService;
import com.club.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;

@Controller
public class HomeController {

    @Autowired
    private ComputerService computerService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private TariffService tariffService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("computers", computerService.getAvailableComputers());
        model.addAttribute("tournaments", tournamentService.getPublishedTournaments());
        model.addAttribute("currentYear", Year.now().getValue());
        return "home";
    }

    @GetMapping("/computers")
    public String computers(Model model) {
        model.addAttribute("computers", computerService.getAllComputers());
        model.addAttribute("currentYear", Year.now().getValue());
        return "computers";
    }

    @GetMapping("/tournaments")
    public String tournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        model.addAttribute("currentYear", Year.now().getValue());
        return "tournaments";
    }

    @GetMapping("/tariffs")
    public String tariffs(Model model) {
        model.addAttribute("tariffs", tariffService.getAllTariffs());
        model.addAttribute("currentYear", Year.now().getValue());
        return "tariffs";
    }

    @GetMapping("/support")
    public String support(Model model) {
        model.addAttribute("currentYear", Year.now().getValue());
        return "support";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("currentYear", Year.now().getValue());
        return "profile";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("currentYear", Year.now().getValue());
        return "login";
    }
}