package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.ISendOtpValidationCreateChallengeV0Business;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl.SendOtpValidationCreateChallengeV0Dao;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendOtpValidationCreateChallengeV0Business implements ISendOtpValidationCreateChallengeV0Business {

  private static final org.apache.commons.logging.Log log  = LogFactory.getLog(SendOtpValidationCreateChallengeV0Dao.class);

  @Autowired
  private SendOtpValidationCreateChallengeV0Dao dao;

  @Override
  public BDtoOutCreateChallengePost sendOtpValidationCreateChallengeV0(final BDtoInCreateChallengePost createChallengePost) {
    //llamar aqui a la capa DAO poner LOGS
    /**
     * Business pipe
     * business - dao - impl : return BDoUt...
     */
    log.debug("Starting validation for: ".concat(createChallengePost.toString()));
    BDtoOutCreateChallengePost out = dao.invokeRestlessApxTransaction(createChallengePost);
    log.debug("Response DAO: ".concat(out.toString()));
    return out;
  }
}
