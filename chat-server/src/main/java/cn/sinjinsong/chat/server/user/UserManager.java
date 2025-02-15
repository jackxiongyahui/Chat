package cn.sinjinsong.chat.server.user;

import cn.sinjinsong.common.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author SinjinSong
 * @date 2017/5/23
 */
@Component("userManager")
@Slf4j
public class UserManager {
    private Map<String, User> users;
    /**
     * key是ip和端口号，value是用户名
     */
    private Map<SocketChannel, String> onlineUsers;
  
    
    public UserManager() {
        users = new ConcurrentHashMap<>();
        users.put("user1", User.builder().username("user1").password("pwd1").build());
        users.put("user2", User.builder().username("user2").password("pwd2").build());
        users.put("user3", User.builder().username("user3").password("pwd3").build());
        users.put("user4", User.builder().username("user4").password("pwd4").build());
        users.put("user5", User.builder().username("user5").password("pwd5").build());
        onlineUsers = new ConcurrentHashMap<>();
    }

    public synchronized  boolean login(SocketChannel channel, String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }
        User user = users.get(username);
        if (!user.getPassword().equals(password)) {
            return false;
        }
        if(user.getChannel() != null){
            log.info("重复登录，拒绝");
            //重复登录会拒绝第二次登录
            return false;
        }
        user.setChannel(channel);
        onlineUsers.put(channel, username);
        return true;
    }
    
    public synchronized void logout(SocketChannel channel) {
        String username = onlineUsers.get(channel);
        log.info("{}下线",username);
        users.get(username).setChannel(null);
        onlineUsers.remove(channel);
    }
    
    public synchronized SocketChannel getUserChannel(String username) {
        User user = users.get(username);
        if(user == null){
            return null;
        }
        SocketChannel lastLoginChannel = user.getChannel();
        if (onlineUsers.containsKey(lastLoginChannel)) {
            return lastLoginChannel;
        } else {
            return null;
        }
    }
    
}
