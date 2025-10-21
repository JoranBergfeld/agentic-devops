package com.joranbergfeld.agentic_devops_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.applicationinsights.attach.ApplicationInsights;

@SpringBootApplication
public class AgenticDevopsDemoApplication {

	public static void main(String[] args) {
		String applicationInsightsConnectionString = System.getenv("APPLICATIONINSIGHTS_CONNECTION_STRING");
		if (applicationInsightsConnectionString != null && !applicationInsightsConnectionString.isEmpty()) {
			ApplicationInsights.attach();
		}
		SpringApplication.run(AgenticDevopsDemoApplication.class, args);
	}

}
