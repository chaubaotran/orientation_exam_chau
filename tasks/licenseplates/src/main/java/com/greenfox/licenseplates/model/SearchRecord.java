package com.greenfox.licenseplates.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "search_records")
public class SearchRecord {
	@Id
	@JsonIgnore
	private String id;
	
	private String date = sdf.format(new Date());
	@JsonInclude(value = Include.NON_NULL)
	private String query;
	
	@JsonInclude(value = Include.NON_NULL)
	private String brand;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");	
		
}
