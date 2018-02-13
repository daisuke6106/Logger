package jp.co.dk.logger.exception;

/**
 * LoggerFatalExceptionは、ロガー処理にて致命的例外が発生したことを通知する例外クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class LoggerFatalException extends RuntimeException {
	
	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = -8632163223285950713L;

	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージで例外を生成します。
	 * 
	 * @param msg メッセージ本文
	 * @since 1.0
	 */
	public LoggerFatalException(String msg){
		super(msg);
	}

	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージ、例外で例外を生成します。
	 * 
	 * @param msg メッセージ本文
	 * @param throwable 例外インスタンス
	 * @since 1.0
	 */
	public LoggerFatalException(String msg, Throwable throwable){
		super(msg, throwable);
	}
}
