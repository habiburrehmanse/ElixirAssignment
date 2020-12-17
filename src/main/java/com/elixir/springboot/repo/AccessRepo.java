package com.elixir.springboot.repo;

import com.elixir.springboot.model.Access_Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

public interface AccessRepo extends JpaRepository<Access_Logs,Long> {
    @Query(value = "select count(*) from public.tbl_access_logs where date(datetime)=:date",nativeQuery = true)
    int findbyDateime(@Param("date") Date date);
}
