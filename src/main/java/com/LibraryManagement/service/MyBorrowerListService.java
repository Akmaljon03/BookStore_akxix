package com.LibraryManagement.service;

import com.LibraryManagement.entity.Borrower;
import com.LibraryManagement.entity.MyBorrowerList;
import com.LibraryManagement.repository.MyBorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MyBorrowerListService {
    @Autowired
    private MyBorrowerRepository myborrower;

    public void saveMyBorrower(MyBorrowerList borrower){myborrower.save(borrower);}

    public List<Borrower> getAllMyBorrowers() {return myborrower.findAll();}

    public void deleteById(int id) {myborrower.deleteById(id);}
}