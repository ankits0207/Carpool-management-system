package com.car.pojo;

import java.io.Serializable;

public class RidePojo implements Serializable{
	 
	private int rId, distance, seatsAvailable, totalSeats, costPerKm;
	private String destination, carName, pickUpPoint, date;
	private String ac;
	public RidePojo(int rId, int distance, int totalSeats,
			int costPerKm, String destination, String carName,
			String pickUpPoint, String date, String ac) {
		super();
		this.rId = rId;
		this.distance = distance;
		this.totalSeats = totalSeats;
		this.costPerKm = costPerKm;
		this.destination = destination;
		this.carName = carName;
		this.pickUpPoint = pickUpPoint;
		this.date = date;
		this.ac = ac;
	}
	
	
	
	@Override
	public String toString() {
		return "RidePojo [rId=" + rId + ", distance=" + distance
				+ ", seatsAvailable=" + seatsAvailable + ", totalSeats="
				+ totalSeats + ", costPerKm=" + costPerKm + ", destination="
				+ destination + ", carName=" + carName + ", pickUpPoint="
				+ pickUpPoint + ", date=" + date + ", ac=" + ac + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ac == null) ? 0 : ac.hashCode());
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		result = prime * result + costPerKm;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + distance;
		result = prime * result
				+ ((pickUpPoint == null) ? 0 : pickUpPoint.hashCode());
		result = prime * result + rId;
		result = prime * result + seatsAvailable;
		result = prime * result + totalSeats;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RidePojo other = (RidePojo) obj;
		if (ac == null) {
			if (other.ac != null)
				return false;
		} else if (!ac.equals(other.ac))
			return false;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		if (costPerKm != other.costPerKm)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (distance != other.distance)
			return false;
		if (pickUpPoint == null) {
			if (other.pickUpPoint != null)
				return false;
		} else if (!pickUpPoint.equals(other.pickUpPoint))
			return false;
		if (rId != other.rId)
			return false;
		if (seatsAvailable != other.seatsAvailable)
			return false;
		if (totalSeats != other.totalSeats)
			return false;
		return true;
	}

	public RidePojo() {
		// TODO Auto-generated constructor stub
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getCostPerKm() {
		return costPerKm;
	}
	public void setCostPerKm(int costPerKm) {
		this.costPerKm = costPerKm;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getPickUpPoint() {
		return pickUpPoint;
	}
	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String isAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	
	
}
