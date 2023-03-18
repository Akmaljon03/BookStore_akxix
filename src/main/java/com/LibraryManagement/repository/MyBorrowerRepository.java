package com.LibraryManagement.repository;


import com.LibraryManagement.entity.Borrower;
import com.LibraryManagement.entity.MyBorrowerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBorrowerRepository extends JpaRepository<MyBorrowerList, Integer> {
}
