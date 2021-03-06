package com.employee.employeeExample;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class configCouchbase extends AbstractCouchbaseConfiguration {

    @Override
    public String getBucketName() {
        return "assignmentBucket";
    }

    @Override
    public String getConnectionString() {
        return "127.0.0.1";
        //return "localhost";
    }

    @Override
    public String getPassword() {
        return "admin1";
    }

    @Override
    public String getUserName() {
        return "admin";
    }
}
