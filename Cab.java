package zoho_app2;

import java.util.ArrayList;
import java.util.List;

public class Cab {
static int cabcount=0;
int id;
boolean booked;
char currentSpot;
int freeTime;
int totalEarnings;
List<String> trips;

public Cab() {
	booked=false;
	currentSpot='A';
	freeTime=6;
	totalEarnings=0;
	trips=new ArrayList<String>();
	cabcount=cabcount+1;
	id=cabcount;
}
public void setDetails(boolean booked,char currentSpot,int freeTime,int totalEarnings,String tripDetails) {
	this.booked=booked;
	this.currentSpot=currentSpot;
	this.freeTime=freeTime;
	this.totalEarnings=totalEarnings;
	this.trips.add(tripDetails);
}
public void printDetails() {
	System.out.println("Cab -"+this.id+"TotalEarnings-"+this.totalEarnings);
	System.out.println("CabId BookingId customerId from To pickupTime DropTime Amount");
	for(String trip:trips) {
		System.out.println(id+"......."+trip);
	}
	System.out.println("-----------------------------------");
}
public void printCabDetails() {
	System.out.println("Cab -"+this.id+" TotalEarnings-"+this.totalEarnings+" CurrentSpot-"+this.currentSpot+" FreeTime- "+this.freeTime);;
}
}
