package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.DummyMock;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl.SendOtpValidationCreateChallengeV0Dao;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Description;

@RunWith(MockitoJUnitRunner.class)
public class SendOtpValidationCreateChallengeV0BusinessTest {

  @InjectMocks private SendOtpValidationCreateChallengeV0Business bSrv;

  @Mock
  private SendOtpValidationCreateChallengeV0Dao sendOtpValidationCreateChallengeV0Dao;

  private DummyMock dummyMock;

  @Before
  public void init(){
    dummyMock = new DummyMock();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  @Description("Test for testSendOtpValidationCreateChallengeV0 method in business layer")
  public void testSendOtpValidationCreateChallengeV0() {
    Mockito.when(sendOtpValidationCreateChallengeV0Dao.invokeRestlessApxTransaction(Mockito.any(BDtoInCreateChallengePost.class))).thenReturn(dummyMock.getBDtoOutCreateChallengePost());
    BDtoOutCreateChallengePost response = bSrv.sendOtpValidationCreateChallengeV0(dummyMock.getBDtoInCreateChallengePost());
    Assert.assertNotNull(response);
  }
}
