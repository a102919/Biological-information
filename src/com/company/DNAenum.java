package com.company;

public enum DNAenum {
    A('A'),C('C'),G('G'),T('T');
    private char DNA;
    DNAenum(char t) {
        this.DNA = t;
    }
    public char getValue(){
        return this.DNA;
    }
}
