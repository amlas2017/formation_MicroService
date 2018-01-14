package org.sid.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.sid.rmi.ScolariteRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {
		
	//@Bean
	public ResourceConfig getJersey(){
		ResourceConfig config = new ResourceConfig();
		config.register(EtudiantRestService.class);
		return config;		
	}

	@Bean
	public SimpleJaxWsServiceExporter getJWS(){
	SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
	exporter.setBaseAddress("http://0.0.0.0:8585/service");	
	return exporter;
	}
	
	/*
	@Bean
	@Autowired
	public RmiServiceExporter getRmiExporter(ScolariteRemote rmiService){
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setRegistryPort(1099);
		exporter.setServiceName("SCOLARITE");
		exporter.setService(rmiService);
		return exporter;		
	}    
	*/
}
