package jp.co.dk.logger;

import jp.co.dk.logger.exception.LoggerFatalExceptionTest;
import jp.co.dk.logger.exception.LoggerInitExceptionTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	LoggerFactoryTest.class,
//	LoggerTest.class,
	
	LoggerInitExceptionTest.class,
	LoggerFatalExceptionTest.class,
})
public class AllTest {}