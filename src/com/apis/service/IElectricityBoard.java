package com.apis.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.apisero.dto.ElectricityBill;

public interface IElectricityBoard {

	List<ElectricityBill> generateBill(String filePath) throws FileNotFoundException;
	void addBill(List<ElectricityBill>billList) throws ClassNotFoundException, SQLException, IOException;
	
}
