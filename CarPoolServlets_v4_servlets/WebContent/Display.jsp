<%@page import="com.car.pojo.RidePojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.car.businesslogic.BusinessLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Rides</title>
</head>
<body>
<table>
<tr><td>Ride ID</td><td>Car name</td><td>Source</td><td>Destination</td><td>Distance</td><td>Seats Available</td><td>Seats Total</td><td>Cost per km</td></tr>
<% 
BusinessLogic bl=new BusinessLogic();
ArrayList<RidePojo> rideList=new ArrayList<RidePojo>();
rideList=bl.displayRide();
for(RidePojo ride:rideList)
{
	int rid=ride.getrId();
	String car=ride.getCarName();
	String src=ride.getPickUpPoint();
	String dest=ride.getDestination();
	int dist=ride.getDistance();
	int seatsavail=ride.getSeatsAvailable();
	int seatstot=ride.getTotalSeats();
	int cost=ride.getCostPerKm();
	%>
	<tr><td><%=rid %></td><td><%=car %></td><td><%=src %></td><td><%=dest %></td><td><%=dist %></td><td><%=seatsavail %></td><td><%=seatstot %></td><td><%=cost %></td></tr>

<% } %>

</table>
</body>
</html>