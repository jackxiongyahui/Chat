package cn.sinjinsong.common.domain;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by SinjinSong on 2017/5/22.
 */

public class Message {
    private MessageHeader header;
    private byte[] body;

    public Message() {
    }

    public Message(MessageHeader header, byte[] body) {
        this.header = header;
        this.body = body;
    }

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
            "header=" + header +
            ", body=" + new String(body, StandardCharsets.UTF_8) +
            '}';
    }
}
