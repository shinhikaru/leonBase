package com.leonBase

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
/** * * よく使うJavaの技術 */

public class Test {    
  public static void main(String arg[]) {
    System.out.println("bot Access Simulator");
    Test test = new Test();
    //test.getIP();
    for(int i=0; i<3; i++) {
      System.out.println("###No" + i + " START##############################################");
      test.botSimulator();
      System.out.println("###No" + i + " END##################################################");
    } 
    test.processTest();
  }

  //模擬ページアクセスプログラム
  public void botSimulator() {
    try {
      URL url = new URL("http://localhost:8080/sample");
      URLConnection uc = url.openConnection();
      String userAgent;
      userAgent = "Mozilla/5.0 (compatible; msmbot/2.1; +http://www.mmsn.com/bot.html)";
      
      //ユーザエジェントに自由に設定する。ボットを真似する。
      uc.setRequestProperty("User-Agent", userAgent);
      
      //ページの内容を読み込む。
      InputStream is = uc.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      
      String s;
      while ((s = reader.readLine()) != null) {
        System.out.println(s);
      }
      reader.close();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
  
  // host IP した結果からIPアドレスを取得する。
  public void getIP() {
    String line = "197.65.249.66.in-addr.arpa domain name pointer crawl-66-249-65-197.googlebot.com.";
    String ip;
    ip = line.substring(0, line.indexOf(".in-addr"));
    System.out.println("ip=" + ip);
    line = "Host 88.224.85.209.in-addr.arpa. not found: 3(NXDOMAIN)";
    ip = line.substring(5, line.indexOf(".in-addr"));
    System.out.println("ip=" + ip);
  }
  
  // Runtime#run　の代わり案
  public void processTest() {
    ProcessBuilder pb = new ProcessBuilder("java", "-version");
    pb.redirectErrorStream(true);
    try {
      Process process = pb.start();
      // 標準出力を獲得する。
      InputStream is = process.getInputStream();
      printInputStream(is);
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }
 
  public static void printInputStream(InputStream is) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    try {
      for (;;) {
        String line = br.readLine();
        if (line == null) break;
        System.out.println(line);
      }
    } finally {
      br.close();
    }
  }
}
