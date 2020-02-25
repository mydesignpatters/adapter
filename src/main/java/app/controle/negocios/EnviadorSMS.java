package app.controle.negocios;

import app.controle.sms.IEnviadorSMS;
import app.controle.sms.SMSException;

public class EnviadorSMS implements IEnviadorSMS {
    @Override
    public void enviarSMS(String destino, String origem, String[] msgs) throws SMSException{
        for (String mensagem : msgs){
            System.out.println("A mensagem " + mensagem + " foi enviada de " + origem + " para " + destino);
        }
    }
    
}