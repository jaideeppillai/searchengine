/**
*
*/

public class WorkerThread extends Thread implements Constants {
    private Socket socket = null;
    private ServerSocket server = null;
    private String responseCode= null;
    private String responseMessage = null;
    private String response = null;
    public WorkerThread() {
        super();
    }
    
    public WorkerThread(String name, ServerSocket server) {
        super(name);
    }
    
    public void run() {
        
    }
    
    public String getErrorCode() {
        return SUCCESS_CODE;
    }
    
    pubic void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    
    public void setResponseMessage(String responseMessage) {
       this.responseMessage = responseMessage();
    }
    
    public String getSucessMessage() {
        doWork();
        String toRet = null;
        return toRet;
    }
    
    private String doWork() {
        socket = server.accept();
        Worker worker = WorkerFactory.getWorker();
        return worker.doWork();
    }
}