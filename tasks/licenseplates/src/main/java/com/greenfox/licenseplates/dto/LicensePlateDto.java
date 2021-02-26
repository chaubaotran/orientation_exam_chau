package com.greenfox.licenseplates.dto;

import java.util.List;

import com.greenfox.licenseplates.model.LicensePlate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LicensePlateDto {
	
	private String result;
	private List<LicensePlate> data;

}
