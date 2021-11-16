package com.induction.Repository;

import com.induction.Baranidharan.TestDb;
import com.induction.DataModel.RetroFitTestApi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestApiInterface  extends JpaRepository<RetroFitTestApi, Integer> {

}
