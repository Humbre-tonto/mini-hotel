package com.hotel.minihotel.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "RESERVATION")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "room" }, callSuper = false)


public class Reservation extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Id
	@SequenceGenerator(name = "ReservationSequence", sequenceName = "RESERVATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReservationSequence")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Column(name = "DURATION")
	private Integer duration;
	  
	  
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROOM_ID")
	private Room room;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	private User customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CREATOR_ID")
	private User creator;
}
