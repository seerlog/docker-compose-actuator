package com.example.goldminecompanies;

import com.example.goldminecompanies.mining.RealTimeGoldMining;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoldMineCompaniesApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(GoldMineCompaniesApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.run(args);

		RealTimeGoldMining realTimeGoldMining = new RealTimeGoldMining();
		realTimeGoldMining.goldMining();
	}

}
