package com.greenfox.licenseplates.dto;

import java.util.List;

import com.greenfox.licenseplates.model.SearchRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchRecordDto {
	private String result;
	private List<SearchRecord> data;

}
