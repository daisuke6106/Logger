package jp.co.dk.logger;

import jp.co.dk.logger.exception.LoggerInitException;

import org.junit.Test;

public class LoggerFactoryTest extends LoggerFoundationTest{
	
	@Test
	public void readPropertyFile() {
		// 存在するプロパティファイルを指定した場合、例外が発生しないこと
		try {
			LoggerFactory.readPropertyFile(LoggerFactory.propertiesFile);
		} catch (LoggerInitException e) {
			fail(e);
		}
		// nullを指定した場合、例外が発生すること
		try {
			LoggerFactory.readPropertyFile(null);
			fail();
		} catch (LoggerInitException e) {
			assertThat(e, isError(LoggerInitException.class, jp.co.dk.logger.messege.LoggerMessege.PROPERTIES_FILE_CAN_NOT_BE_FOUND, "null"));
		}
		// 空文字を指定した場合、例外が発生すること
		try {
			LoggerFactory.readPropertyFile("");
			fail();
		} catch (LoggerInitException e) {
			assertThat(e, isError(LoggerInitException.class, jp.co.dk.logger.messege.LoggerMessege.PROPERTIES_FILE_CAN_NOT_BE_FOUND, ""));
		}
		// 存在しないプロパティファイルを指定した場合、例外が発生すること
		try {
			LoggerFactory.readPropertyFile("properties/Nothing.properties");
			fail();
		} catch (LoggerInitException e) {
			assertThat(e, isError(LoggerInitException.class, jp.co.dk.logger.messege.LoggerMessege.PROPERTIES_FILE_CAN_NOT_BE_FOUND, "properties/Nothing.properties"));
		}
	}
	
	@Test
	public void getLog() {
		// 指定のクラスオブジェクトを元にログインスタンスが取得できること
		Logger logger1 = LoggerFactory.getLogger(this.getClass());
		assertThat(logger1, notNullValue());
		assertThat(logger1.getClass().getCanonicalName(), is(Logger.class.getCanonicalName()));
		
		// 指定の名前を元にログインスタンスが取得できること
		Logger logger2 = LoggerFactory.getLogger("OPERATOR");
		assertThat(logger2, notNullValue());
		assertThat(logger2.getClass().getCanonicalName(), is(Logger.class.getCanonicalName()));
		
	}

}
