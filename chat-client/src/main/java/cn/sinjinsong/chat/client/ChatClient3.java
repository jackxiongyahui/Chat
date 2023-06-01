package cn.sinjinsong.chat.client;

/**
 * Created on 2023/6/1 14:36
 *
 * @author XiongYahui
 */
public class ChatClient3 {
    public static void main(String[] args) {
        System.out.println("Initialing...");
        ChatClient1 client = new ChatClient1("Client3", 200, 200, 300, 200);
        client.launch();
    }
}
