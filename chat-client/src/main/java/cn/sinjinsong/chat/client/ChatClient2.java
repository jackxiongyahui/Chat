package cn.sinjinsong.chat.client;

/**
 * Created on 2023/5/31 16:58
 *
 * @author XiongYahui
 */
public class ChatClient2 {

    public static void main(String[] args) {
        System.out.println("Initialing...");
        ChatClient1 client = new ChatClient1("Client2", 200, 200, 300, 200);
        client.launch();
    }

}
