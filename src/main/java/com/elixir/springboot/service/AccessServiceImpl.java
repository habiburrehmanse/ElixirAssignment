package com.elixir.springboot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.elixir.springboot.model.Access_Logs;
import com.elixir.springboot.repo.AccessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class AccessServiceImpl implements AccessService {

	@Autowired
	AccessRepo accessRepo;
	@Override
	public void SaveLogs(Access_Logs access_logs) {
		accessRepo.save(access_logs);
	}

	@Override
	public int findByDate(Date date) {
		System.out.println("date"+date);
		int countofentries=accessRepo.findbyDateime(date);
		return countofentries;
	}
}
