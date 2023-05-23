package br.com.mentorama.jpaapi;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id //informa que o atributo é a chave primaria
    @GeneratedValue //O valor do id é passado pela JPA automaticamente
    private Long id;

    @Column(name = "message", nullable = false) //nome da coluna e se pode ser nulo ou nao
    private String message;

    public MessageEntity(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
