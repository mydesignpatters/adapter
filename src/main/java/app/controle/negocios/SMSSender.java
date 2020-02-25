package app.controle.negocios;

import app.controle.sms.ISMSSender;
import app.controle.sms.SMS;

public class SMSSender implements ISMSSender {

    @Override
    public boolean sendSMS(SMS sms) {
        try {
            System.out.println("A mensagem " + sms.getTexto() + " origem " + sms.getOrigem() + " destino " + sms.getDestino());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}