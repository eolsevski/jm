package com.in28minutes.springboot.soap.web.services.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialSoapWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialSoapWebServicesApplication.class, args);
	}
}



/*
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <GetStudentDetailsRequest xmlns="students">
            <id>1</id>
        </GetStudentDetailsRequest>
    </Body>
</Envelope>
 */