package com.hotel.minihotel.rest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id", "code" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class TypeDto implements UserModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	private Integer id;
	private String code;

}
