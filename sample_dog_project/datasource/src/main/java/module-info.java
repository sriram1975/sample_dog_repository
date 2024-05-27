module dog.datasource {
	
	exports com.acme.datasource;
	exports com.acme.datasource.model;
	
	requires java.sql;
	requires org.slf4j;
	requires jakarta.validation;
	
}