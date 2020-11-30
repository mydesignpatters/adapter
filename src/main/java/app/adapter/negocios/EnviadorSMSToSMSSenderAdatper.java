package app.adapter.negocios;

import app.adapter.sms.IEnviadorSMS;
import app.adapter.sms.ISMSSender;
import app.adapter.sms.SMS;
import app.adapter.sms.SMSException;

public class EnviadorSMSToSMSSenderAdatper implements ISMSSender {
    private IEnviadorSMS enviador;

    public EnviadorSMSToSMSSenderAdatper(IEnviadorSMS enviador) {
        this.enviador = enviador;
    }

    /**
     * Dada uma mensagem de texto quebra em um array de String
     * @param mensagem mensagem de texto
     * @return Array de String
     */
    private String[] quebrarTexto(String mensagem) {
        int size = mensagem.length();
        int qtd = (size % 160 == 0) ? size / 160 : size / 160 + 1;
        String[] msgs = new String[qtd];

        for (int i = 0; i < qtd; i++) {
            int min = i * 160;
            int max = (i == qtd - 1) ? size : (i + 1) * 160;
            msgs[i] = mensagem.substring(min, max);
        }
        return msgs;
    }

    @Override
    public boolean sendSMS(SMS sms) {
        String destino = sms.getDestino();
        String origem = sms.getOrigem();
        String texto = sms.getTexto(); 
        String[] msgs = this.quebrarTexto(texto);

        try {
            enviador.enviarSMS(destino, origem, msgs);
        } catch (SMSException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}