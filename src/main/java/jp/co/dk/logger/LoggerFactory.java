package jp.co.dk.logger;

import static jp.co.dk.logger.messege.LoggerMessege.*;

import java.io.File;

import jp.co.dk.logger.exception.LoggerInitException;

import org.apache.log4j.PropertyConfigurator;

/**
 * LoggerFactoryは、指定のクラス名称、もしくは別名称を元にその名称に紐づくロギング設定でログインスタンスを生成するファクトリクラスです。<p/>
 * <br/>
 * このクラスに対して"getLogger"クラスを実行することで引数に指定されたクラス名称、もしくは別名称に紐づくロギング設定でログインスタンスを返却します。<br/>
 * 各種ログの設定はクラスパス上に存在する"properties/Logger.properties"から読み込みます。<br/>
 * <br/>
 * このファイルが存在しない場合、LoggerInitExceptionが発生します。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class LoggerFactory {
	
	/** プロパティファイル */
	protected static final String propertiesFile = "properties/Logger.properties";
	
	/**
	 * スタティックイニシャライザ<p/>
	 * クラスパスに存在するプロパティファイルを読み込みます。
	 */
	static {
		readPropertyFile(LoggerFactory.propertiesFile);
	}
	
	/**
	 * 指定のプロパティファイルを読み込みます。<p/>
	 * 指定のプロパティファイルが存在しない場合、例外が発生します。
	 * @param fileName プロパティファイル
	 * @throws LoggerInitException 指定のプロパティファイルが存在しない場合
	 */
	protected static void readPropertyFile(String fileName) throws LoggerInitException {
		if (fileName == null) throw new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, "null");
		File propertiesFileObj = new File(fileName); 
		if (!propertiesFileObj.exists()) throw new LoggerInitException(PROPERTIES_FILE_CAN_NOT_BE_FOUND, fileName);
		PropertyConfigurator.configure(fileName);
	}
	
	/**
	 * 指定のクラス名からロガーインスタンスを生成し、返却します。
	 * @param classObject クラスオブジェクト
	 * @return ロガーインスタンス
	 */
	public static Logger getLogger(Class<?> classObject) {
		return new Logger(org.apache.log4j.Logger.getLogger(classObject));
	}
	
	/**
	 * 指定の名称からロガーインスタンスを生成し、返却します。
	 * @param name 名称
	 * @return ロガーインスタンス
	 */
	public static Logger getLogger(String name) {
		return new Logger(org.apache.log4j.Logger.getLogger(name));
	}
	
}
