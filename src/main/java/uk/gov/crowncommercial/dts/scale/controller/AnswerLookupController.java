package uk.gov.crowncommercial.dts.scale.controller;

import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import uk.gov.crowncommercial.dts.scale.model.Answer;
import uk.gov.crowncommercial.dts.scale.service.AnswersService;

/**
 *
 */
@RestController
@RequiredArgsConstructor
public class AnswerLookupController {

  private final AnswersService answersService;

  @GetMapping("/answers")
  public Set<Answer> findAnswers(
      @RequestParam("question-instance-uuid") final String questionInstanceUuid,
      @RequestParam("modifier") final String modifier) {

    return answersService.getAnswers(questionInstanceUuid, modifier);
  }

  @GetMapping("/answers/{answer-uuid}")
  public Answer getAnswer(@PathVariable("answer-uuid") final String answerUuid) {

    return answersService.getAnswer(answerUuid);
  }

}
