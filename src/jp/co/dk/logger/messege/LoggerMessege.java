package jp.co.dk.logger.messege;

import java.io.Serializable;

import jp.co.dk.message.AbstractMessage;

/**
 * LoggerMessegeは、ロガーの操作にて使用するメッセージを定義する定数クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class LoggerMessege extends AbstractMessage implements Serializable{
	
	/** シリアルバージョンID */
	private static final long serialVersionUID = -4598667208776216761L;
	
	/** ロガープロパティファイルが見つかりません。properties=[{0}] */
	public static final LoggerMessege PROPERTIES_FILE_CAN_NOT_BE_FOUND = new LoggerMessege("E001");
	
	protected LoggerMessege(String messageId) {
		super(messageId);
	}

}
