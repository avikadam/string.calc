package com.capita.string.calc.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capita.string.calc.app.ops.AddOperationTest;
import com.capita.string.calc.app.ops.DivideOperationTest;
import com.capita.string.calc.app.ops.MultiplyOperationTest;
import com.capita.string.calc.app.ops.SubstractOperationTest;

@RunWith(Suite.class)
@SuiteClasses({ AddOperationTest.class, DivideOperationTest.class, MultiplyOperationTest.class,
		SubstractOperationTest.class })
public class OperationTestSuite {

}
