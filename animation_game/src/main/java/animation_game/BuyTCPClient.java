package animation_game;

/*
  * キーボードから読み込んだ年齢をサーバに送信し、
  * サーバから受信した飲酒可否の判定結果をディスプレイに表示するクライアント
*/

import java.io.BufferedReader;    //　入出力関連パッケージを利用する
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;    //ネットワーク関連のパッケージを利用する
//　ユーティリティパッケージを利用する

public class BuyTCPClient {

    /*メイン・メソッド
     * 指定されたサーバに対して接続を要求し、
     * 接続されたらキーボードから読み込んだ年齢を送信し、
     *受信した飲酒可否の判定結果をディスプレイに表示する
    */
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            BufferedReader reader =        //キーボードから接続するサーバ名を読み込む
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Server name(localhost or 133.27.....)? >");//hostname
            String serverName = reader.readLine();
            Socket socket =            //指定されたサーバの5000番ポートに接続を要求する
                    new Socket(serverName, 5002);


            ObjectOutputStream oos = null ;
            ObjectInputStream ois = null ;
            int count = 0;
            while(count++ < 15 ){
                /* キーボードから箱買いしたいものを読み込む */
                System.out.print("何が買いたいですか? >");
                String lineStr = reader.readLine();

                /* サーバに入力したものを送信する */
                oos =
                        new ObjectOutputStream(socket.getOutputStream());

                //intはobject型でないのでObject型であるIntergerクラスに変換する。


//            StockData present = new StockData();
//            present.setName(lineStr);

                /* キーボードから金額を読み込む */
                System.out.print("金額は? >");
                int lineprice = Integer.parseInt(reader.readLine());

//            present.setPrice(lineprice);


                oos.writeObject(lineStr);
                oos.flush();

                /* サーバから判定結果を受信する */
                ois =
                        new ObjectInputStream(socket.getInputStream());
                //String result = (String)ois.readObject();//返事を文字列型でキャストする。

                String ob = (String) ois.readObject();

                System.out.println(ob+"を1ダース購入した場合の金額は"+"a"+"円");
                System.out.println("おすすめは"+"b"+"です");
            }

//            String replayPresent = ob.getPresent();
//            System.out.println("お返しプレゼントは" + replayPresent);

            oos.close();
            ois.close();

            socket.close();

        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (java.net.UnknownHostException uhe) {
            uhe.printStackTrace();
            System.err.println("送信先のサーバ名が間違っているのでプログラムを終了します");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
        }
    }
}