package com.company;

public class DNABeanBuilder {
    private String key;

    public DNABeanBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public DNABean createDNABean() {
        return new DNABean(key);
    }
}