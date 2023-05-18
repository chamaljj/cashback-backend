package com.dialogfinance.cashback.repository;

import com.dialogfinance.cashback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUserName(String userName);


}
