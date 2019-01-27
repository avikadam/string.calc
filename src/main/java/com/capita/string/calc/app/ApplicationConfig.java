package com.capita.string.calc.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capita.string.calc.app.ops.AddOperation;
import com.capita.string.calc.app.ops.DivideOperation;
import com.capita.string.calc.app.ops.MultiplyOperation;
import com.capita.string.calc.app.ops.Operation;
import com.capita.string.calc.app.ops.SubstractOperation;

@Configuration
public class ApplicationConfig {

	@Bean("operationMap")
	Map<String, Operation<Integer, Integer, Integer>> operationMap(){
		Map<String, Operation<Integer, Integer, Integer>> operationMap = new HashMap<>();
		operationMap.put("+", new AddOperation());
		operationMap.put("-", new SubstractOperation());
		operationMap.put("*", new MultiplyOperation());
		operationMap.put("/", new DivideOperation());
		return operationMap;
	}
}
