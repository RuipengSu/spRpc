package com.srp.bootstrap;

import com.google.common.base.Preconditions;
import com.srp.server.Server;
import com.srp.server.ServerImpl;

/**
 * @ Author: Su RuiPeng
 * @ Date: 2018/10/21
 * 封装服务端接口
 */
public class ServerBuilder {
    private int port;
    private String serviceName;
    private Object serviceImpl;
    private String zkConn;

    private ServerBuilder() {}

    public static ServerBuilder builder() {
        return new ServerBuilder();
    }

    public ServerBuilder port(int port) {
        this.port = port;
        return this;
    }

    public ServerBuilder serviceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public ServerBuilder serviceImpl(Object serviceImpl) {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public ServerBuilder zkConn(String zkConn) {
        this.zkConn = zkConn;
        return this;
    }

    public Server build() {
        Preconditions.checkNotNull(serviceImpl);
        Preconditions.checkNotNull(serviceName);
        Preconditions.checkNotNull(zkConn);
        Preconditions.checkArgument(port > 0);
        return new ServerImpl(this.port, this.serviceImpl, this.serviceName, this.zkConn);
    }
}
