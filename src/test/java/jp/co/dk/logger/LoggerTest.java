package jp.co.dk.logger;

import jp.co.dk.logger.exception.LoggerInitException;

import org.junit.Test;

public class LoggerTest extends LoggerFoundationTest{
	
	@Test
	public void constractor() {
		// 実在するプロパティファイルを引数にコンストラクタを呼び出した場合、
		// 正常にインスタンスが生成できること。
		Logger sut = LoggerFactory.getLogger("OPERATION");
		assertThat(sut.logger, notNullValue());
		assertThat(sut.lineSeparator, is(System.getProperty("line.separator")));
	}
	
	@Test
	public void fatal() {
		// fatalメソッドに対してオブジェクトが設定された場合、ロガーのfatalメソッドに対して値が設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			sut.fatal("test");
			assertThat(((DummyLoger)sut.logger).fatal.toString(), is("test"));
		} catch (LoggerInitException e) {
			 fail(e);
		}
		
		// fatalメソッドに対してLoggableを実装したオブジェクトが設定された場合、
		// ロガーのfatalメソッドに対してprintlogにて生成した値が設定されていること。
		// printlogメソッドに対して改行コードが設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			DummyLoggable dummyLoggable = new DummyLoggable();
			sut.fatal(dummyLoggable);
			assertThat(((DummyLoger)sut.logger).fatal.toString(), is("printlog"));
			assertThat(dummyLoggable.lineSeparator, is(sut.lineSeparator));
		} catch (LoggerInitException e) {
			 fail(e);
		}
	}
	
	@Test
	public void error() {
		// errorメソッドに対してオブジェクトが設定された場合、ロガーのfatalメソッドに対して値が設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			sut.error("test");
			assertThat(((DummyLoger)sut.logger).error.toString(), is("test"));
		} catch (LoggerInitException e) {
			 fail(e);
		}
		
		// errorメソッドに対してLoggableを実装したオブジェクトが設定された場合、
		// ロガーのerrorメソッドに対してprintlogにて生成した値が設定されていること。
		// printlogメソッドに対して改行コードが設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			DummyLoggable dummyLoggable = new DummyLoggable();
			sut.error(dummyLoggable);
			assertThat(((DummyLoger)sut.logger).error.toString(), is("printlog"));
			assertThat(dummyLoggable.lineSeparator, is(sut.lineSeparator));
		} catch (LoggerInitException e) {
			 fail(e);
		}
	}
	
	@Test
	public void warn() {
		// warnメソッドに対してオブジェクトが設定された場合、ロガーのfatalメソッドに対して値が設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			sut.warn("test");
			assertThat(((DummyLoger)sut.logger).warn.toString(), is("test"));
		} catch (LoggerInitException e) {
			 fail(e);
		}
		
		// warnメソッドに対してLoggableを実装したオブジェクトが設定された場合、
		// ロガーのwarnメソッドに対してprintlogにて生成した値が設定されていること。
		// printlogメソッドに対して改行コードが設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			DummyLoggable dummyLoggable = new DummyLoggable();
			sut.warn(dummyLoggable);
			assertThat(((DummyLoger)sut.logger).warn.toString(), is("printlog"));
			assertThat(dummyLoggable.lineSeparator, is(sut.lineSeparator));
		} catch (LoggerInitException e) {
			 fail(e);
		}
	}
	
	@Test
	public void info() {
		// infoメソッドに対してオブジェクトが設定された場合、ロガーのfatalメソッドに対して値が設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			sut.info("test");
			assertThat(((DummyLoger)sut.logger).info.toString(), is("test"));
		} catch (LoggerInitException e) {
			 fail(e);
		}
		
		// infoメソッドに対してLoggableを実装したオブジェクトが設定された場合、
		// ロガーのinfoメソッドに対してprintlogにて生成した値が設定されていること。
		// printlogメソッドに対して改行コードが設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			DummyLoggable dummyLoggable = new DummyLoggable();
			sut.info(dummyLoggable);
			assertThat(((DummyLoger)sut.logger).info.toString(), is("printlog"));
			assertThat(dummyLoggable.lineSeparator, is(sut.lineSeparator));
		} catch (LoggerInitException e) {
			 fail(e);
		}
	}
	
	@Test
	public void debug() {
		// debugメソッドに対してオブジェクトが設定された場合、ロガーのfatalメソッドに対して値が設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			sut.debug("test");
			assertThat(((DummyLoger)sut.logger).debug.toString(), is("test"));
		} catch (LoggerInitException e) {
			 fail(e);
		}
		
		// debugメソッドに対してLoggableを実装したオブジェクトが設定された場合、
		// ロガーのdebugメソッドに対してprintlogにて生成した値が設定されていること。
		// printlogメソッドに対して改行コードが設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			DummyLoggable dummyLoggable = new DummyLoggable();
			sut.debug(dummyLoggable);
			assertThat(((DummyLoger)sut.logger).debug.toString(), is("printlog"));
			assertThat(dummyLoggable.lineSeparator, is(sut.lineSeparator));
		} catch (LoggerInitException e) {
			 fail(e);
		}
	}
	
	@Test
	public void trace() {
		// traceメソッドに対してオブジェクトが設定された場合、ロガーのfatalメソッドに対して値が設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			sut.trace("test");
			assertThat(((DummyLoger)sut.logger).trace.toString(), is("test"));
		} catch (LoggerInitException e) {
			 fail(e);
		}
		
		// traceメソッドに対してLoggableを実装したオブジェクトが設定された場合、
		// ロガーのtraceメソッドに対してprintlogにて生成した値が設定されていること。
		// printlogメソッドに対して改行コードが設定されていること。
		try {
			Logger sut = LoggerFactory.getLogger(this.getClass());
			sut.logger = new DummyLoger("bummy");
			DummyLoggable dummyLoggable = new DummyLoggable();
			sut.trace(dummyLoggable);
			assertThat(((DummyLoger)sut.logger).trace.toString(), is("printlog"));
			assertThat(dummyLoggable.lineSeparator, is(sut.lineSeparator));
		} catch (LoggerInitException e) {
			 fail(e);
		}
	}

}


class DummyLoger extends org.apache.log4j.Logger {
	
	protected Object fatal;
	
	protected Object error;
	
	protected Object warn;
	
	protected Object info;
	
	protected Object debug;
	
	protected Object trace;
	
	protected DummyLoger(String name) {
		super(name);
	}
	
	@Override
	public void fatal(Object messege) {
		this.fatal = messege;
	}
	
	@Override
	public void error(Object messege) {
		this.error = messege;
	}
	
	@Override
	public void warn(Object messege) {
		this.warn = messege;
	}
	
	@Override
	public void info(Object messege) {
		this.info = messege;
	}
	
	@Override
	public void debug(Object messege) {
		this.debug = messege;
	}
	
	@Override
	public void trace(Object messege) {
		this.trace = messege;
	}
	
}

class DummyLoggable implements Loggable {
	
	protected String lineSeparator;
	
	@Override
	public String printLog(String lineSeparator) {
		this.lineSeparator = lineSeparator;
		return "printlog";
	}
	
	@Override
	public String toString() {
		return "tostring";
	}
	
}