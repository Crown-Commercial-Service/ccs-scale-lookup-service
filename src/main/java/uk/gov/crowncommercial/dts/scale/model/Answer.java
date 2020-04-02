package uk.gov.crowncommercial.dts.scale.model;

import lombok.NonNull;
import lombok.Value;

/**
 *
 */
@Value
public class Answer {

  @NonNull
  String text;

  @NonNull
  String uuid;

  @NonNull
  String outcomeUuid;

}
