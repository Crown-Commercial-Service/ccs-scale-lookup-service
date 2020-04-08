package uk.gov.crowncommercial.dts.scale.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import uk.gov.crowncommercial.dts.scale.model.Answer;

/**
 *
 */
@Service
@Slf4j
public class AnswersService {

  // MOD Branch
  private static final String GRAPH_UUID_QI_MOD_LOCATION = "b879dae4-654e-11ea-bc55-0242ac130003";
  private static final String GRAPH_UUID_QI_MOD_SERVICES = "b879d86e-654e-11ea-bc55-0242ac130003";
  private static final String GRAPH_UUID_AGMT_FM2_LOT3_FC = "b879e250-654e-11ea-bc55-0242ac130003";
  private static final String GRAPH_UUID_CCS_SUPPORT = "ccb5beb6-75b5-11ea-bc55-0242ac130003";

  // Non MOD branch
  private static final String GRAPH_UUID_AGMT_FM2_LOT2C_FC = "b879e386-654e-11ea-bc55-0242ac130003";
  private static final String GRAPH_UUID_QI_NON_MOD_SERVICES =
      "b879d9cc-654e-11ea-bc55-0242ac130003";
  private static final String GRAPH_UUID_QI_NON_MOD_SUB_SERVICE =
      "b879dbf2-654e-11ea-bc55-0242ac130003";

  // Generic
  private static final String GRAPH_UUID_AGMT_FM_MARKETPLACE =
      "b879e69c-654e-11ea-bc55-0242ac130003";

  private static final Set<Answer> MOD_ANSWERS = new HashSet<>();
  private static final Set<Answer> NON_MOD_ANSWERS = new HashSet<>();
  private static final Map<String, Set<Answer>> CUR_QI_UUID_TO_ANSWERS = new HashMap<>();

  private static final Map<String, Answer> ANSWER_UUID_TO_ANSWER = new HashMap<>();

  static {
    populateMODAnswers();
    populateNonMODAnswers();

    CUR_QI_UUID_TO_ANSWERS.put(GRAPH_UUID_QI_MOD_SERVICES, MOD_ANSWERS);
    CUR_QI_UUID_TO_ANSWERS.put(GRAPH_UUID_QI_NON_MOD_SERVICES, NON_MOD_ANSWERS);

    MOD_ANSWERS.stream().forEach(a -> ANSWER_UUID_TO_ANSWER.put(a.getUuid(), a));
    NON_MOD_ANSWERS.stream().forEach(a -> ANSWER_UUID_TO_ANSWER.put(a.getUuid(), a));
  }

  private static final void populateMODAnswers() {
    // Housing - route to Select Location Question
    Answer housing = Answer.builder().text("Housing").uuid("b87a0136-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_QI_MOD_LOCATION).order(1).build();

    // Others on list (security, catering etc) - route to FM2 Lot 3 Further Comp
    Answer catering = Answer.builder().text("Catering").uuid("b879aede-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(2).build();
    Answer cleaning = Answer.builder().text("Cleaning").uuid("b879b00a-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(3).build();

    Answer compFMgmt = Answer.builder().text("Computer aided facility management (CAFM)")
        .uuid("b87a0226-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC)
        .order(4).build();

    Answer contractMgmt =
        Answer.builder().text("Contract management").uuid("b879b28a-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(5).build();

    Answer contractMobil =
        Answer.builder().text("Contract mobilisation").uuid("b879b352-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(6).build();

    Answer helpdesk = Answer.builder().text("Helpdesk").uuid("b87a0334-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(7).build();

    Answer hortic =
        Answer.builder().text("Horticultural").uuid("b87a0532-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(8).build();

    Answer maintenance =
        Answer.builder().text("Maintenance").uuid("b879b64a-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(9).build();

    Answer mgmtBillWP = Answer.builder().text("Management of billable works and projects")
        .uuid("b879b64a-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC)
        .order(10).build();

    Answer miscFM = Answer.builder().text("Miscellaneous facility management services")
        .uuid("b879b96a-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC)
        .order(11).build();

    Answer reception =
        Answer.builder().text("Reception").uuid("b879ba32-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(12).build();

    Answer securityServices =
        Answer.builder().text("Security").uuid("b879baf0-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(13).build();

    Answer statutoryObgl =
        Answer.builder().text("Statutory obligations").uuid("b879bc44-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(14).build();

    Answer waste = Answer.builder().text("Waste").uuid("b879bd02-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC).order(15).build();

    Answer workplace = Answer.builder().text("Workplace facility management services")
        .uuid("b879be42-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT3_FC)
        .order(16).build();

    // Other not on list - route to Facilities Marketplace
    Answer other = Answer.builder().text("Other").uuid("b879bf0a-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_CCS_SUPPORT).order(17).build();


    MOD_ANSWERS.addAll(Stream.of(housing, catering, cleaning, compFMgmt, contractMgmt,
        contractMobil, helpdesk, hortic, maintenance, mgmtBillWP, miscFM, reception,
        securityServices, statutoryObgl, waste, workplace, other).collect(Collectors.toSet()));
  }

  private static void populateNonMODAnswers() {
    // Housing - route to Select Location Question
    Answer housing = Answer.builder().text("Housing").uuid("b879e8d6-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM2_LOT2C_FC).order(1).build();

    // Security - route to sub-service question
    Answer securityServices =
        Answer.builder().text("Security").uuid("b879f7ea-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_QI_NON_MOD_SUB_SERVICE).order(2).build();

    // Others on list (security, catering etc) - route to FM2 Lot 3 Further Comp
    Answer catering = Answer.builder().text("Catering").uuid("b879ec00-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(3).build();

    Answer cleaning = Answer.builder().text("Cleaning").uuid("b879ed18-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(4).build();

    Answer compFMgmt = Answer.builder().text("Computer aided facility management (CAFM)")
        .uuid("b879ee26-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE)
        .order(5).build();

    Answer contractMgmt =
        Answer.builder().text("Contract management").uuid("b879ef34-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(6).build();

    Answer contractMobil =
        Answer.builder().text("Contract mobilisation").uuid("b879f042-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(7).build();

    Answer helpdesk = Answer.builder().text("Helpdesk").uuid("b879f146-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(8).build();

    Answer hortic =
        Answer.builder().text("Horticultural").uuid("b879f272-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(9).build();

    Answer maintenance =
        Answer.builder().text("Maintenance").uuid("b879f39e-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(10).build();

    Answer mgmtBillWP = Answer.builder().text("Management of billable works and projects")
        .uuid("b879f4ac-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE)
        .order(11).build();

    Answer miscFM = Answer.builder().text("Miscellaneous facility management services")
        .uuid("b879f5ba-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE)
        .order(12).build();

    Answer reception =
        Answer.builder().text("Reception").uuid("b879f6c8-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(13).build();

    Answer statutoryObgl =
        Answer.builder().text("Statutory obligations").uuid("b879f902-654e-11ea-bc55-0242ac130003")
            .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(14).build();

    Answer waste = Answer.builder().text("Waste").uuid("b879f9f2-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(15).build();

    Answer workplace = Answer.builder().text("Workplace facility management services")
        .uuid("b879faf6-654e-11ea-bc55-0242ac130003").outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE)
        .order(16).build();

    Answer other = Answer.builder().text("Other").uuid("b879fbe6-654e-11ea-bc55-0242ac130003")
        .outcomeUuid(GRAPH_UUID_AGMT_FM_MARKETPLACE).order(17).build();

    NON_MOD_ANSWERS.addAll(Stream.of(housing, catering, cleaning, compFMgmt, contractMgmt,
        contractMobil, helpdesk, hortic, maintenance, mgmtBillWP, miscFM, reception,
        securityServices, statutoryObgl, waste, workplace, other).collect(Collectors.toSet()));
  }

  public Set<Answer> getAnswers(final String questionInstanceUuid, final String modifier) {
    log.debug("getAnswers(questionInstanceUuid: {}, modifier: {})", questionInstanceUuid, modifier);
    return CUR_QI_UUID_TO_ANSWERS.get(questionInstanceUuid);
  }

  public Answer getAnswer(final String answerUuid) {
    log.debug("getAnswer(answerUuid: {})", answerUuid);
    return ANSWER_UUID_TO_ANSWER.get(answerUuid);
  }

}
