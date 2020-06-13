package com.example.customerfailoverservice.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.customerfailoverservice.handler.CustomerHandler;

@Configuration
public class RouterConfiguration {

	@Bean
	public RouterFunction<ServerResponse> listEmployeesRoute(CustomerHandler employeeHandler) {
		return route(GET("/customers-fail-over").and(accept(MediaType.APPLICATION_JSON)),
				employeeHandler::listEmployees);
	}

	@Bean
	public RouterFunction<ServerResponse> employeeByIdRoute(CustomerHandler employeeHandler) {
		return route(GET("/customers-fail-over/{id}").and(accept(MediaType.APPLICATION_JSON)),
				employeeHandler::getEmployeeById);
	}
}
