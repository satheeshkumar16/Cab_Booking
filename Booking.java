package zoho_app2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Booking {
	public static void bookCab(int customerId,char pickupPoint,char dropPoint,int pickupTime,List<Cab> freeCab) {
	int min=999;
	int distanceBWPickupAndDrop=0;
	int earning=0;
	int nextfreeTime=0;
	char nextSpot='Z';
	Cab bookedCab=null;
	String tripDetail="";
	for(Cab c:freeCab) {
	int distanceBWCustomerAndCab=Math.abs((c.currentSpot-'0')-(pickupPoint-'0'))*15;
	if(distanceBWCustomerAndCab<min) {
		bookedCab=c;
		distanceBWPickupAndDrop=Math.abs((dropPoint-'0')-(pickupPoint-'0'))*15;
		earning=(distanceBWPickupAndDrop-5)*10+100;
		int dropTime=pickupTime+distanceBWPickupAndDrop/15;
		nextfreeTime=dropTime;
		nextSpot=dropPoint;
		tripDetail=customerId+"  "+customerId+"   "+pickupPoint+"   "+dropPoint+"   "+pickupTime+"   "+dropTime+"   "+earning;
	}
	}
	bookedCab.setDetails(true, nextSpot, nextfreeTime,bookedCab.totalEarnings+earning, tripDetail);
	System.out.println("Cab "+bookedCab.id+ "booked");
	}
	public static List<Cab> createCab(int n) {
		List<Cab> cab=new ArrayList<Cab>();
		for(int i=1;i<=n;i++) {
			Cab c=new Cab();
			cab.add(c);
		}
		return cab;
	}
	public static List<Cab> getFreeCab(List<Cab> no_of_cab,int pickupTime,char pickupPoint) {
	List<Cab> freeCab=new ArrayList<Cab>();
	for(Cab c:no_of_cab) {
		if(c.freeTime<=pickupTime&&(Math.abs((c.currentSpot-'0')-(pickupPoint-'0'))<=pickupTime-c.freeTime)) {
			freeCab.add(c);
		}
	}
	return freeCab;
	}
public static void main(String[] args) {
	List<Cab> no_of_cabs=createCab(4);
	Scanner s=new Scanner(System.in);
	int id=1;
	while(true) {
		System.out.println("0-> Book Cab");
		System.out.println("1-> Print Cab details");
		int choice=s.nextInt();
		switch(choice) {
		case 0:{
			int customer_id=id;
			System.out.println("enter pickup point");
			char pickupPoint=s.next().charAt(0);
			System.out.println("enter dropPoint");
			char dropPoint=s.next().charAt(0);
		System.out.println("enter pickupTime");
		int pickupTime=s.nextInt();
		if(pickupPoint<'A'||dropPoint>'F'||pickupPoint>'F'||dropPoint<'A')	{
			System.out.println("valid pickup and drop are A,B,C,D,E,F./nExit");
			return;
		}
		List<Cab> freeCab=getFreeCab(no_of_cabs,pickupTime,pickupPoint);
		if(freeCab.size()==0) {
			System.out.println("No cab available !Sorry!");
		}
		Collections.sort(freeCab,(a,b)->a.totalEarnings-b.totalEarnings);
		bookCab(id,pickupPoint,dropPoint,pickupTime,freeCab);
		id++;
		break;
			}
		case 1:{
			for(Cab c:no_of_cabs) {
				c.printCabDetails();
			}
			for(Cab c:no_of_cabs) {
				c.printDetails();
			}
			break;
			}
		default:return;
		}
		}
	}
}

