package com.createO.protoType;

public class Client {
    private ProtoType protoType;

    public ProtoType getProtoType() {
        return protoType;
    }

    public void setProtoType(ProtoType protoType) {
        this.protoType = protoType;
    }

    public void operation(ProtoType example){
        ProtoType protoType = example.clone();
    }
}
