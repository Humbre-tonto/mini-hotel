package com.hotel.minihotel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "ROOM")
@Data
@ToString(of = { "id" })
@EqualsAndHashCode(of = { "type" }, callSuper = false)


public class Room extends DomainEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Id
	@SequenceGenerator(name = "RoomSequence", sequenceName = "ROOM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoomSequence")
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID")
	private Type type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RESERVATION_ID")
	private Reservation reservation;
}
