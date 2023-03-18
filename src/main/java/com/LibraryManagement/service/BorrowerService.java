package com.LibraryManagement.service;

import com.LibraryManagement.entity.Borrower;
import com.LibraryManagement.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowerService {
    @Autowired
    public BorrowerRepository pRepo;
    public void save(Borrower p){
        pRepo.save(p);
    }
    public List<Borrower> getAllBorrower(){
        return pRepo.findAll();
    }


    public Borrower getBorrowerById(int id){
        return pRepo.findById(id).get();
    }
    public void deleteById(int id){
        pRepo.deleteById(id);
    }
}
