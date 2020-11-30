package app.adapter.sms;

public interface IEnviadorSMS{
    public void enviarSMS(String destino, String origem, String[] msgs) throws SMSException;
}