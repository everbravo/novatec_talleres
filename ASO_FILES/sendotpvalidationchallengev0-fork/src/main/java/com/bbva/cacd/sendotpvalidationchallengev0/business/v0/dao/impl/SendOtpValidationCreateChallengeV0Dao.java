package com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.impl;

import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.ISendOtpValidationCreateChallengeV0Dao;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.RequestTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.model.cceetl01_1.ResponseTransactionCceetl01_1;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dao.tx.mapper.SendOtpValidationCreateChallengeV0DaoMapper;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoInCreateChallengePost;
import com.bbva.cacd.sendotpvalidationchallengev0.business.v0.dto.BDtoOutCreateChallengePost;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.LogFactory;

@Component
public class SendOtpValidationCreateChallengeV0Dao implements ISendOtpValidationCreateChallengeV0Dao {

    private static final org.apache.commons.logging.Log log = LogFactory.getLog(SendOtpValidationCreateChallengeV0Dao.class);

    @Autowired
    private ServicioTransacciones transactionService;

    @Autowired
    private SendOtpValidationCreateChallengeV0DaoMapper mapper;

    @Override
    public BDtoOutCreateChallengePost invokeRestlessApxTransaction(BDtoInCreateChallengePost bDtoInCreateChallengePost) {
        //poner lógica de conexión a APX aqui, poner logs y mapear los datos al formato de APX
        /**
         * Pipe...
         * Model - create token
         * Core bbva - method invocar : return respuesta
         * dto - dto out
         */
        log.info("Starting DAO Request: ".concat(String.valueOf(bDtoInCreateChallengePost)));
        // Crear identificador de solicutud
        RequestTransactionCceetl01_1 apxSolicitud = mapper.getRequestTx(bDtoInCreateChallengePost);
        // Invocar transacción (class in, class out, id solicitud)
        ResponseTransactionCceetl01_1 respuesta = transactionService.invocar(RequestTransactionCceetl01_1.class, ResponseTransactionCceetl01_1.class, apxSolicitud);
        log.info("Processing DAO: ".concat(String.valueOf(respuesta)));
        // crear un objeto del tipo BDtoOutCreateChallengePost con la respuesta de la transacción
        BDtoOutCreateChallengePost bdOutChallenge = mapper.getResponse(respuesta);
        log.info("Response DAO: ".concat(String.valueOf(bdOutChallenge)));
        return bdOutChallenge;
    }

}
