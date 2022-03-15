package com.example;

import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TomcatAsyncIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomcatAsyncIssueApplication.class, args);
	}

}

@RestController
class MyController {

	@PostMapping("/file")
	Mono<String> handle(@RequestPart("file") Mono<FilePart> filePart) {
		return filePart.map(part -> String.format("%s:%s", part.filename(), part.name()));
	}


}
