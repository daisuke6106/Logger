package jp.co.dk.logger;

/**
 * Loggableは、ログに出力される内容をカスタマイズしたい場合に実装するインターフェースです。<p/>
 * 
 * @version 1.0
 * @author D.Kanno
 */
public interface Loggable {
	
	/**
	 * ログ出力内容を返却します。
	 * 
	 * @param lineSeparator 改行コード
	 * @return ログ出力内容文字列
	 */
	public String printLog(String lineSeparator);
	
}
