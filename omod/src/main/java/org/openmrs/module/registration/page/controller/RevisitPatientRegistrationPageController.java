package org.openmrs.module.registration.page.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.jaxen.JaxenException;
import org.openmrs.module.registration.util.RegistrationConstants;
import org.openmrs.module.registration.util.RegistrationUtils;
import org.openmrs.module.registration.web.controller.util.RegistrationWebUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Stanslaus Odhiambo
 *         Create on 1/29/2016.
 */
public class RevisitPatientRegistrationPageController {
    private static Log logger = LogFactory.getLog(RevisitPatientRegistrationPageController.class);

    public void get(HttpServletRequest request, Model model)
            throws JaxenException, DocumentException, IOException {
        model.addAttribute("patientIdentifier", RegistrationUtils.getNewIdentifier());
        model.addAttribute("referralHospitals", RegistrationWebUtils
                        .getSubConcepts(RegistrationConstants.CONCEPT_NAME_PATIENT_REFERRED_FROM));
        model.addAttribute("referralReasons", RegistrationWebUtils
                        .getSubConcepts(RegistrationConstants.CONCEPT_NAME_REASON_FOR_REFERRAL));
        RegistrationWebUtils.getAddressData(model);
        // model.addAttribute("OPDs",
        // RegistrationWebUtils.getSubConcepts(RegistrationConstants.CONCEPT_NAME_OPD_WARD));

        model.addAttribute("TEMPORARYCAT", RegistrationWebUtils
                        .getSubConcepts(RegistrationConstants.CONCEPT_NAME_MEDICO_LEGAL_CASE));
        model.addAttribute("TRIAGE", RegistrationWebUtils
                .getSubConcepts(RegistrationConstants.CONCEPT_NAME_TRIAGE));
        model.addAttribute("OPDs", RegistrationWebUtils
                        .getSubConcepts(RegistrationConstants.CONCEPT_NAME_OPD_WARD));

    }


}
