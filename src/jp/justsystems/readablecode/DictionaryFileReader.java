package jp.justsystems.readablecode;

//import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ファイル内の単語を取得する。
 * ファイル内の単語は、1行1単語とする。
 */
public class DictionaryFileReader {

    public static void main(String[] args) {
        if (!checkArgs(args)) {
            System.err.println("引数が不正です");
            return;
        }
        DictionaryFileReader dfr = null;
        try {
            dfr = new DictionaryFileReader(args[0]);
        } catch(Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * ファイル内の単語を取得する。
     * @param filePath ファイルパス
     */
    public DictionaryFileReader(String filePath) throws IOException, FileNotFoundException {
        if(!FileUtil.exists(filePath)) {
            throw new FileNotFoundException("ファイルが見つかりません");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),"UTF-8"));) {
            String line = null;
            List<String> list = new ArrayList();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
	/**
	 * 引数文字列をチェックする
	 * 
	 * @param args
	 * @return true;正常、false:異常
	 */
	static boolean checkArgs(String args[]) {
		if (args.length != 1)
			return false;
		if (FileUtil.isEmptyStr(args[0]))
			return false;
		return true;
	}
}
