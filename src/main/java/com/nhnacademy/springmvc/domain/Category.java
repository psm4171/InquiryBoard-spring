package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    Dissatisfaction("dissatisfaction", "불만 접수"),

    Proposal("proposal","제안"),

    Refund("refund", "환불/교환"),

    Compliment("compliment", "칭찬해요"),

    ETC("etc", "기타 문의");

    private final String key;
    private final String value;

}
