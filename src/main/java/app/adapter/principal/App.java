package app.adapter.principal;

import app.adapter.negocios.EnviadorSMS;
import app.adapter.negocios.EnviadorSMSToSMSSenderAdatper;
import app.adapter.negocios.SMSSender;
import app.adapter.sms.SMS;
import app.adapter.sms.SMSException;

public class App {
    public static void main(String[] args) {
        System.out.println("Usando o padrao Adapter");

        SMS sms = new SMS("086994693558", "086994139207", "Vai lá mamãe! Cuidar da filhotinha!");

        // Envia mensagem via SMSSender
        System.out.println("1) SMS via SMSSender");
        SMSSender smsSender = new SMSSender();
        smsSender.sendSMS(sms);

        System.out.println("--------------------");

        System.out.println("2) SMS via EnviadorSMS");
        // Envia mensagem via EnviadorSMS
        EnviadorSMS enviadorSMS = new EnviadorSMS();
        String[] msgs = { "Mensagem 1", "Mensagem 2", "Mensagem 3"};

        try {
            enviadorSMS.enviarSMS(sms.getDestino(), sms.getOrigem(), msgs);
        } catch (SMSException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------");

        System.out.println("3) SMS via EnviadorSMSToSMSSenderAdatper Adapter");
        // Envia mensagem via EnviadorSMSToSMSSender
        EnviadorSMSToSMSSenderAdatper enviadorSMSToSMSSender = new EnviadorSMSToSMSSenderAdatper(enviadorSMS);
        enviadorSMSToSMSSender.sendSMS(sms);
    }
}