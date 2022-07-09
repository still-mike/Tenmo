package Exceptions;

public class TransfersToAccountException extends Exception{

    public TransfersToAccountException(){
        super("Cannot transfer to own account.");
    }
}
