package uk.gov.crowncommercial.dts.scale.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 *
 */
@Value
@Builder
public class Answer {

  @NonNull
  String uuid;

  @NonNull
  String text;

  @NonNull
  Integer order;

  String hint;

  @NonNull
  String outcomeUuid;

}

