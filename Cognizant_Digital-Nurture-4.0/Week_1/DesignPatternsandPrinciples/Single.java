package DesignPatternsandPrinciples;

class Logger {  
    private static Logger instance;  

    private Logger() {  
        System.out.println("Logger Initialized!");  
    }  

    public static Logger getInstance() {  
        if (instance == null) {  
            instance = new Logger();  
        }  
        return instance;  
    }  

    public void log(String message) {  
        System.out.println("Log: " + message);  
    }  
}  

public class Single{  
    public static void main(String[] args) {  
        Logger logger1 = Logger.getInstance();  
        Logger logger2 = Logger.getInstance();  

        logger1.log("Application started.");  
        logger2.log("User logged in.");  

        // Checking if both instances are the same
        if (logger1 == logger2) {  
            System.out.println("Both logger1 and logger2 are the same instance.");  
        } else {  
            System.out.println("Different instances exist! Singleton failed.");  
        }  
    }  
}