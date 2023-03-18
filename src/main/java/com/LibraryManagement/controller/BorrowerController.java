package com.LibraryManagement.controller;

import com.LibraryManagement.entity.Borrower;
import com.LibraryManagement.entity.MyBorrowerList;
import com.LibraryManagement.service.BorrowerService;
import com.LibraryManagement.service.MyBorrowerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class BorrowerController {

    @Autowired
    public BorrowerService service;

    @Autowired
    private MyBorrowerListService myBorrowerListService;


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/borrower_register")
    public String borrowerRegister(){
        return "borrowerRegister";
    }

    @GetMapping("/available_borrowers")
    public ModelAndView getAllBook() {
        List<Borrower> list = service.getAllBorrower();
        ModelAndView m=new ModelAndView();
        m.setViewName("borrowerList");
        m.addObject("borrower", list);
        return new ModelAndView("borrowerList","borrower",list);
    }

    @PostMapping("/save")
    public String addBorrower(@ModelAttribute Borrower p){
        service.save(p);
        return "redirect:/available_borrowers";
    }
   @GetMapping("/my_borrowes")
    public String getMyBorrowers(Model model){
        List<Borrower> list= myBorrowerListService.getAllMyBorrowers();
        model.addAttribute("borrowers",list);
        return "MyBorrowers";}

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id")int id){
        Borrower p= service.getBorrowerById(id);

        MyBorrowerList mp=new MyBorrowerList(p.getId(),p.getName(), p.getEmail(), (int) p.getPhone_number());
        myBorrowerListService.saveMyBorrower(mp);
        return "redirect:/my_borrowes";}


    @RequestMapping("/editBorrower/{id}")
    public String editBorrower(@PathVariable("id")int id, Model model){
        Borrower p=service.getBorrowerById(id);
        model.addAttribute("borrower",p);
        return"borrowerEdit";
    }
    @RequestMapping("/deleteBorrower/{id}")
    public String deleteBorrower(@PathVariable("id")int id){
        service.deleteById(id);
        return "redirect:/available_borrowers";
    }

}
