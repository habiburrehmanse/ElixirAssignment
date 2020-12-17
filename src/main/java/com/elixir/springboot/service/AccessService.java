package com.elixir.springboot.service;


import com.elixir.springboot.model.Access_Logs;

import java.time.LocalDate;
import java.util.Date;

public interface AccessService {
	
	void SaveLogs(Access_Logs access_logs);
	
	int findByDate(Date date);

}
