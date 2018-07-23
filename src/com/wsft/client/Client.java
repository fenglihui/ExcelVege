package com.wsft.client;

import java.io.IOException;
import java.sql.SQLException;

import com.wsft.excel.SaveData2DB;

public class Client {
	public static void main(String[] args) throws IOException, SQLException {
		SaveData2DB saveData2DB = new SaveData2DB();
		saveData2DB.save();
		System.out.println("end");
	}
}
