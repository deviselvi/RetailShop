package com.retail.price.util;

public class DiscountCalculation {
	
	
	public static int getDiscountByDoller(long totalcost){
		
		int noOfDiscount=(int) (totalcost/100);
		int discountonbil=noOfDiscount*5;
		return discountonbil;
		
	}
	
	public static int getDiscountBypercentage(long price, String userType){
		int discount=0;
		if(userType.equalsIgnoreCase("Employee"))
			discount=(int) ((price*30)/100);
		else if (userType.equalsIgnoreCase("Affliated Employee")) {
			discount=(int) ((price*10)/100);			
		}else if (userType.equalsIgnoreCase("Previleged User")) {
			discount=(int) ((price*5)/100);
			
		}else
				discount=(int) ((price*5)/100);
				
		return discount;
		
	}
	

}
