package nju.edu.travel.web.vo;

import lombok.Data;

/**
 * Created by Cary on 19-1-3
 * Email: yangyangshi@smail.nju.edu.cn
 */
@Data
public class Message<T> {
    private T data;
    private int code;
    private String info;

    public Message(T data, int code, String info) {
        this.data = data;
        this.code = code;
        this.info = info;
    }
}
