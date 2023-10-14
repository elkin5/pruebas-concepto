package co.com.bancolombia.model.client;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Client {
  private Long id;
  private String documentType;
  private String documentNumber;
  private String fullName;
  private String shortNameClient;
  private String mdmKey;
  private String typeCustomer;
  private LocalDateTime vinculationDate;
  private LocalDateTime dateLastUpdate;
  private String authorizeSharingInformation;
  private String specialDial;
  private String selfRetainerOtherIncome;
  private String withholdingAgent;
  private String regimeIVA;
  private String role;
  private String status;
  private LocalDateTime registrationDate;
  private Boolean isBlockedPayment;
  private Boolean isRoleValidation;
}
