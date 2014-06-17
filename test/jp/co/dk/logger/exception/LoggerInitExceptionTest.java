package jp.co.dk.logger.exception;

import java.util.ArrayList;
import java.util.List;

import jp.co.dk.logger.LoggerFoundationTest;
import jp.co.dk.message.MessageInterface;
import jp.co.dk.test.template.TestCaseTemplate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static jp.co.dk.logger.messege.LoggerMessege.*;

public class LoggerInitExceptionTest extends LoggerFoundationTest {

	@Test
	public void constractor() {
		
		// メッセージオブジェクトのみ指定して実行した場合
		// 埋め込み文字列、throwクラスは取得できないこと
		LoggerInitException sut1 = new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND);
		assertThat(sut1.getMessageObj(), is((MessageInterface)PROPERTIES_FILE_CAN_NOT_BE_FOUND));
		assertThat(sut1.getEmbeddedStrList().size(), is(0));
		assertThat(sut1.getThrowable(), nullValue());
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスは取得できないこと
		LoggerInitException sut2 = new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, "test");
		assertThat(sut2.getMessageObj(), is((MessageInterface)PROPERTIES_FILE_CAN_NOT_BE_FOUND));
		assertThat(sut2.getEmbeddedStrList().size(), is(1));
		assertThat(sut2.getEmbeddedStrList().get(0), is("test"));
		assertThat(sut2.getThrowable(), nullValue());
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 埋め込み文字列が取得できないこと
		// throwクラスは取得できること
		LoggerInitException sut3 = new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, new NullPointerException());
		assertThat(sut3.getMessageObj(), is((MessageInterface)PROPERTIES_FILE_CAN_NOT_BE_FOUND));
		assertThat(sut3.getEmbeddedStrList().size(), is(0));
		assertThat(sut3.getThrowable(), instanceOf(NullPointerException.class));
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスが取得できること
		LoggerInitException sut4 = new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, "test", new NullPointerException());
		assertThat(sut4.getMessageObj(), is((MessageInterface)PROPERTIES_FILE_CAN_NOT_BE_FOUND));
		assertThat(sut4.getEmbeddedStrList().size(), is(1));
		assertThat(sut4.getEmbeddedStrList().get(0), is("test"));
		assertThat(sut4.getThrowable(), instanceOf(NullPointerException.class));
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスが取得できること
		List<String> strList = new ArrayList<String>();
		strList.add("test");
		LoggerInitException sut5 = new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, strList, new NullPointerException());
		assertThat(sut5.getMessageObj(), is((MessageInterface)PROPERTIES_FILE_CAN_NOT_BE_FOUND));
		assertThat(sut5.getEmbeddedStrList().size(), is(1));
		assertThat(sut5.getEmbeddedStrList().get(0), is("test"));
		assertThat(sut5.getThrowable(), instanceOf(NullPointerException.class));
		
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスが取得できること
		String[] strArray = {"test"};
		LoggerInitException sut6 = new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, strArray, new NullPointerException());
		assertThat(sut6.getMessageObj(), is((MessageInterface)PROPERTIES_FILE_CAN_NOT_BE_FOUND));
		assertThat(sut6.getEmbeddedStrList().size(), is(1));
		assertThat(sut6.getEmbeddedStrList().get(0), is("test"));
		assertThat(sut6.getThrowable(), instanceOf(NullPointerException.class));
	}
	
}
