package jp.co.dk.logger;

import org.apache.log4j.PropertyConfigurator;
import jp.co.dk.logger.exception.LoggerFatalException;

/**
 * LoggerFactoryは、指定のクラス名称、もしくは別名称を元にその名称に紐づくロギング設定でログインスタンスを生成するファクトリクラスです。<p/>
 * <br/>
 * このクラスに対して"getLogger"クラスを実行することで引数に指定されたクラス名称、もしくは別名称に紐づくロギング設定でログインスタンスを返却します。<br/>
 * 各種ログの設定はクラスパス上に存在する"Logger.properties"から読み込みます。<br/>
 * <br/>
 * このファイルが存在しない場合、LoggerInitExceptionが発生します。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class LoggerFactory {
	
	/** プロパティファイル */
	protected static final String propertiesFile = "Logger.properties";
	
	/**
	 * スタティックイニシャライザ<p/>
	 * クラスパスに存在するプロパティファイルを読み込みます。
	 */
	static {
		// readPropertyFile(LoggerFactory.propertiesFile);
		readPropertyFile(System.getProperty("logger_property_file"));
	}
	
	/**
	 * 指定のプロパティファイルを読み込みます。<p/>
	 * 指定のプロパティファイルが存在しない場合、例外が発生します。
	 * @param fileName プロパティファイル
	 * @throws LoggerFatalException 指定のプロパティファイルが存在しない場合
	 */
	protected static void readPropertyFile(String fileName) throws LoggerFatalException {
		if (fileName == null || fileName.equals("")) throw new LoggerFatalException("logger property file is not found. please set logger_property_file example=[-Dlogger_property_file=Logger.properties]");
		// URL fileURL = Thread.currentThread().getContextClassLoader().getResource(fileName);
		// if (fileURL == null) throw new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, fileName);
		// PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource(fileName));
		PropertyConfigurator.configure(fileName);
	}
	
	/**
	 * 指定のクラス名からロガーインスタンスを生成し、返却します。
	 * @param classObject クラスオブジェクト
	 * @return ロガーインスタンス
	 */
	public static Logger getLogger(Class<?> classObject) {
		return new Logger(com.spinn3r.log5j.Logger.getLogger(classObject));
	}
	
	/**
	 * 指定の名称からロガーインスタンスを生成し、返却します。
	 * @param name 名称
	 * @return ロガーインスタンス
	 */
	public static Logger getLogger(String name) {
		return new Logger(com.spinn3r.log5j.Logger.getLogger(name));
	}
	
}
