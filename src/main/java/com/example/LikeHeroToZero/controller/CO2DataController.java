package com.example.likeherotozero.controller;

import com.example.likeherotozero.model.CO2Data;
import com.example.likeherotozero.service.CO2DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CO2DataController {

    @Autowired
    private CO2DataService co2DataService;

    @GetMapping("/")
    public String viewCo2DataPublic(Model model) {
        List<CO2Data> co2dataList = co2DataService.getApprovedCO2Data();
        model.addAttribute("co2dataList", co2dataList);
        return "co2data-public";
    }

    @GetMapping("/co2data")
    public String viewCo2DataAuthenticated(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("co2dataList", co2DataService.getAllCO2Data());
        return "co2data";
    }

    @GetMapping("/co2data/add")
    public String showAddForm(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("co2data", new CO2Data());
        return "co2data-form";
    }

    @PostMapping("/co2data/add")
    public String addCO2Data(HttpSession session, @ModelAttribute CO2Data co2Data) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        co2DataService.save(co2Data);
        return "redirect:/co2data";
    }

    @GetMapping("/co2data/edit/{id}")
    public String showEditForm(HttpSession session, @PathVariable Long id, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        CO2Data co2Data = co2DataService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid CO2Data Id:" + id));
        model.addAttribute("co2data", co2Data);
        return "co2data-form";
    }

    @PostMapping("/co2data/edit/{id}")
    public String editCO2Data(HttpSession session, @PathVariable int id, @ModelAttribute CO2Data co2Data) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        co2Data.setId(id);
        co2DataService.save(co2Data);
        return "redirect:/co2data";
    }

    @GetMapping("/co2data/delete/{id}")
    public String deleteCO2Data(HttpSession session, @PathVariable Long id) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        co2DataService.deleteById(id);
        return "redirect:/co2data";
    }
}


