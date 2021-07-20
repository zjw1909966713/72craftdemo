package com.highrock.util;

import com.alibaba.fastjson.JSON;
import com.taxjar.Taxjar;
import com.taxjar.exception.TaxjarException;
import com.taxjar.model.taxes.TaxResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张进文
 * @ClassName Raa
 * @Description TODO
 * @Date 2020/8/18 11:32
 * @Version 1.0
 */
public class Raa {
    public static void main(String[] args) {

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("apiUrl", Taxjar.SANDBOX_API_URL);

        Taxjar client = new Taxjar("4abd0c289b3e73eebf9e9fcb427e7347",paramsMap);

        try {
            Map<String, Object> params = new HashMap<>();
            params.put("from_country", "US");
            params.put("from_zip", "92093");
            params.put("from_state", "CA");
            params.put("from_city", "La Jolla");
            params.put("from_street", "9500 Gilman Drive");
            params.put("to_country", "US");
            params.put("to_zip", "90002");
            params.put("to_state", "CA");
            params.put("to_city", "Los Angeles");
            params.put("to_street", "1335 E 103rd St");
            params.put("amount", 15);
            params.put("shipping", 1.5);

            List<Map> nexusAddresses = new ArrayList();
            Map<String, Object> nexusAddress = new HashMap<>();
            nexusAddress.put("country", "US");
            nexusAddress.put("zip", "92093");
            nexusAddress.put("state", "CA");
            nexusAddress.put("city", "La Jolla");
            nexusAddress.put("street", "9500 Gilman Drive");
            nexusAddresses.add(nexusAddress);

            List<Map> lineItems = new ArrayList();
            Map<String, Object> lineItem = new HashMap<>();
            lineItem.put("id", 1);
            lineItem.put("quantity", 1);
            lineItem.put("product_tax_code", "20010");
            lineItem.put("unit_price", 15);
            lineItem.put("discount", 0);
            lineItems.add(lineItem);

            params.put("nexus_addresses", nexusAddresses);
            params.put("line_items", lineItems);

            TaxResponse res = client.taxForOrder(params);

            System.out.println(JSON.toJSONString(res));
        } catch (TaxjarException e) {
            e.printStackTrace();
        }
    }

}
