package com.induction.Repository;

import com.induction.Baranidharan.TestDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<TestDb, Integer> {


}
