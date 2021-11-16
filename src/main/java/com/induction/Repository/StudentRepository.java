package com.induction.Repository;

import com.induction.Baranidharan.TestDb;
import com.induction.DataModel.RetroFitTestApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<TestDb, Integer> {

    @Query("SELECT c.id  FROM RetroFitTestApi AS c GROUP BY c.id ORDER BY c.id DESC")
    abstract List<RetroFitTestApi> findByNameEndsWith();

}
