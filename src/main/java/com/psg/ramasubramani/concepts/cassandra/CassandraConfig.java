package com.psg.ramasubramani.concepts.cassandra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import lombok.Getter;
import lombok.Setter;


/**
 * @author rn5
 *
 */
@Getter
@Setter
@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {
	@Value("${cassandra.cluster.ip}")
	private String cassandraIP;
	@Value("${cassandra.port}")
	private int port;
	@Value("${cassandra.keyspace}")
	private String keyspace;
	@Value("${cassandra.basePackages}")
	private String basePackages;

	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}
	
	@Override
	protected boolean getMetricsEnabled() {
		return false;
	}
}