package com.shop.ftp;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;

@Component
public class FTPService {

	@Autowired
	@Qualifier("ftpServerBootstrap")
	private ServerBootstrap b;

	@Autowired
	@Qualifier("ftpTcpSocketAddress")
	private InetSocketAddress tcpPort;

	private ChannelFuture serverChannelFuture;

	@PostConstruct
	public void start() throws Exception {
		System.out.println("启动文件系统： " + tcpPort);
		serverChannelFuture = b.bind(tcpPort).sync();
	}

	@PreDestroy
	public void stop() throws Exception {
		serverChannelFuture.channel().closeFuture().sync();
	}

	public ServerBootstrap getB() {
		return b;
	}

	public void setB(ServerBootstrap b) {
		this.b = b;
	}

	public InetSocketAddress getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(InetSocketAddress tcpPort) {
		this.tcpPort = tcpPort;
	}

}
