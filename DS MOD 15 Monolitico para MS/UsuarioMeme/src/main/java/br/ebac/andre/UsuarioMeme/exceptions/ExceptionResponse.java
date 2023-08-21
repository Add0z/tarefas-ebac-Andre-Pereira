package br.ebac.andre.UsuarioMeme.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensagem;
    private Date timestamp;
    private String detatalhes;

    public ExceptionResponse(String mensagem, Date timestamp, String detalhes){
        super();
        this.mensagem = mensagem;
        this.timestamp = timestamp;
        this.detatalhes = detalhes;
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

    public String getDetatalhes() {
        return detatalhes;
    }

    public void setDetatalhes(String detatalhes) {
        this.detatalhes = detatalhes;
    }
}
