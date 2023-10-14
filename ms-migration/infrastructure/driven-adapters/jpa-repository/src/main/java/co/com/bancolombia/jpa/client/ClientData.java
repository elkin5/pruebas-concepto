package co.com.bancolombia.jpa.client;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "TBL_CLIENT")
@Data
@NoArgsConstructor
//Clase que se conecta con la base de datos
public class ClientData implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "DOCUMENT_TYPE")
  @Enumerated(EnumType.STRING)
  private DocumentType documentType;

  @Column(name = "DOCUMENT_NUMBER")
  private String documentNumber;

  @Column(name = "FULL_NAME")
  private String fullName;

  @Column(name = "SHORT_NAME")
  private String shortNameClient;

  @Column(name = "MDM_KEY", updatable = false, nullable = false)
  private String mdmKey;

  @Column(name = "TYPE_CUSTOMER")
  private String typeCustomer;

  @Column(name = "VINCULATION_DATE")
  private LocalDateTime vinculationDate;

  @Column(name = "DATE_LAST_UPDATE")
  private LocalDateTime dateLastUpdate;

  @Column(name = "AUTHORIZE_SHARING_INFORMATION")
  private String authorizeSharingInformation;

  @Column(name = "SPECIAL_DIAL")
  private String specialDial;

  @Column(name = "SELF_RETAINER_OTHER_INCOME")
  private String selfRetainerOtherIncome;

  @Column(name = "WITH_HOLDING_AGENT")
  private String withholdingAgent;

  @Column(name = "REGIME_IVA")
  private String regimeIVA;

  @Column(name = "ROLE_")
  private String role;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "BLOCKED_PAYMENT")
  private Boolean isBlockedPayment;

  @Column(name = "REGISTRATION_DATE")
  private LocalDateTime registrationDate;
}

enum DocumentType {
  NUIP(0,"NUIP","TIPDOC_FS000"),
  //CD(0,"CD","",""),
  CC(1,"CEDULA DE CIUDADANIA","TIPDOC_FS001"),
  CE(2,"CEDULA DE EXTRANJERIA","TIPDOC_FS002"),
  NIT(3,"NIT","TIPDOC_FS003"),
  TI(4,"TARJETA DE IDENTIDAD","TIPDOC_FS004"),
  PASS(5,"PASAPORTE","TIPDOC_FS005"),
  IEPN(6,"ID EXTRANJERO PN NO RESIDENTE EN COLOMBIA","TIPDOC_FS006"),
  IEPJ(7,"ID EXTRANJERO PJ NO RESIDENTE COLOMBIA","TIPDOC_FS007"),
  FC(8,"FIDEICOMISO","TIPDOC_FS008"),
  RC(9,"REGISTRO CIVIL","TIPDOC_FS009");

  private final Integer code;
  private final String name;
  private final String codeCustomer;

  DocumentType(Integer code, String name, String codeCustomer) {
    this.code = code;
    this.name = name;
    this.codeCustomer = codeCustomer;
  }

  public Integer getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getCodeCustomer() {
    return codeCustomer;
  }

  public static DocumentType toDocumentType(String description) {
    return Arrays.stream(DocumentType.values())
            .filter((type)->type.codeCustomer.equalsIgnoreCase(description))
            .findAny().orElse(DocumentType.CC);
  }

  @Override
  public String toString() {
    return name;
  }
}