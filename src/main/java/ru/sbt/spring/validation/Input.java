package ru.sbt.spring.validation;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Validated
public class Input {

  @Min(1)
  @Max(10)
  private int numberBetweenOneAndTen;

  public int getNumberBetweenOneAndTen() {
    return numberBetweenOneAndTen;
  }

  public void setNumberBetweenOneAndTen(int numberBetweenOneAndTen) {
    this.numberBetweenOneAndTen = numberBetweenOneAndTen;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
  private String ipAddress;
}