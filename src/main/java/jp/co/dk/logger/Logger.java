package jp.co.dk.logger;

/**
 * Loggerは、ログ出力を行う際に使用するロガークラスです。<p/>
 * <br/>
 * 各種ログレベルは以下の通りです。<br/>
 * [fatal]・・・システムがこれ以上動作できない致命的なエラーが発生した場合<br/>
 * [error]・・・予期せぬ動作などにより、正しく処理できない場合<br/>
 * [warn ]・・・なんらかの問題が発生したが、動作には影響がない場合<br/>
 * [info ]・・・設定ファイルを読み込んだときの設定情報、システム開始／停止時の状態出力など<br/>
 * [debug]・・・デバッグ情報。例えば、外部モジュールから呼ばれるメソッドの入出力情報など<br/>
 * [trace]・・・詳細なデバッグ情報。モジュール内部の情報、ループの繰り返しで大量に出力される情報など<br/>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class Logger {
	
	/** Log4jロガーインスタンス */ 
	protected org.apache.log4j.Logger logger ;
	
	/** 改行コード */
	protected static final String lineSeparator = System.getProperty("line.separator");
	
	/**
	 * コンストラクタ<p/>
	 * 指定のLog4jロガーインスタンスを元にロガーインスタンスを生成します。
	 * 
	 * @param logger Log4jロガーインスタンス
	 */
	Logger(org.apache.log4j.Logger logger){
		this.logger = logger;
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （システムがこれ以上動作できない致命的なエラーが発生した場合）
	 * @param messege 出力内容
	 */
	public void fatal(Object messege) {
		this.logger.fatal(messege);
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （システムがこれ以上動作できない致命的なエラーが発生した場合）
	 * @param messege 出力内容
	 */
	public void fatal(Loggable messege) {
		this.logger.fatal(messege.printLog(lineSeparator));
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （予期せぬ動作などにより、正しく処理できない場合）
	 * @param messege 出力内容
	 */
	public void error(Object messege) {
		this.logger.error(messege);
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （予期せぬ動作などにより、正しく処理できない場合）
	 * @param messege 出力内容
	 */
	public void error(Loggable messege) {
		this.logger.error(messege.printLog(lineSeparator));
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （なんらかの問題が発生したが、動作には影響がない場合）
	 * @param messege 出力内容
	 */
	public void warn(Object messege) {
		this.logger.warn(messege);
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （なんらかの問題が発生したが、動作には影響がない場合）
	 * @param messege 出力内容
	 */
	public void warn(Loggable messege) {
		this.logger.warn(messege.printLog(lineSeparator));
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （設定ファイルを読み込んだときの設定情報、システム開始／停止時の状態出力など）
	 * @param messege 出力内容
	 */
	public void info(Object messege) {
		this.logger.info(messege);
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （設定ファイルを読み込んだときの設定情報、システム開始／停止時の状態出力など）
	 * @param messege 出力内容
	 */
	public void info(Loggable messege) {
		this.logger.info(messege.printLog(lineSeparator));
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （デバッグ情報。例えば、外部モジュールから呼ばれるメソッドの入出力情報など）
	 * @param messege 出力内容
	 */
	public void debug(Object messege) {
		this.logger.debug(messege);
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （デバッグ情報。例えば、外部モジュールから呼ばれるメソッドの入出力情報など）
	 * @param messege 出力内容
	 */
	public void debug(Loggable messege) {
		this.logger.debug(messege.printLog(lineSeparator));
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （詳細なデバッグ情報。モジュール内部の情報、ループの繰り返しで大量に出力される情報など）
	 * @param messege 出力内容
	 */
	public void trace(Object messege) {
		this.logger.trace(messege);
	}
	
	/**
	 * ログに指定の出力内容を出力します。
	 * （詳細なデバッグ情報。モジュール内部の情報、ループの繰り返しで大量に出力される情報など）
	 * @param messege 出力内容
	 */
	public void trace(Loggable messege) {
		this.logger.trace(messege.printLog(lineSeparator));
	}
	
	/**
	 * コンストラクタ実行時にログに出力します。<br/>
	 * コンストラクタ実行時にログにその旨を記述します。その際のログレベルは[info]です。
	 * 
	 * @param classInstance コンストラクタを実行したクラス
	 */
	public void constractor(Class<?> classInstance) {
		this.logger.info("Create instance class=[" + classInstance.getName() + "] param=[nothing]");
	}
	
	/**
	 * コンストラクタ実行時にログに出力します。<br/>
	 * コンストラクタ実行時にログにその旨をパラメータとともに記述します。その際のログレベルは[info]です。
	 * 
	 * @param classInstance コンストラクタを実行したクラス
	 * @param parameters コンストラクタに渡されたパラメータ一覧
	 */
	public void constractor(Class<?> classInstance, Object... parameters) {
		StringBuilder paramStr = new StringBuilder();
		for (Object parameter : parameters) {
			if (parameter != null) {
				paramStr.append(parameter.toString()).append(',');
			} else {
				paramStr.append("null").append(',');
			}
		}
		this.logger.info("Create instance class=[" + classInstance.getName() + "] param=[" + paramStr.substring(0, paramStr.length() -1 ) + "]");
	}
}


