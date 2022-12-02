package com.bbva.cacd.sendotpvalidationchallengev0.facade.v0.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.DummyMock;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.ISendOtpValidationCreateChallengeV0Business;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.junit.*;
import org.mockito.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class sendOtpValidationCreateChallengeV0Test {

    @Mock
    private ISendOtpValidationCreateChallengeV0Business ISOtpValid;

    @InjectMocks
    private SrvSendOtpValidationAPIChallengeV0 srv;

    private DummyMock dummyMock;

    @Before
    public void init(){
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Description("Test for sendOtpValidationCreateChallengeV0 method in layer facede ")
    @Test
    public void sendOtpValidationCreateChallengeV0(){
        Mockito.when(ISOtpValid.sendOtpValidationCreateChallengeV0(Mockito.any(BDtoInCreateChallengePost.class)))
                .thenReturn(dummyMock.getBDtoOutCreateChallengePost());
        srv.sendOtpValidationCreateChallengeV0(dummyMock.getDtoInCreateChallengePost());
    }

}
