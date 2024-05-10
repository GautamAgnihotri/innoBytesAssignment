package com.example.ELibrary.Management.Repository;

import com.example.ELibrary.Management.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
