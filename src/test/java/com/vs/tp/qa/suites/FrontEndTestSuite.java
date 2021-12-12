package com.vs.tp.qa.suites;

import org.junit.platform.suite.api.*;

import com.vs.tp.qa.tests.*;

@Suite
@SuiteDisplayName("Front-end Tests Suite")
@SelectClasses(ErrorsTest.class)
@IncludeTags("fe")
public class FrontEndTestSuite {
    
}

