package com.elixir.springboot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.elixir.springboot.model.Access_Logs;
import com.elixir.springboot.service.AccessService;
import com.elixir.springboot.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	AccessService accessService;
	@GetMapping("/fetchrecord")
	public int getCOunts(@RequestParam String date) {
		logger.info("Fetching User with Date {}", date);
		Date date1 = null;

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		}
		catch (ParseException e) {
			// Show error message
		System.out.println("InCorrect Date Format");
		}

		int accesslogscount=accessService.findByDate(date1);
		return accesslogscount;
	}

	// -------------------Save File IN DB-------------------------------------------

	@RequestMapping(value = "/savedata/", method = RequestMethod.POST)
	public String saverecordsfromfile( ) throws FileNotFoundException, ParseException {

		Scanner scanner = new Scanner(new File("Access_logs.txt"));
		int i=0;
		while (scanner.hasNextLine()) {
			i++;

			String record = scanner.nextLine();
			String[] splitspaces = record.split(" "); //split line in spaces
			System.out.println(splitspaces);
			Access_Logs access_logs=new Access_Logs();
			for(int j=0;j<splitspaces.length;j++){


				if (j==0) {
					System.out.println("Setting URL"+splitspaces[j]);

					access_logs.setUrl(splitspaces[j]);
				}
				if (j==3) {

					String date=splitspaces[j];
					String strNew = date.replace("[", "");
					System.out.println("Setting DateTime"+strNew);
					DateFormat formatter;
					Date date1;
					formatter = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss");
					date1 = formatter.parse(strNew);
					System.out.println("\t"+date1);
					access_logs.setDatatime(date1);
				}


				if(j==5){

					System.out.println("Setting RequestType"+splitspaces[j]);
					String requesttype=splitspaces[j];
					String strNew = requesttype.substring(1);
					access_logs.setRequesttype(strNew);
				}
				if(j==6){

					System.out.println("Setting Resoure"+splitspaces[j]);
					//Remove the Extra " character
					access_logs.setResourceurl(splitspaces[j]);
				}
				if(j==8){

					System.out.println("Setting Status"+splitspaces[j]);
					access_logs.setStatus(Integer.parseInt(splitspaces[j]));
				}
				//System.out.println("Remaining Parts"+splitspaces[j]);
				//
			}
			accessService.SaveLogs(access_logs);

		}


	return "Saved Successfully";
	}

	// ------------------- Update a User ------------------------------------------------


}