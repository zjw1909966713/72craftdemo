package com.highrock.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highrock.util.BaseJsonRst;
import com.highrock.util.ResResult;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.terminal.ConnectionToken;
import com.stripe.model.terminal.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 张进文
 * @ClassName POSController
 * @Description TODO
 * @Date 2019/10/25 16:21
 * @Version 1.0
 */
@RestController
@Slf4j
@CrossOrigin
public class POSController {


    //  Stripe.
    // Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";

    @PostMapping("/connection_token")
    public JSONObject connectionToken() throws Exception{

        Stripe.apiKey = "sk_test_EJqVAJuWv4zDOfnhLLtSCUdh";

        Map<String, Object> params = new HashMap<String, Object>();
       ConnectionToken connectionToken = ConnectionToken.create(params);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("location", connectionToken.getLocation());
        jsonObject.put("object", connectionToken.getObject());
        jsonObject.put("secret", connectionToken.getSecret());


        return jsonObject;
    }


    @PostMapping("/create_payment_intent")
    public JSONObject createPaymentIntent(int amount, String currency, String description) throws Exception {

        Stripe.apiKey = "sk_test_EJqVAJuWv4zDOfnhLLtSCUdh";

        ArrayList paymentMethodTypes = new ArrayList();
        paymentMethodTypes.add("card_present");
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("payment_method_types", paymentMethodTypes);
        params.put("amount", amount);
        params.put("currency", currency);
        params.put("description", description);
        params.put("receipt_email", "jinwen_zhang@highrock.com.cn");
        params.put("capture_method", "manual");

        PaymentIntent intent = PaymentIntent.create(params);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("secret", intent.getClientSecret());

        return jsonObject;
    }


    @PostMapping("/capture_payment_intent")
    public JSONObject capture_payment_intent(String payment_intent_id) throws Exception {
        Stripe.apiKey = "sk_test_EJqVAJuWv4zDOfnhLLtSCUdh";

        PaymentIntent intent = PaymentIntent.retrieve(payment_intent_id);
        PaymentIntent capture = intent.capture();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("secret", capture.getId());

        return jsonObject;
    }


    /**
     * @description: TODO
     * @author: 张进文
     * @return: com.highrock.util.BaseJsonRst
     * @date: 2019/10/25 16:39
     * @version: 1.0
     */
    @PostMapping("/register_reader")
    public JSONObject registerPOS(@RequestParam("label") String label, @RequestParam("registration_code") String registration_code) {
        // Stripe.get

        log.info(label);
        log.info(registration_code);


        Stripe.apiKey = "sk_test_EJqVAJuWv4zDOfnhLLtSCUdh";

        Map<String, Object> params = new HashMap<>();
        params.put(
                "registration_code",
                registration_code
        );
        params.put("label", label);
        //params.put("location", "tml_1234");

        Reader reader = new Reader();
        try {
            reader = Reader.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        JSONObject object= new JSONObject();


        object.put("id",reader.getId());
        object.put("object",reader.getObject());
        object.put("device_sw_version",reader.getDeviceSwVersion());
        object.put("device_type",reader.getDeviceType());
        object.put("ip_address",reader.getIpAddress());
        object.put("label",reader.getLabel());
        object.put("location",reader.getLocation());
        object.put("serial_number",reader.getSerialNumber());
        object.put("status",reader.getStatus());


        return object;
    }
}
