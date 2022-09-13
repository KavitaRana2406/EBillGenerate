package com.apis.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.apisero.dao.DBHandler;
import com.apisero.dto.ElectricityBill;
import com.apisero.exception.InvalidConsumerNum;


public class ElectricityBoard implements IElectricityBoard{
	
	
	public List<ElectricityBill> generateBill(String filePath) throws FileNotFoundException{
		List<ElectricityBill> bills=new ArrayList<>();
		File file = new File(filePath);
		try (Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				String[] temp=sc.nextLine().split(",");
				ElectricityBill obj=new ElectricityBill();
				obj.setConsumerNumber(temp[0].toString());
				boolean choice=validate(obj.getConsumerNumber());
				if(choice)
				{
					obj.setConsumerName(temp[1]);
					obj.setConsumerAddress(temp[2]);
					obj.setUnitsConsumed(Integer.parseInt(temp[3]));
					obj.setBillAmount(0);
					obj.calculateBillAmount(obj);
					bills.add(obj);
				}
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bills;
		
	}
	
	boolean validate(String consumerNumber) {
		try{
			if(consumerNumber.startsWith("0")&&consumerNumber.length()==10)
				return true;
			else 
				throw new InvalidConsumerNum(consumerNumber);
		}
		catch(InvalidConsumerNum e)
		{
			return false;
		}	
	}
	
	public void addBill(List<ElectricityBill>billList) throws ClassNotFoundException, SQLException, IOException {

		final String query="insert into ElectricityBill(consumerNumber,name,address,units_consumed,bill_amount) "+"values(?,?,?,?,?)";
		Connection con=DBHandler.establishConnection();
		PreparedStatement pst =con.prepareStatement(query);
		for(ElectricityBill itr:billList) {
			pst.setString(1,itr.getConsumerNumber());
			pst.setString(2,itr.getConsumerName());
			pst.setString(3,itr.getConsumerAddress());
			pst.setInt(4,itr.getUnitsConsumed());
			pst.setDouble(5,itr.getBillAmount());
			pst.executeUpdate();
		}
		
		System.out.println("\nTable Data Below :");
		ResultSet rs=pst.executeQuery("select * from ElectricityBill")	;
		while(rs.next())
		{
			System.out.println("Electricity Bill Detail : "+rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+" ,"+rs.getInt(4)+", "+rs.getDouble(5));
		}
	}
}
