module dog.api {

	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.context;
	requires spring.beans;
	requires spring.web;
	requires spring.core;
	requires spring.aop;
	requires org.apache.tomcat.embed.core;
	requires dog.datasource;
	requires jakarta.validation;

	opens com.acme.api;
	opens com.acme.api.controller to spring.beans, spring.core, spring.web;
	opens com.acme.api.service to spring.beans;

}