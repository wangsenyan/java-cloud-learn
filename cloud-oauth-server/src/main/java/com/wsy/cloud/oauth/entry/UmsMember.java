package com.wsy.cloud.oauth.entry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UmsMember implements Serializable {
    private Long id;

    private Long member_level_id;

    private String username;

    private String password;

    private String nickname;

    private String phone;

    private Integer status;

    private Date create_time;

    private String icon;

    private Integer gender;

    private Date birthday;

    private String city;

    private String job;

    private String personalized_signature;

    private Integer source_type;

    private Integer integration;

    private Integer growth;

    private Integer luckey_count;

    private Integer history_integration;
}
