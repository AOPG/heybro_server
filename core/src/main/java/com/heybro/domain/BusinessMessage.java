package com.heybro.domain;

import lombok.Data;

/**
 * Created by SongpoLiu on 2017/7/10.
 */
@Data
public class BusinessMessage<T> {

    private String code;

    private String msg;

    private Long count;

    private T data;

}
