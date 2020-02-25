package app.controle.sms;

public class SMS {
    private String destino;
    private String origem;
    private String texto;
    
    public SMS(String d, String o, String t){
        this.destino = d;
        this.origem = o;
        this.texto = t;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }

    public String getDestino(){
        return destino;
    }

    public void setOrigem(String origem){
        this.origem = origem;
    }

    public String getOrigem(){
        return origem;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }
}