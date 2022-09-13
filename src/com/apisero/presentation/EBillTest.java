package com.apisero.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.apis.service.ElectricityBoard;
import com.apis.service.IElectricityBoard;
import com.apisero.dto.ElectricityBill;


public class EBillTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		IElectricityBoard obj=new ElectricityBoard();
		String filePath="C:\\Users\\KavitaJRana\\eclipse-workspace\\EBillGenerate\\ElectricityBill.txt";
		List<ElectricityBill> eBills=new ArrayList<>();
		eBills=obj.generateBill(filePath);
		System.out.println("List having bill amount :");
		System.out.println(eBills);
		obj.addBill(eBills);
		
		
	}

}
