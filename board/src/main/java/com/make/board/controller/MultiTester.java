package com.make.board.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.make.board.dto.BoardDTO;
import com.make.board.service.BoardService;

import lombok.RequiredArgsConstructor;

// MultiTester //
@RequiredArgsConstructor
public class MultiTester {
	
	public static void main(String[] args) {
		//Test1();
	}
	
	// Test - DB Connection//
	private static void Test1() {
		try {
			String dbURL 		= "jdbc:mysql://localhost:3305/recipeconnection?serverTimezone=UTC";
			String dbID 		= "recipe";
			String dbPassword 	= "1q2w3e4r!";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			System.out.println(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
} // End - MultiTester
