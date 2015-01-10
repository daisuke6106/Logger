package jp.co.dk.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import jp.co.dk.logger.exception.LoggerInitException;
import jp.co.dk.message.MessageInterface;
import jp.co.dk.message.exception.AbstractMessageFatalException;
import jp.co.dk.test.template.TestCaseTemplate;

public class LoggerFoundationTest extends TestCaseTemplate{
	
	static isError error(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj) {
		return new isError(targetClass, messegeObj);
	}
	
	static isError isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj, String str) {
		return new isError(targetClass, messegeObj, str);
	}
	
	static isError isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj, String[] str) {
		return new isError(targetClass, messegeObj, str);
	}
	
	static isError isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj, List<String> str) {
		return new isError(targetClass, messegeObj, str);
	}
	
	
}

class isError extends BaseMatcher<AbstractMessageFatalException> {
	
	protected Class<? extends AbstractMessageFatalException> targetClass;
	
	protected MessageInterface messegeObj;
	
	protected List<String> embeddedStrList = new ArrayList<String>();
	
	protected Object actual;
	
	isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj) {
		this.targetClass = targetClass;
		this.messegeObj  = messegeObj;
	}
	
	isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj, String str) {
		this.targetClass = targetClass;
		this.messegeObj  = messegeObj;
		this.embeddedStrList.add(str);
	}
	
	isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj, String[] str) {
		this.targetClass = targetClass;
		this.messegeObj  = messegeObj;
		this.embeddedStrList = Arrays.asList(str);
	}
	
	isError(Class<? extends AbstractMessageFatalException> targetClass, MessageInterface messegeObj, List<String> str) {
		this.targetClass = targetClass;
		this.messegeObj  = messegeObj;
		this.embeddedStrList = str;
	}
	
	@Override
	public boolean matches(Object actual) {
		this.actual = actual;
		if (this.actual == null) return false; 
		if (!(this.actual.getClass().getCanonicalName().equals(this.targetClass.getCanonicalName()))) return false;
		AbstractMessageFatalException exception=(AbstractMessageFatalException)this.actual;
		if (!(this.messegeObj == exception.getMessageObj())) return false;
		if (!(this.embeddedStrList.equals(exception.getEmbeddedStrList()))) return false;
		return true;
	}

	@Override
	public void describeTo(Description desc) {
		if (this.actual == null) {
			desc.appendValue(this.targetClass.getCanonicalName());
			desc.appendText(" but actual is null.");
			return;
		}
		if (!(this.actual.getClass().getCanonicalName().equals(this.targetClass.getCanonicalName()))) {
			desc.appendValue(this.targetClass.getCanonicalName());
			desc.appendText(" but actual class is ");
			desc.appendValue(this.actual.getClass().getCanonicalName());
			return;
		}
		AbstractMessageFatalException exception=(AbstractMessageFatalException)this.actual;
		if (!(this.messegeObj == exception.getMessageObj())) {
			desc.appendValue(this.messegeObj.toString());
			desc.appendText("actual messege object is ");
			desc.appendValue(exception.getMessageObj().toString());
			return;
		}
		if (!(this.embeddedStrList.equals(exception.getEmbeddedStrList()))) {
			desc.appendValue(this.embeddedStrList.toString());
			desc.appendText("actual Embedded Strings is");
			desc.appendValue(exception.getEmbeddedStrList().toString());
			return;
		}
	}
	
}