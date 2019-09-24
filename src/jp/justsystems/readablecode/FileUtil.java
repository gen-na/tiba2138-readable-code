package jp.justsystems.readablecode;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * ファイル操作のユーティリティクラス
 *
 */
public class FileUtil {



	/**
	 * ファイルの存在確認
	 * 
	 * @param filePath
	 * @return true;存在、false:存在しない
	 * @throws FileNotFoundException
	 */
	static boolean exists(String filePath) {
		if (isEmptyStr(filePath))
			return false;
		File f = new File(filePath);
		if (!f.exists())
			return false;
		return true;
	}

	/**
	 * 文字列の空文字☑
	 * 
	 * @param str
	 * @return true:空、false:空ではない
	 */
	static boolean isEmptyStr(String str) {
		return str == null || str.trim().length() == 0;
	}

}
