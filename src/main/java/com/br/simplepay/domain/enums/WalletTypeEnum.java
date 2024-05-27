package com.br.simplepay.domain.enums;

public enum WalletTypeEnum {
    COMUM(1),
    LOJISTA(2);

    private int value;

    private WalletTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
