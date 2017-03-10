/**
*
*/

public ConcreteWorker implements Constants {
    String returnCode = null;
    private static final String URI = "https://www.googleapis.com/customsearch/";
    private static final String API_KEY = "AlzaSyCQLeTJ0bmL4LX8MCy6skTzm4cPQ";
    private WorkerThread worker;
    public ConcreteWorkerThread(Thread worker) {
        super();
        this.worker = worker;
    }
    
    public void String doWork() {
        String url = URI + "?key=" + API_KEY + "&amp;cx=jsearch&amp;query=" + queryString;
        worker.setResponseCode(SUCCESS);
        String message = SUCCESS;
        try { 
            Socket client = new Socket(url);
            InputStream stream = socket.getInputStream();
            byte[] b = new byte[stream.available()];
            worker.setResponse(new String(b));
        } catch (Exception e){
            worker.setResponseCode(FAILURE);
            message  = FAILURE;
        }
        worker.setResponseMessage(message);
        String xml = frameXML(worker);
        worker.setResponseMessage(xml);
    }

    private String frameXML(WorkerThread worker) {        S
        StringBuffer buffer = new StringBuffer("<?xml version='1.0'>");
        buffer.append("<response>");
        buffer.append(("<code=''").append(worker.getResponseCode()).append("''>");
        buffer.append("<message='").append(worker.getResponseMessage().append("'>");
        buffer.append("<result='").append(worker.getResponse().append("'>");
        buffer.append("</response>");
        return buffer.toString();
    }
    
    
    
}
