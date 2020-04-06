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
    Answer housing =
        new Answer("Housing", "b87a0136-654e-11ea-bc55-0242ac130003", GRAPH_UUID_QI_MOD_LOCATION);

    // Others on list (security, catering etc) - route to FM2 Lot 3 Further Comp
    Answer gfm = new Answer("General facility marketplace", "b879ae0c-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer catering = new Answer("Catering services", "b879aede-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer cleaning = new Answer("Cleaning services", "b879b00a-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer compFMgmt = new Answer("Computer aided facility management",
        "b87a0226-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer contractMgmt = new Answer("Contract management", "b879b28a-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer contractMobil = new Answer("Contract mobilisation",
        "b879b352-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer helpdesk = new Answer("Helpdesk services", "b87a0334-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer hortic = new Answer("Horticultural services", "b87a0532-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer maintenance = new Answer("Maintenance services", "b879b64a-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer mgmtBillWP = new Answer("Management of billable works and projects",
        "b879b64a-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer miscFM = new Answer("Miscellaneous FM services", "b879b96a-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer reception = new Answer("Reception services", "b879ba32-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer securityServices = new Answer("Security services",
        "b879baf0-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer statutoryObgl = new Answer("Statutory obligations",
        "b879bc44-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer waste = new Answer("Waste services", "b879bd02-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);
    Answer workplace = new Answer("Workplace FM services", "b879be42-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM2_LOT3_FC);

    // Other not on list - route to Facilities Marketplace
    Answer other =
        new Answer("Other", "b879bf0a-654e-11ea-bc55-0242ac130003", GRAPH_UUID_CCS_SUPPORT);


    MOD_ANSWERS.addAll(Stream.of(housing, gfm, catering, cleaning, compFMgmt, contractMgmt,
        contractMobil, helpdesk, hortic, maintenance, mgmtBillWP, miscFM, reception,
        securityServices, statutoryObgl, waste, workplace, other).collect(Collectors.toSet()));
  }

  private static void populateNonMODAnswers() {
    // Housing - route to Select Location Question
    Answer housing =
        new Answer("Housing", "b879e8d6-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM2_LOT2C_FC);

    // Security - route to sub-service question
    Answer securityServices = new Answer("Security services",
        "b879f7ea-654e-11ea-bc55-0242ac130003", GRAPH_UUID_QI_NON_MOD_SUB_SERVICE);

    // Others on list (security, catering etc) - route to FM2 Lot 3 Further Comp
    Answer gfm = new Answer("General facility marketplace", "b879eab6-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer catering = new Answer("Catering services", "b879ec00-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer cleaning = new Answer("Cleaning services", "b879ed18-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer compFMgmt = new Answer("Computer aided facility management",
        "b879ee26-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer contractMgmt = new Answer("Contract management", "b879ef34-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer contractMobil = new Answer("Contract mobilisation",
        "b879f042-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer helpdesk = new Answer("Helpdesk services", "b879f146-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer hortic = new Answer("Horticultural services", "b879f272-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer maintenance = new Answer("Maintenance services", "b879f39e-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer mgmtBillWP = new Answer("Management of billable works and projects",
        "b879f4ac-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer miscFM = new Answer("Miscellaneous FM services", "b879f5ba-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer reception = new Answer("Reception services", "b879f6c8-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer statutoryObgl = new Answer("Statutory obligations",
        "b879f902-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer waste = new Answer("Waste services", "b879f9f2-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer workplace = new Answer("Workplace FM services", "b879faf6-654e-11ea-bc55-0242ac130003",
        GRAPH_UUID_AGMT_FM_MARKETPLACE);
    Answer other =
        new Answer("Other", "b879fbe6-654e-11ea-bc55-0242ac130003", GRAPH_UUID_AGMT_FM_MARKETPLACE);

    NON_MOD_ANSWERS.addAll(Stream.of(housing, gfm, catering, cleaning, compFMgmt, contractMgmt,
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
