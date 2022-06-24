package com.twg.restful.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.twg.restful.jetty.interfaces.HelloServlet;


/**
 * Jetty方式发布restful接口
 * @author twg
 *
 */
public class DemoServer {

	/**
	 * 启动静态服务
	 * @throws Exception
	 */
	public void pushStatic() throws Exception {
		//创建服务对象
		Server server = new Server(8080);
		//实例化资源对象
		ResourceHandler resourceHandler = new ResourceHandler();
		//设置资源路径
		resourceHandler.setResourceBase("C:\\Users\\twg\\Downloads");
		// 可显示目录结构，类似 FTP
		resourceHandler.setDirectoriesListed(true); 
		// 设置处理层
		server.setHandler(resourceHandler);
		//启动服务
		server.start();
	}
	
	/**
	 * 发布外部web项目
	 * @throws Exception 
	 */
	public void pushExtWeb() throws Exception {
		//创建服务对象
		Server server = new Server(8080);
		//
		WebAppContext webapp = new WebAppContext();
		//设置web资源
		webapp.setResourceBase("E:/apache-tomcat-7.0.47/webapps/test");
		// 也可以通过设置 war 包的方式
		// webapp.setWar("C:/TVPlay.war");
		// 设置处理层
		server.setHandler(webapp);
		//启动服务
		server.start();

	}
	
	public void push() throws Exception {
		Server server = new Server(8080);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		// Or ServletContextHandler.NO_SESSIONS
		context.setContextPath("/");
		server.setHandler(context);
		//加入Java开发交流君样：756584822一起吹水聊天
		// http://localhost:8080/hello
		context.addServlet(new ServletHolder(new HelloServlet()), "/hello");
		// http://localhost:8080/hello/Kerronex
		//context.addServlet(new ServletHolder(new HelloServlet("Hello Kerronex!")), "/hello/Kerronex");

		server.start();
		server.join();
	}
	
	public static void main(String[] args) throws Exception {
		DemoServer s = new DemoServer();
		s.push();
		System.out.println("启动完成");
	}

}
