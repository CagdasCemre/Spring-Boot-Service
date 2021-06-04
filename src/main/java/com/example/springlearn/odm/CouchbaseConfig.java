package com.example.springlearn.odm;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

	@Override
	public String getConnectionString() {
		return "couchbase://127.0.0.1";
	}

	@Override
	public String getUserName() {
		return "Administrator";
	}

	@Override
	public String getPassword() {
		return "5nTlq928";
	}

	@Override
	public String getBucketName() {
		return "default";
	}

}