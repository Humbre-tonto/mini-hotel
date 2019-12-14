package com.informatique.gov.helpdesk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "NOTIFICATION_SUBSCRIPTION")
@Data
@ToString(of = { "subscription"})
@EqualsAndHashCode(of = { "subscription" }, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class NotificationSubscription implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	@Id
	@Column(name = "SUBSCRIPTION")
	private String subscription;
}
