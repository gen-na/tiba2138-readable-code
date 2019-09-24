package jp.justsystems.readablecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 登録したい単語を（既に登録されていなければ）ファイルに登録する。
 *
 */
public class DictionaryFileWriter {

	/**
	 * @param args[0]
	 *            ファイルパス args[1] 登録したい単語
	 */
	public static void main(String[] args) {
		if (!checkArgs(args)) {
			System.err.println("引数が不正です");
			return;
		}
		try {
			addWord(args[0], args[1]);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * 登録したい単語をファイルに登録する。
	 * 
	 * @param filePath
	 *            ファイルパス
	 * @param word
	 *            登録したい単語
	 */
	private static void addWord(String filePath, String word) throws IOException, FileNotFoundException {
		if (!FileUtil.exists(filePath)) {
			throw new FileNotFoundException("ファイルが見つかりません");
		}
		// 辞書に登録する単語一覧
		Set<String> words = new HashSet<String>();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));) {
			String line = null;
			words.add(word);
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			words.forEach(s -> {
				System.out.println(s);
			});
		} catch (Exception e) {
			throw e;
		}
		// TODO 単語を辞書として登録する
	}

	/**
	 * 引数文字列をチェックする
	 * 
	 * @param args
	 * @return true;正常、false:異常
	 */
	static boolean checkArgs(String args[]) {
		if (args.length != 2)
			return false;
		if (FileUtil.isEmptyStr(args[0]))
			return false;
		return true;
	}
}
