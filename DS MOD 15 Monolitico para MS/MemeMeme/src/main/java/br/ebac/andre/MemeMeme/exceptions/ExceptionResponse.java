package br.ebac.andre.MemeMeme.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse extends Throwable implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensagem;
    private Date timestamp;
    private String detalhes;

    public ExceptionResponse(String mensagem, Date timestamp, String detalhes){
        super();
        this.mensagem = mensagem;
        this.timestamp = timestamp;
        this.detalhes = detalhes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData() {
        return timestamp;
    }

    public void setData(Date data) {
        this.timestamp = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetatalhes(String detatalhes) {
        this.detalhes = detatalhes;
    }
}
