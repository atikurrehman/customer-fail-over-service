package com.example.customerfailoverservice.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.customerfailoverservice.pojo.Customer;

import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {

	public Mono<ServerResponse> listEmployees(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(Mono.just(Arrays.asList(Customer.builder().id(0).name("Atik").build())), List.class);

	}

	public Mono<ServerResponse> getEmployeeById(ServerRequest request) {
		int id = Integer.parseInt(request.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(Mono.just(Customer.builder().id(id).name("test").build()), Customer.class);

	}

}
