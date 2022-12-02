package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.DummyMock;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.RequestTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.ResponseTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.tx.mapper.SendOtpValidationCreateChallengeV0DaoMapper;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
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
public class SendOtpValidationCreateChallengeV0DaoTest {

    @InjectMocks
    private SendOtpValidationCreateChallengeV0Dao dao;

    @Mock
    private ServicioTransacciones transactionService;

    @Mock
    private  SendOtpValidationCreateChallengeV0DaoMapper mapper;

    private DummyMock dummyMock;

    @Before
    public void init(){
        dummyMock = new DummyMock();
        MockitoAnnotations.initMocks(this);
    }

    @Description("Test for invokeRestlessApxTransactionTest method in business layer")
    @Test
    public void invokeRestlessApxTransactionTest(){
        mapperTests();
        testInvocar();
        BDtoOutCreateChallengePost res = dao.invokeRestlessApxTransaction(dummyMock.getBDtoInCreateChallengePost());
        Assert.assertNotNull(res);
    }

    public void mapperTests(){
        Mockito.when(mapper.getRequestTx(Mockito.any(BDtoInCreateChallengePost.class))).thenReturn(dummyMock.getRequestDao());
        Mockito.when(mapper.getResponse(Mockito.any(ResponseTransactionCceetl01_1.class))).thenReturn(dummyMock.getResponseDaoMapped());
    }

    public void testInvocar (){
        Mockito.when(transactionService.invocar(Mockito.any(), Mockito.any(), Mockito.any(RequestTransactionCceetl01_1.class))).thenReturn(dummyMock.getResponseDao());
    }


}
