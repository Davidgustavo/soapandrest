package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.CronapiCloud;


/**
 * Classe que representa a tabela ARQUIVOS
 * @generated
 */
@Entity
@Table(name = "\"ARQUIVOS\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Arquivos")
public class Arquivos implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "photo", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiCloud(type = "dropbox", value="DJC3GwdSZWAAAAAAAAAAEUKWV7zphsUdS3LweI5McLDASbp-N6q_7gs7KtNZfc7p")
  
  private java.lang.String photo;

  /**
  * @generated
  */
  @Column(name = "arquivos", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String arquivos;

  /**
   * Construtor
   * @generated
   */
  public Arquivos(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Arquivos setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém photo
   * return photo
   * @generated
   */
  
  public java.lang.String getPhoto(){
    return this.photo;
  }

  /**
   * Define photo
   * @param photo photo
   * @generated
   */
  public Arquivos setPhoto(java.lang.String photo){
    this.photo = photo;
    return this;
  }

  /**
   * Obtém arquivos
   * return arquivos
   * @generated
   */
  
  public java.lang.String getArquivos(){
    return this.arquivos;
  }

  /**
   * Define arquivos
   * @param arquivos arquivos
   * @generated
   */
  public Arquivos setArquivos(java.lang.String arquivos){
    this.arquivos = arquivos;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Arquivos object = (Arquivos)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
