/**
 * 
 */
package com.jaideep.search.ws;

import java.net.SocketAddress;

/**
 * @author Jaideep
 *
 */
public class SearchWebService extends AbstractWebService {
	/**
	 * 
	 */
	public SearchWebService() {
		// TODO Auto-generated constructor stub
	}
	
	public void publish(String[] str) {
		String url = URL;
		AbstractWebService server = Service service = new SerchWebService();
		ServerSocket server = new ServerSocket(PORT);
		SocketAddress address = new SocketAddress();
		server.GetServerSocketChanel = getServerSocketChannel();
        server.bind();
        String[]String[] toRet = new String[]String[]
        Thread worker = new WorkerThread(class.toString(), server);
        worker.start();
        return toRet;
	}
}
