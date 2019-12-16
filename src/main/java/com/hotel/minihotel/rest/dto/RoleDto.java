package com.hotel.minihotel.rest.dto;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = {"id", "code", "arabicName", "englishName"})
@EqualsAndHashCode(of = {"code", "arabicName", "englishName"}, callSuper = false)
public class RoleDto implements UserModel<Byte> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private Byte id;
	private String code;
	private String englishName;
	private String arabicName;
	
}
