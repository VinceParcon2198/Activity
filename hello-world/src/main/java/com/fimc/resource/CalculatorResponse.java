package com.fimc.resource;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalculatorResponse implements Serializable {
	private String operator;
	private BigDecimal result;

}