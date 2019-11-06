package com.createO.protoType;

public class ConcretePrototype implements ProtoType{

    public ProtoType clone() {
        ProtoType protoType =  new ConcretePrototype();
        return protoType;
    }
}
