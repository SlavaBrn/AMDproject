package com.vs.tp.qa.suites;

import org.junit.platform.suite.api.*;

import com.vs.tp.qa.tests.*;

@Suite
@SuiteDisplayName("E2E Tests Suite")
@SelectClasses(ErrorsTest.class)
@IncludeTags("e2e")
public class E2eTestSuite {
    
}
