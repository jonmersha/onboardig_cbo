package cbo.onborading.response_object;

public class ResponseMessage {
    private String status;
    private String message;
    private String transactionID;


    public String getTransactionID() {
        return transactionID;
    }

    public ResponseMessage setTransactionID(String transactionID) {
        this.transactionID = transactionID;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public ResponseMessage success(String message){
        this.setStatus("Success");
        this.setMessage(message);
        return this;
    }
    public ResponseMessage error(String message){
        this.setStatus("Error");
        this.setMessage(message);
        return this;
    }
}
