package com.library.utils;

import static java.util.Objects.isNull;

import com.library.api.model.ValidationErrorResponse;
import com.library.api.model.exceptions.CustomBadRequestException;
import jakarta.validation.constraints.Past;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateValidator {

  private static final String DATE_FORMAT = "yyyy-MM-dd";

  public static Date isValidDate(String date) {
    Date parsedDate;

    try {
      SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
      sdf.setLenient(false);
      parsedDate = sdf.parse(date);
    } catch (Exception e) {
      throw new CustomBadRequestException(
          new ValidationErrorResponse("Валидация не пройдена", "1001",
              "Дата должна быть в формате yyyy-MM-dd"));
    }

    LocalDate currentDate = LocalDate.now();
    if (parsedDate.after(Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
      throw new CustomBadRequestException(
          new ValidationErrorResponse("Валидация не пройдена","1001",
              "Дата должна быть в прошлом"));
    }
    return parsedDate;
  }

  public static String getDateString(Date date) {
    if (isNull(date)) {
      return null;
    }

    DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

    try {
      return formatter.format(date);
    } catch (Exception e) {
      throw new CustomBadRequestException(
          new ValidationErrorResponse("Валидация не пройдена","1006",
              "Дата в базе данных должна быть в формате yyyy-MM-dd"));
    }
  }
}