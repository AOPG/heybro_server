package com.heybro.domain;

/**
 * Created by SongpoLiu on 2017/7/10.
 */
public class BusinessMessageBuilder<T> {

    private BusinessMessage<T> message = new BusinessMessage<>();

    public BusinessMessageBuilder() {
        this.message.setCount(0L);
    }

    public BusinessMessageBuilder(Long count) {
        this.message.setCount(count);
    }

    public BusinessMessageBuilder<T> code(String code) {
        this.message.setCode(code);

        return this;
    }

    public BusinessMessageBuilder<T> count(Long count) {
        this.message.setCount(count);

        return this;
    }

    public BusinessMessageBuilder<T> msg(String msg) {
        this.message.setMsg(msg);

        return this;
    }

    public BusinessMessageBuilder<T> data(T data) {
        this.message.setData(data);

        return this;
    }

    public BusinessMessage<T> build() {
        return this.message;
    }

}
