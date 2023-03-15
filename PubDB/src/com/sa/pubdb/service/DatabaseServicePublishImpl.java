package com.sa.pubdb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServicePublishImpl implements Database {

	private Connection connection;
	private String databaseConnectionLink;
	private String databaseUser;
	private String databasePassword;

	public DatabaseServicePublishImpl() {
		super();
		this.databaseConnectionLink = "jdbc:mysql://localhost:3306/pub?characterEncoding=latin1&useConfigs=maxPerformance";
		this.databaseUser = "root";
		this.databasePassword = "";
	}

	@SuppressWarnings("finally")
	@Override
	public Connection getDatabaseConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = (Connection) DriverManager.getConnection(databaseConnectionLink, databaseUser,
					databasePassword);
			System.out.println("DB Connection Successfull");
		} catch (SQLException exc) {
			System.out.println("SQL statement Error");
			System.out.println(exc.getMessage());
		} finally {
			return connection;
		}
	}

}
