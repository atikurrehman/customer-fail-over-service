package com.example.customerfailoverservice.configuration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;

@Profile("local-descovery")
@EnableDiscoveryClient
public class LocalDiscovery {

}
